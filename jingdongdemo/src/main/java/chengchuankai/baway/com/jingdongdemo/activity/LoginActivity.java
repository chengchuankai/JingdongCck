package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;

import java.util.HashMap;
import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.LoginBean;
import chengchuankai.baway.com.jingdongdemo.precenter.LoginPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.utils.ShareUtil;
import chengchuankai.baway.com.jingdongdemo.view.LoginView;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener, LoginView {

    /**
     * ×
     */
    private TextView mBack;
    /**
     * 京东登录
     */
    private TextView mTextView;
    /**
     * 请输入账号
     */
    private EditText mEtUser;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    /**
     * 登录
     */
    private Button mBtLogin;
    /**
     * 立即注册
     */
    private TextView mTvRegister;
    /**
     * 忘记密码
     */
    private TextView mTvForget;
    private Object token;
    private ImageView iv_login;
    private ShareUtil shareUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        shareUtil = new ShareUtil(this);
        setContentView(R.layout.activity_login);
        initView();

        iv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auto();
            }
        });
    }

    private void initView() {
        iv_login = (ImageView) findViewById(R.id.iv_login);
        mBack = (TextView) findViewById(R.id.back);
        mBack.setOnClickListener(this);
        mTextView = (TextView) findViewById(R.id.textView);
        mTextView.setOnClickListener(this);
        mEtUser = (EditText) findViewById(R.id.et_user);
        mEtUser.setOnClickListener(this);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mEtPwd.setOnClickListener(this);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        mTvForget = (TextView) findViewById(R.id.tv_forget);
        mTvForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back:
                finish();
                break;
            case R.id.textView:
                break;
            case R.id.et_user:
                break;
            case R.id.et_pwd:
                break;
            case R.id.bt_login:
                String user = mEtUser.getText().toString();
                String pwd = mEtPwd.getText().toString();
                HashMap<String, String> map = new HashMap<>();
                map.put("mobile", user);
                map.put("password", pwd);
                LoginPrecenterImpl loginPrecenter = new LoginPrecenterImpl(this);
                loginPrecenter.getLoginMap(map);
                break;
            case R.id.tv_register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_forget:
                break;

        }
    }

    //授权
    private void auto() {
        //伪授权 既授权又能获取用户信息
        //UMShareAPI.get(this).getPlatformInfo(this, SHARE_MEDIA.QQ, uMAuthListener);
        UMShareAPI.get(this).doOauthVerify(this, SHARE_MEDIA.QQ, uMAuthListener);
    }

    private void cancleAuth() {
        UMShareAPI.get(this).deleteOauth(this, SHARE_MEDIA.QQ, uMAuthListener);
    }

    private UMAuthListener uMAuthListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Toast.makeText(getApplicationContext(), "开始授权", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
            if (data != null && data.size() > 0) {
                String temp = "";
                for (String key : data.keySet()) {
                    temp = temp + key + " : " + data.get(key) + "\n";
                }
                Toast.makeText(getApplicationContext(), temp, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplicationContext(), "成功", Toast.LENGTH_SHORT).show();
            }

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            Toast.makeText(getApplicationContext(), "onRestoreInstanceState Authorize onError", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            Toast.makeText(getApplicationContext(), "onRestoreInstanceState Authorize onCancel", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }


    @Override
    public void ShowLoginView(LoginBean loginBean) {
        token = loginBean.getData().getToken();
        int uid = loginBean.getData().getUid();
        SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString("token", token.toString());
        edit.putInt("uid", uid);
        edit.commit();
        Log.i("xxx", token + "    " + uid);
        Toast.makeText(LoginActivity.this, token.toString(), Toast.LENGTH_SHORT).show();
        if (loginBean.getCode().equals("0")) {
            Toast.makeText(LoginActivity.this, "成功", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(LoginActivity.this, "登录失败", Toast.LENGTH_LONG).show();
        }

    }
}
