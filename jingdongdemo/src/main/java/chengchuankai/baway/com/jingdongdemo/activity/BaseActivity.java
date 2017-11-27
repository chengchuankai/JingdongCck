package chengchuankai.baway.com.jingdongdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import chengchuankai.baway.com.jingdongdemo.R;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
    }
}
