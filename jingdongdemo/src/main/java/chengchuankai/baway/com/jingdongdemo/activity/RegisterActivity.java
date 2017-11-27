package chengchuankai.baway.com.jingdongdemo.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;
import chengchuankai.baway.com.jingdongdemo.precenter.ZhucePrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.ZhucePrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.ZhuceView;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,ZhuceView{

    private ZhucePrecenter precenter;
    /**
     * ×
     */
    private TextView mBack;
    /**
     * 京东注册
     */
    private TextView mTextView;
    /**
     * 请输入账号
     */
    private EditText mEtRegisterUser;
    /**
     * 请输入密码
     */
    private EditText mEtRegisterPwd;
    /**
     * 注册
     */
    private Button mBtRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();




    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setOnClickListener(this);
        mEtRegisterUser = (EditText) findViewById(R.id.et_register_user);
        mEtRegisterUser.setOnClickListener(this);
        mEtRegisterPwd = (EditText) findViewById(R.id.et_register_pwd);
        mEtRegisterPwd.setOnClickListener(this);
        mBtRegister = (Button) findViewById(R.id.bt_register);
        mBtRegister.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.textView:
                break;
            case R.id.et_register_user:
                break;
            case R.id.et_register_pwd:
                break;
            case R.id.bt_register:
                precenter = new ZhucePrecenterImpl(this);
                HashMap<String,String> map=new HashMap<>();
                String user = mEtRegisterUser.getText().toString();
                String pwd = mEtRegisterPwd.getText().toString();
                map.put("mobile",user);
                map.put("password",pwd);
                precenter.connectMzhuce(map);
                break;
        }
    }


    @Override
    public void setData(ResgterBean resgterBean) {
        if (resgterBean.getCode().equals("0")) {
            Log.i("ttt",resgterBean.getMsg());
            Toast.makeText(RegisterActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(RegisterActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
        }

    }
}
