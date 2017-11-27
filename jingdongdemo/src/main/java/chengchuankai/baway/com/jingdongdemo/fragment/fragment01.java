package chengchuankai.baway.com.jingdongdemo.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.acker.simplezxing.activity.CaptureActivity;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.BannerClass;
import chengchuankai.baway.com.jingdongdemo.adapter.ChaoShiAdapter;
import chengchuankai.baway.com.jingdongdemo.adapter.MiaoShaAdapter;
import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;
import chengchuankai.baway.com.jingdongdemo.bean.ImageBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;

/**
 * Created by C-PC on 2017/10/31.
 */

public class fragment01 extends Fragment {

    private Banner banner;
    private List<String> list = new ArrayList<>();
    private RecyclerView rv;
    private List<ImageBean.DataBean> datalist;
    private ImageBean imageBean;
    private RecyclerView rv_miaosha;
    private ImageView imageView;
    private static final int REQ_CODE_PERMISSION = 0x1111;
    private TextView textView3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment01, null);
        banner = view.findViewById(R.id.banner);
        imageView = view.findViewById(R.id.imageView);
        textView3 = view.findViewById(R.id.textView3);
        rv = view.findViewById(R.id.rv);
        rv_miaosha = view.findViewById(R.id.rv_miaosha);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Open Scan Activity
                if (ContextCompat.checkSelfPermission(getActivity(), Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    // Do not have the permission of camera, request it.
                    ActivityCompat.requestPermissions(getActivity(), new String[]{Manifest.permission.CAMERA}, REQ_CODE_PERMISSION);
                } else {
                    // Have gotten the permission
                    startCaptureActivityForResult();
                }


            }
        });

        //list.add("http://120.27.23.105/images/ad/0.jpg");
        getNetImage();
        //Rv的方法
        getRvView();
        //秒杀
        getMiaosha();
        return view;
    }

   private void startCaptureActivityForResult() {
        Intent intent = new Intent(getActivity(), CaptureActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(CaptureActivity.KEY_NEED_BEEP, CaptureActivity.VALUE_BEEP);
        bundle.putBoolean(CaptureActivity.KEY_NEED_VIBRATION, CaptureActivity.VALUE_VIBRATION);
        bundle.putBoolean(CaptureActivity.KEY_NEED_EXPOSURE, CaptureActivity.VALUE_NO_EXPOSURE);
        bundle.putByte(CaptureActivity.KEY_FLASHLIGHT_MODE, CaptureActivity.VALUE_FLASHLIGHT_OFF);
        bundle.putByte(CaptureActivity.KEY_ORIENTATION_MODE, CaptureActivity.VALUE_ORIENTATION_AUTO);
        bundle.putBoolean(CaptureActivity.KEY_SCAN_AREA_FULL_SCREEN, CaptureActivity.VALUE_SCAN_AREA_FULL_SCREEN);
        bundle.putBoolean(CaptureActivity.KEY_NEED_SCAN_HINT_TEXT, CaptureActivity.VALUE_SCAN_HINT_TEXT);
        intent.putExtra(CaptureActivity.EXTRA_SETTING_BUNDLE, bundle);
        startActivityForResult(intent, CaptureActivity.REQ_CODE);
    }

   /*  @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case REQ_CODE_PERMISSION: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    // User agree the permission
                    startCaptureActivityForResult();
                } else {
                    // User disagree the permission
                    Toast.makeText(getActivity(), "You must agree the camera permission request before you use the code scan function", Toast.LENGTH_LONG).show();
                }
            }
            break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CaptureActivity.REQ_CODE:
                switch (resultCode) {
                    case RESULT_OK:
                        textView3.setText(data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));  //or do sth
                        break;
                    case RESULT_CANCELED:
                        if (data != null) {
                            // for some reason camera is not working correctly
                            textView3.setText(data.getStringExtra(CaptureActivity.EXTRA_SCAN_RESULT));
                        }
                        break;
                }
                break;
        }
    }*/


    //无限轮播
    public void getNetImage() {
        HttpUtils.getInstance().doget(ApiUrl.ImageTUPIAN, ImageBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                imageBean = (ImageBean) baseBean;
                datalist = imageBean.getData();
                for (int i = 0; i < datalist.size(); i++) {
                    ImageBean.DataBean dataBean = datalist.get(i);
                    String icon = dataBean.getIcon();
                    list.add(icon);
                }
                banner.setImageLoader(new BannerClass());
                banner.setImages(list);
                //设置自动轮播，默认为true
                banner.isAutoPlay(true);
                //设置轮播时间
                banner.setDelayTime(3000);
                //设置指示器位置（当banner模式中有指示器时）
                banner.setIndicatorGravity(BannerConfig.CENTER);
                banner.start();
            }

            @Override
            public void onError() {

            }
        });
    }


    //京东超市
    public void getRvView() {
        HttpUtils.getInstance().doget(ApiUrl.CHAOSHI, ChaoShiBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                ChaoShiBean chaoShiBean = (ChaoShiBean) baseBean;
                List<ChaoShiBean.DataBean> data = chaoShiBean.getData();
                rv.setLayoutManager(new GridLayoutManager(getActivity(), 5));
                ChaoShiAdapter adapter = new ChaoShiAdapter(getActivity(), data);
                rv.setAdapter(adapter);
            }

            @Override
            public void onError() {

            }
        });
    }

    //秒杀
    public void getMiaosha() {
        HttpUtils.getInstance().doget(ApiUrl.ImageTUPIAN, ImageBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                ImageBean imageBean = (ImageBean) baseBean;
                List<ImageBean.TuijianBean.ListBean> list = imageBean.getTuijian().getList();
                rv_miaosha.setLayoutManager(new GridLayoutManager(getActivity(), 2));
                MiaoShaAdapter adapter = new MiaoShaAdapter(getActivity(), list);
                rv_miaosha.setAdapter(adapter);
            }

            @Override
            public void onError() {

            }
        });


    }

}
