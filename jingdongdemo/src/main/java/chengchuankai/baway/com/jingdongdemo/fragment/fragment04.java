package chengchuankai.baway.com.jingdongdemo.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.HashMap;
import java.util.List;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.DingDanActivity;
import chengchuankai.baway.com.jingdongdemo.adapter.FindCarAdapter;
import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;
import chengchuankai.baway.com.jingdongdemo.bean.MessageEvent;
import chengchuankai.baway.com.jingdongdemo.precenter.FindCarPrecenter;
import chengchuankai.baway.com.jingdongdemo.precenter.FindCarPrecenterImpl;
import chengchuankai.baway.com.jingdongdemo.view.FindCarView;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by C-PC on 2017/10/31.
 */

public class fragment04 extends Fragment implements FindCarView {

    private RecyclerView rv_car;
    public static CheckBox car_all_select;
    public static FindCarAdapter adapter;
    public static TextView tv_sum_price;
    private TextView tv_go_pay;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment04, null);
        car_all_select = view.findViewById(R.id.car_all_select);
        tv_sum_price = view.findViewById(R.id.tv_sum_price);
        tv_go_pay = view.findViewById(R.id.tv_go_pay);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("token", MODE_PRIVATE);
        final String token = sharedPreferences.getString("token", null);
        int uid0 = sharedPreferences.getInt("uid", 0);
        String uid = String.valueOf(uid0);
        FindCarPrecenter findCarPrecenter = new FindCarPrecenterImpl(this);
        HashMap<String, String> map = new HashMap<>();
        map.put("token", token);
        map.put("uid", uid);
        findCarPrecenter.GuanlianM(map);
        rv_car = view.findViewById(R.id.rv_car);
        //注册EventBus
        EventBus.getDefault().register(this);
        car_all_select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.Allchecked(car_all_select.isChecked());
            }
        });
        final boolean checked = car_all_select.isChecked();
        tv_go_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getActivity(), DingDanActivity.class);
                startActivity(intent);

            }
        });

        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    //接收事件
    @Subscribe
    public void OnMessageEvent(MessageEvent msg) {
        car_all_select.setChecked(msg.isChecked());
    }

    @Override
    public void showData(FindCarBean findCarBean) {

        for (int i = 0; i < findCarBean.getData().size(); i++) {
            findCarBean.getData().get(i).setShopIsChecked(false);
            for (int j = 0; j < findCarBean.getData().get(i).getList().size(); j++) {
                findCarBean.getData().get(i).getList().get(j).setShopChildIsChecked(false);
            }
        }

        List<FindCarBean.DataBean> data = findCarBean.getData();
        rv_car.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FindCarAdapter(getActivity(), data);
        rv_car.setAdapter(adapter);
        findCarBean.getData();


    }

}
