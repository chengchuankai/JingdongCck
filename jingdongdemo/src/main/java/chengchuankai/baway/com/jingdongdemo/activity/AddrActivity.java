package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.AddrBean;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;

public class AddrActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * 请输入姓名
     */
    private EditText mEtName;
    /**
     * 请输入手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入地址
     */
    private EditText mEtAddr;
    /**
     * 添加
     */
    private Button mBtAdd;
    private HashMap<String, String> map2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addr);
        initView();




    }

    private void initView() {
        mEtName = (EditText) findViewById(R.id.et_name);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtAddr = (EditText) findViewById(R.id.et_addr);
        mBtAdd = (Button) findViewById(R.id.bt_add);
        mBtAdd.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_add:
                String name = mEtName.getText().toString().trim();
                String phone = mEtPhone.getText().toString().trim();
                String addr = mEtAddr.getText().toString().trim();
                SharedPreferences sharedPreferences2 = getSharedPreferences("token", MODE_PRIVATE);
                String token = sharedPreferences2.getString("token", null);
                int uid0 = sharedPreferences2.getInt("uid", 0);
                String uid = String.valueOf(uid0);
                map2 = new HashMap<>();
                map2.put("uid", uid);
                map2.put("addr", addr);
                map2.put("mobile",phone);
                map2.put("name", name);
                map2.put("token", token);
                HttpUtils.getInstance().doPost(ApiUrl.ADDR, map2, AddrBean.class, new OnNetListener() {
                    @Override
                    public void onSuccess(BaseBean baseBean) {
                        AddrBean addrBean = (AddrBean) baseBean;
                        Toast.makeText(AddrActivity.this,addrBean.getMsg(),Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onError() {

                    }
                });
                break;
        }
    }
}
