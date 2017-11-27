package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.HashMap;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.CreateDdbean;
import chengchuankai.baway.com.jingdongdemo.bean.GetAddrBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.CreatePresenter;
import chengchuankai.baway.com.jingdongdemo.precenter.CreatePresenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.CreateView;

public class CreateDDActivity extends AppCompatActivity implements CreateView, View.OnClickListener {

    private String price;
    private String token;
    private String uid;
    private String pid;
    private String images1;
    private SimpleDraweeView mIv;
    /**
     * 111
     */
    private TextView mTv1;
    /**
     * 222
     */
    private TextView mTv2;
    private String title;
    /**
     * 程传凯
     */
    private TextView mTvName;
    /**
     * 123123213
     */
    private TextView mTvPhone;
    /**
     * 地址
     */
    private TextView mTvAddr;
    /**
     * 结算
     */
    private Button mBt;
    /**
     * 添加收货地址
     */
    private TextView mAddAddr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_dd);
        initView();
        Intent intent = getIntent();
        price = intent.getStringExtra("price");
        title = intent.getStringExtra("title");
        images1 = intent.getStringExtra("images1");
        SharedPreferences sharedPreferences2 = getSharedPreferences("token", MODE_PRIVATE);
        token = sharedPreferences2.getString("token", null);
        int uid0 = sharedPreferences2.getInt("uid", 0);
        pid = sharedPreferences2.getString("pid", null);
        uid = String.valueOf(uid0);
        HashMap<String, String> map = new HashMap<>();
        CreatePresenter createPresenter = new CreatePresenterImpl(this);
        map.put("token", token);
        map.put("uid", uid);
        map.put("price", price);
        createPresenter.GuanlianM(map);
        mTv1.setText(this.title);
        mTv2.setText(price);
        String[] split = images1.split("\\|");
        String s = split[0];
        Uri uri = Uri.parse(s);
        Log.i("uri", uri + "");
        mIv.setImageURI(uri);
        SharedPreferences sharedPreferences3 = getSharedPreferences("token", MODE_PRIVATE);
        String token3 = sharedPreferences3.getString("token", null);
        int uid2 = sharedPreferences3.getInt("uid", 0);
        String uid3 = String.valueOf(uid2);
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("token", token3);
        map3.put("uid", uid3);
        HttpUtils.getInstance().doPost(ApiUrl.GETADDR, map3, GetAddrBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                GetAddrBean getAddrBean= (GetAddrBean) baseBean;
                String addr = getAddrBean.getData().get(0).getAddr();
                long phone0 = getAddrBean.getData().get(0).getMobile();
                String phone = String.valueOf(phone0);
                String name = getAddrBean.getData().get(0).getName();
                mTvName.setText(name);
                mTvAddr.setText(addr);
                mTvPhone.setText(phone);
            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void showData(CreateDdbean createDdbean) {
        String msg = createDdbean.getMsg();
        Toast.makeText(CreateDDActivity.this, msg, Toast.LENGTH_SHORT).show();

    }


    private void initView() {
        mIv = (SimpleDraweeView) findViewById(R.id.iv);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mTvName = (TextView) findViewById(R.id.tv_name);
        mTvPhone = (TextView) findViewById(R.id.tv_phone);
        mTvAddr = (TextView) findViewById(R.id.tv_addr);
        mTv1.setOnClickListener(this);
        mTv2.setOnClickListener(this);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
        mAddAddr = (TextView) findViewById(R.id.add_addr);
        mAddAddr.setOnClickListener(this);
        mIv.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv1:
                break;
            case R.id.tv2:
                break;
            case R.id.bt:
                Intent intent2=new Intent(CreateDDActivity.this,ZhiFuActivity.class);
                startActivity(intent2);
                break;
            case R.id.add_addr:
                Intent intent=new Intent(CreateDDActivity.this,AddrActivity.class);
                startActivity(intent);
                break;
            case R.id.iv:
                break;
        }
    }
}
