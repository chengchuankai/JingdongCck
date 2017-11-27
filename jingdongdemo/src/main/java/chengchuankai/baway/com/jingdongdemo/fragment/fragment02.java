package chengchuankai.baway.com.jingdongdemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.adapter.FenLeiARv2dapter;
import chengchuankai.baway.com.jingdongdemo.adapter.FenleiAdapter;
import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;
import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;
import chengchuankai.baway.com.jingdongdemo.precenter.FenLeiLeftPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.precenter.FenLeiRightPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.FenLeiRightPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.FenLeiLeftView;
import chengchuankai.baway.com.jingdongdemo.view.FenleiRightView;

/**
 * Created by C-PC on 2017/10/31.
 */

public class fragment02 extends Fragment implements FenLeiLeftView, FenleiRightView {

    private RecyclerView rv;
    private RecyclerView rv2;
    private FenleiAdapter adapter;
    private int cid;
    private List<FenleiIMPL.DataBean> data;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment02, null);
        //设置成布局管理器
        rv = view.findViewById(R.id.rv);
        rv2 = view.findViewById(R.id.rv2);
        //请求左边的数据
        getLeftdata();
        return view;
    }

    @Override
    public void ShowFenLeiView(ChaoShiBean chaoShiBean) {

        adapter = new FenleiAdapter(getActivity(), chaoShiBean);
        rv.setAdapter(adapter);

        int cid = chaoShiBean.getData().get(0).getCid();
        String s = String.valueOf(cid);
        FenLeiRightPrecenter precenter = new FenLeiRightPrecenterImpl(fragment02.this);
        HashMap<String, String> map = new HashMap<>();
        String cid0 = String.valueOf(fragment02.this.cid);
        map.put("cid",s);
        precenter.guanlian(map);

        adapter.setOnItemListener(new FenleiAdapter.OnItemListener() {
            @Override
            public void onItemListener(ChaoShiBean.DataBean dataBean) {
                fragment02.this.cid = dataBean.getCid();
                FenLeiRightPrecenter precenter = new FenLeiRightPrecenterImpl(fragment02.this);
                HashMap<String, String> map = new HashMap<>();
                String cid0 = String.valueOf(fragment02.this.cid);
                map.put("cid", cid0);
                precenter.guanlian(map);
            }
        });
    }

    private void getLeftdata() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(linearLayoutManager);
        //P关联V
        FenLeiLeftPrecenterImpl fenLeiLeftPrecenter = new FenLeiLeftPrecenterImpl(this);
        fenLeiLeftPrecenter.Gunnlian();


    }


    @Override
    public void showData(FenleiIMPL fenleiIMPL) {
        data = fenleiIMPL.getData();
        rv2.setLayoutManager(new LinearLayoutManager(getActivity()));
        FenLeiARv2dapter adapter = new FenLeiARv2dapter(getActivity(), data);
        rv2.setAdapter(adapter);

    }


}
