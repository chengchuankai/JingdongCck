package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import chengchuankai.baway.com.jingdongdemo.R;

public class FindUserActivity extends AppCompatActivity implements View.OnClickListener {

    /**
     * ×
     */
    private TextView mBack;
    /**
     * 账号设置
     */
    private TextView mTextView;
    private ImageView mIv;
    /**
     * 111
     */
    private TextView mTv1;
    /**
     * 222
     */
    private TextView mTv2;
    /**
     * 退出登录
     */
    private Button mBt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_user);
        initView();
        TextView tv_back = (TextView) findViewById(R.id.back);
        tv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });


    }

    private void initView() {
        mBack = (TextView) findViewById(R.id.back);
        mTextView = (TextView) findViewById(R.id.textView);
        mIv = (ImageView) findViewById(R.id.iv);
        mTv1 = (TextView) findViewById(R.id.tv1);
        mTv2 = (TextView) findViewById(R.id.tv2);
        mBt = (Button) findViewById(R.id.bt);
        mBt.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt:
                SharedPreferences sharedPreferences=getSharedPreferences("token",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.clear();
                edit.commit();
                finish();
                break;
        }
    }
}
