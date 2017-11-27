package chengchuankai.baway.com.jingdongdemo.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.hjm.bottomtabbar.BottomTabBar;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment01;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment02;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment03;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment04;
import chengchuankai.baway.com.jingdongdemo.fragment.fragment05;

public class MainActivity extends AppCompatActivity {

    private FrameLayout fl;
    private ImageView iv_find;
    private ImageView iv_shopcar;
    private ImageView iv_my;
    private ImageView iv_fenlei;
    private ImageView iv_shouye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       /* initView();
        initEvents();*/
    /*    FragmentTransaction fragmentContainer = getSupportFragmentManager().beginTransaction();
        fragmentContainer.replace(R.id.fl, new fragment01());
        fragmentContainer.commit();
        iv_shouye.setImageResource(R.mipmap.ac1);*/

        BottomTabBar btb= (BottomTabBar) findViewById(R.id.btb);
        btb.init(getSupportFragmentManager())
                .setImgSize(120, 120)
                .setFontSize(0)
                .setTabPadding(0, 0, 0)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("首页", R.drawable.zhu1, fragment01.class)
                .addTabItem("分类", R.drawable.zhu2, fragment02.class)
                .addTabItem("发现", R.drawable.zhu3, fragment03.class)
                .addTabItem("购物车", R.drawable.zhu4, fragment04.class)
                .addTabItem("我的", R.drawable.zhu5, fragment05.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });




    }


  /*  private void initView() {
        fl = (FrameLayout) findViewById(R.id.fl);
        iv_find = (ImageView) findViewById(R.id.iv_find);
        iv_shopcar = (ImageView) findViewById(R.id.iv_shopcar);
        iv_my = (ImageView) findViewById(R.id.iv_my);
        iv_fenlei = (ImageView) findViewById(R.id.iv_fenlei);
        iv_shouye = (ImageView) findViewById(R.id.iv_shouye);
    }

    private void initEvents() {
        fl.setOnClickListener(this);
        iv_find.setOnClickListener(this);
        iv_shopcar.setOnClickListener(this);
        iv_my.setOnClickListener(this);
        iv_fenlei.setOnClickListener(this);
        iv_shouye.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        reset();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.iv_shouye:
                fragmentTransaction.replace(R.id.fl, new fragment01());
                fragmentTransaction.commit();
                iv_shouye.setImageResource(R.mipmap.ac1);
                break;
            case R.id.iv_fenlei:
                fragmentTransaction.replace(R.id.fl, new fragment02());
                fragmentTransaction.commit();
                iv_fenlei.setImageResource(R.mipmap.abx);
                break;
            case R.id.iv_find:
                fragmentTransaction.replace(R.id.fl, new fragment03());
                fragmentTransaction.commit();
                iv_find.setImageResource(R.mipmap.abz);
                break;
            case R.id.iv_shopcar:
                fragmentTransaction.replace(R.id.fl, new fragment04());
                fragmentTransaction.commit();
                iv_shopcar.setImageResource(R.mipmap.abv);
                break;
            case R.id.iv_my:
                fragmentTransaction.replace(R.id.fl, new fragment05());
                fragmentTransaction.commit();
                iv_my.setImageResource(R.mipmap.ac3);
                break;
        }
    }


    public void reset() {
        iv_shouye.setImageResource(R.mipmap.ac0);
        iv_fenlei.setImageResource(R.mipmap.abw);
        iv_find.setImageResource(R.mipmap.aby);
        iv_shopcar.setImageResource(R.mipmap.abu);
        iv_my.setImageResource(R.mipmap.ac2);
    }*/
}
