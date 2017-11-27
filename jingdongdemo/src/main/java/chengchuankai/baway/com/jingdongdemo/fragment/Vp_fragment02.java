package chengchuankai.baway.com.jingdongdemo.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import java.util.HashMap;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.XiangQingView;

/**
 * Created by C-PC on 2017/11/8.
 */

public class Vp_fragment02 extends Fragment implements XiangQingView {
    private View view;
    private WebView mWeb;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vp_fragment02, null);
        Intent intent = getActivity().getIntent();
        String pid = intent.getStringExtra("pid");
        XiangQingPrecenter xiangQingPrecenter = new XiangQingPrecenterImpl(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("pid", pid);
        xiangQingPrecenter.guanlian(map);
        initView(view);
        return view;
    }

    @Override
    public void showData(XiangQingBean xiangQingBean) {
        String detailUrl = xiangQingBean.getData().getDetailUrl();
        mWeb.getSettings().setJavaScriptEnabled(true);
        mWeb.loadUrl(detailUrl);

    }

    private void initView(View view) {
        mWeb = (WebView) view.findViewById(R.id.web);
    }
}
