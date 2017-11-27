package chengchuankai.baway.com.jingdongdemo.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Toast;

import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.media.UMWeb;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.AddShopCarBean;
import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;
import chengchuankai.baway.com.jingdongdemo.fragment.Vp_fragment01;
import chengchuankai.baway.com.jingdongdemo.fragment.Vp_fragment02;
import chengchuankai.baway.com.jingdongdemo.fragment.Vp_fragment03;
import chengchuankai.baway.com.jingdongdemo.precenter.AddShopCarPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.AddShopCarPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.AddshopCarView;
import chengchuankai.baway.com.jingdongdemo.view.XiangQingView;

import static chengchuankai.baway.com.jingdongdemo.R.id.vp;

public class XiangQingActivity extends FragmentActivity implements XiangQingView, View.OnClickListener, AddshopCarView {

    private String pid;
    /**
     * 商品
     */
    private Button mBt1;
    /**
     * 详情
     */
    private Button mBt2;
    /**
     * 评价
     */
    private Button mBt3;
    private ViewPager mVp;
    /**
     * 加入购物车
     */
    private Button mGoodsdetailBt;
    private Button bt_shopcar;
    private ImageView fenxiang;
    private String images;
    private XiangQingBean.DataBean data;
    private ImageView mFenxiang;
    /**
     * 购物车
     */
    private RadioButton mBtShopcar;
    /**
     * 立即购买
     */
    private Button mBtPay;
    private String price;
    private String title;
    private String images1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
        initView();
        Intent intent = getIntent();
        pid = intent.getStringExtra("pid");

        XiangQingPrecenter xiangQingPrecenter = new XiangQingPrecenterImpl(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        xiangQingPrecenter.guanlian(map);
        final List<Fragment> list = new ArrayList<>();
        list.add(new Vp_fragment01());
        list.add(new Vp_fragment02());
        list.add(new Vp_fragment03());
        mBt1.setTextColor(Color.RED);
        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });

        mVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBt1.setTextColor(Color.BLACK);
                mBt2.setTextColor(Color.BLACK);
                mBt3.setTextColor(Color.BLACK);
                switch (position) {
                    case 0:
                        mBt1.setTextColor(Color.RED);
                        break;
                    case 1:
                        mBt2.setTextColor(Color.RED);
                        break;
                    case 2:
                        mBt3.setTextColor(Color.RED);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        fenxiang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ShareWeb(R.mipmap.icon);
            }
        });


    }


    @Override
    public void showData(XiangQingBean xiangQingBean) {
        data = xiangQingBean.getData();
        images = data.getImages();
        double price0 = xiangQingBean.getData().getPrice();
        price = String.valueOf(price0);
        title = xiangQingBean.getData().getTitle();
        images1 = xiangQingBean.getData().getImages();
    }


    private void initView() {
        fenxiang = findViewById(R.id.fenxiang);
        mBt1 = (Button) findViewById(R.id.bt1);
        mBt2 = (Button) findViewById(R.id.bt2);
        mBt3 = (Button) findViewById(R.id.bt3);
        mVp = (ViewPager) findViewById(vp);
        mGoodsdetailBt = (Button) findViewById(R.id.goodsdetail_bt);
        bt_shopcar = findViewById(R.id.bt_shopcar);
        mBt1.setOnClickListener(this);
        mBt2.setOnClickListener(this);
        mBt3.setOnClickListener(this);
        mVp.setOnClickListener(this);
        mGoodsdetailBt.setOnClickListener(this);
        bt_shopcar.setOnClickListener(this);
        mFenxiang = (ImageView) findViewById(R.id.fenxiang);
        mVp = (ViewPager) findViewById(R.id.vp);
        mBtShopcar = (RadioButton) findViewById(R.id.bt_shopcar);
        mBtPay = (Button) findViewById(R.id.bt_pay);
        mBtPay.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        mBt1.setTextColor(Color.BLACK);
        mBt2.setTextColor(Color.BLACK);
        mBt3.setTextColor(Color.BLACK);
        switch (v.getId()) {
            case R.id.bt1:
                mVp.setCurrentItem(0);
                mBt1.setTextColor(Color.RED);
                break;
            case R.id.bt2:
                mVp.setCurrentItem(1);
                mBt2.setTextColor(Color.RED);
                break;
            case R.id.bt3:
                mVp.setCurrentItem(2);
                mBt3.setTextColor(Color.RED);
                break;
            case vp:
                break;
            case R.id.goodsdetail_bt:
                //点击加入购物车
                SharedPreferences sharedPreferences = getSharedPreferences("token", MODE_PRIVATE);
                String token = sharedPreferences.getString("token", null);
                int uid0 = sharedPreferences.getInt("uid", 0);
                String uid = String.valueOf(uid0);
                if (token != null && token.length() > 0) {
                    HashMap<String, String> map = new HashMap<>();
                    map.put("token", token);
                    map.put("uid", uid);
                    map.put("pid", pid);
                    AddShopCarPrecenter addShopCarPrecenter = new AddShopCarPrecenterImpl(this);
                    addShopCarPrecenter.GuanlianM(map);
                } else {
                    Toast.makeText(XiangQingActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.bt_shopcar:
                Intent intent = new Intent(XiangQingActivity.this, TioazhuanActivity.class);
                startActivity(intent);
                finish();
            case R.id.bt_pay:
                SharedPreferences sharedPreferences2 = getSharedPreferences("token", MODE_PRIVATE);
                String token0 = sharedPreferences2.getString("token", null);
                int uid1 = sharedPreferences2.getInt("uid", 0);
                String uid2 = String.valueOf(uid1);
                if (token0 != null && token0.length() > 0) {
                    Intent intent1=new Intent(XiangQingActivity.this,CreateDDActivity.class);
                    intent1.putExtra("pid",pid);
                    intent1.putExtra("price",price);
                    intent1.putExtra("title",title);
                    intent1.putExtra("images1",images1);
                    startActivity(intent1);

                } else {
                    Toast.makeText(XiangQingActivity.this, "请先登录", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    public void showData(AddShopCarBean addShopCarBean) {
        String msg = addShopCarBean.getMsg();
        Toast.makeText(XiangQingActivity.this, msg, Toast.LENGTH_SHORT).show();
    }

    private void ShareWeb(int thumb_img) {
        UMImage thumb = new UMImage(this, thumb_img);
        UMWeb web = new UMWeb(data.getDetailUrl());
        web.setThumb(thumb);
        web.setDescription("测试分享");
        web.setTitle(data.getTitle());
        new ShareAction(this).withMedia(web).setPlatform(SHARE_MEDIA.QZONE).setCallback(shareListener).share();
    }

    private UMShareListener shareListener = new UMShareListener() {
        /**
         * @descrption 分享开始的回调
         * @param platform 平台类型
         */
        @Override
        public void onStart(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this, "分享开始", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享成功的回调
         * @param platform 平台类型
         */
        @Override
        public void onResult(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this, "成功了", Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享失败的回调
         * @param platform 平台类型
         * @param t 错误原因
         */
        @Override
        public void onError(SHARE_MEDIA platform, Throwable t) {
            Toast.makeText(XiangQingActivity.this, "失败" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        /**
         * @descrption 分享取消的回调
         * @param platform 平台类型
         */
        @Override
        public void onCancel(SHARE_MEDIA platform) {
            Toast.makeText(XiangQingActivity.this, "取消了", Toast.LENGTH_LONG).show();

        }
    };


}

