package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.adapter.ListCommAdapter;
import chengchuankai.baway.com.jingdongdemo.bean.Commodity;
import chengchuankai.baway.com.jingdongdemo.precenter.CommodityPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.CommodityPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.CommodityView;

public class ListCommodityActivity extends AppCompatActivity implements CommodityView {

    private ImageView mBack;
    private EditText mEditText2;
    private TextView mIvRecyclerView;
    private RecyclerView mRvList;
    private List<Commodity.DataBean> data;
    int image = R.mipmap.kind_liner;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_commodity);
        tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String trim = tv.getText().toString().trim();
                if ("网格".equals(trim)) {
                    show(true);
                    tv.setText("垂直");
                } else {
                    show(false);
                    tv.setText("网格");
                }
            }
        });
        initView();
        Intent intent = getIntent();
        String pscid = intent.getStringExtra("pscid");
        //Toast.makeText(this,pscid,Toast.LENGTH_SHORT).show();
        HashMap<String, String> map = new HashMap<>();
        map.put("pscid", pscid);
        CommodityPrecenter commodityPrecenter = new CommodityPrecenterImpl(this);
        commodityPrecenter.GuanlianM(map);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }


    @Override
    public void showData(Commodity commodity) {
        data = commodity.getData();
        // Toast.makeText(this, data.toString(), Toast.LENGTH_SHORT).show();
        //mRvList.setLayoutManager(new LinearLayoutManager(this));
        show(true);
        ListCommAdapter adapter = new ListCommAdapter(ListCommodityActivity.this, data);
        mRvList.setAdapter(adapter);
        adapter.SetOnDianJiListener(new ListCommAdapter.OnDianJiListener() {
            @Override
            public void onChildItemClick(Commodity.DataBean dataBean) {
                int pid = dataBean.getPid();
                String pid0 = String.valueOf(pid);
                Intent intent = new Intent(ListCommodityActivity.this, XiangQingActivity.class);
                intent.putExtra("pid", pid0);
                startActivity(intent);
            }
        });
    }

    private void initView() {
        mBack = (ImageView) findViewById(R.id.back);

        mEditText2 = (EditText) findViewById(R.id.editText2);

        mRvList = (RecyclerView) findViewById(R.id.rv_list);

    }



    private void show(boolean flag) {
        //设置布局管理器
        //垂直列表
        // rv.setLayoutManager(new LinearLayoutManager(this));
        //网格模式
        // rv.setLayoutManager(new GridLayoutManager(this, 2));
        //添加垂直分割线
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        //水平分割线
        RecyclerView.LayoutManager layoutManager = null;
        if (flag) {
            layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        } else {
            layoutManager = new GridLayoutManager(this, 2);
        }
        mRvList.setLayoutManager(layoutManager);
        mRvList.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL));
        //横向列表false是从左往右，ture是从右往左
        // rv.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
    }
}
