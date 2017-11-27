package chengchuankai.baway.com.jingdongdemo.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.BannerClass;
import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.XiangQingView;

/**
 * Created by C-PC on 2017/11/8.
 */

public class Vp_fragment01 extends Fragment implements XiangQingView {

    private Banner banner;
    private TextView tv1;
    private TextView tv2;
    private TextView tv3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_fragment01, null);
        banner = view.findViewById(R.id.banner);
        tv1 = view.findViewById(R.id.tv1);
        tv2 = view.findViewById(R.id.tv2);
        tv3 = view.findViewById(R.id.tv3);
        Intent intent = getActivity().getIntent();
        String pid = intent.getStringExtra("pid");
        XiangQingPrecenter xiangQingPrecenter = new XiangQingPrecenterImpl(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        xiangQingPrecenter.guanlian(map);
        return view;
    }


    @Override
    public void showData(XiangQingBean xiangQingBean) {
        XiangQingBean.DataBean data = xiangQingBean.getData();
        double price = data.getPrice();
        Toast.makeText(getActivity(),price+"",Toast.LENGTH_SHORT).show();
        String images = data.getImages();
        String[] split = images.split("\\|");
        //String s = split[0];
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < split.length; i++) {
            String s = split[i];
            list.add(s);
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
        tv1.setText(data.getTitle());
        tv2.setText(data.getSubhead());
        tv3.setText(data.getPrice()+"");

    }

}
