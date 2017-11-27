package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.adapter.DingDanAdapter;
import chengchuankai.baway.com.jingdongdemo.bean.DingDanBean;
import chengchuankai.baway.com.jingdongdemo.precenter.DingDanPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.DingDanPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.DingDanView;

import static chengchuankai.baway.com.jingdongdemo.R.id.rv;

public class DingDanActivity extends AppCompatActivity implements DingDanView {

    /**
     * ×
     */
    private TextView mBack;
    /**
     * 订单
     */
    private TextView mTextView;
    private RecyclerView mRv;
    private Button bt_pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ding_dan);
        initView();
        SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
        String token = sharedPreferences.getString("token", null);
        int uid0 = sharedPreferences.getInt("uid", 0);
        String uid = String.valueOf(uid0);
        final DingDanPrecenter dingDanPrecenter = new DingDanPrecenterImpl(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("uid", uid);
        dingDanPrecenter.GuanlianM(map);
/*        bt_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              *//*  Intent intent=new Intent(DingDanActivity.this,ZhiFuActivity.class);
                startActivity(intent);*//*
            }
        });*/
    }

    @Override
    public void showData(DingDanBean dingDanBean) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRv.setLayoutManager(linearLayoutManager);
        String msg = dingDanBean.getMsg();
        List<DingDanBean.DataBean> data = dingDanBean.getData();
        Toast.makeText(DingDanActivity.this, msg, Toast.LENGTH_SHORT).show();
        DingDanAdapter adapter = new DingDanAdapter(data, DingDanActivity.this);
        mRv.setAdapter(adapter);
    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.back);
        mTextView = (TextView) findViewById(R.id.textView);
        mRv = (RecyclerView) findViewById(rv);
        bt_pay = (Button) findViewById(R.id.bt_pay);
    }
}
