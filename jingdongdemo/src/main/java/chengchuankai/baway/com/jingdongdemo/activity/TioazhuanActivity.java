package chengchuankai.baway.com.jingdongdemo.activity;


import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment04;

public class TioazhuanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tioazhuan);
        FrameLayout fl = (FrameLayout) findViewById(R.id.fl);
        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction replace = fragmentManager.beginTransaction().replace(R.id.fl, new fragment04());
        replace.commit();
    }
}
