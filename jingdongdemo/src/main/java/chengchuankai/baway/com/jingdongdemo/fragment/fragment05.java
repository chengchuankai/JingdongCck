package chengchuankai.baway.com.jingdongdemo.fragment;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.HashMap;

import chengchuankai.baway.com.jingdongdemo.R;
import chengchuankai.baway.com.jingdongdemo.activity.DingDanActivity;
import chengchuankai.baway.com.jingdongdemo.activity.FindUserActivity;
import chengchuankai.baway.com.jingdongdemo.activity.LoginActivity;
import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.UserBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;

import static android.content.Context.MODE_PRIVATE;
import static chengchuankai.baway.com.jingdongdemo.R.id.tv_login_regit;

/**
 * Created by C-PC on 2017/10/31.
 */

public class fragment05 extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView mIvUser;
    /**
     * 登录/注册 >
     */
    private TextView mTvLoginRegit;
    private String token;
    private int uid;
    private ImageView mydd;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment05, null);
        initView(view);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("token", MODE_PRIVATE);
        token = sharedPreferences.getString("token", null);
        uid = sharedPreferences.getInt("uid", 0);
        if (token != null && token.length() > 0){
            getNet();
        }
        mydd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1=new Intent(getActivity(), DingDanActivity.class);
                startActivity(intent1);
            }
        });
            return view;
    }

    private void initView(View view) {
        mIvUser = (ImageView) view.findViewById(R.id.iv_user);
        mTvLoginRegit = (TextView) view.findViewById(tv_login_regit);
        mydd = view.findViewById(R.id.mydd);
        mIvUser.setOnClickListener(this);
        mTvLoginRegit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_user:
                Intent intent0=new Intent(getActivity(), FindUserActivity.class);
                startActivity(intent0);
                break;
            case tv_login_regit:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.mydd:
                Intent intent1=new Intent(getActivity(), DingDanActivity.class);
                startActivity(intent1);
                break;
        }
    }
    public  void getNet(){
        HashMap<String,String> map=new HashMap<>();
        String s = String.valueOf(uid);
        map.put("token",token);
        map.put("uid",s);
        HttpUtils.getInstance().doPost(ApiUrl.GETUSER, map, UserBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                UserBean userBean= (UserBean) baseBean;
                Picasso.with(getActivity()).load(userBean.getData().getIcon()).into(mIvUser);
                mTvLoginRegit.setText(userBean.getData().getUsername());

            }

            @Override
            public void onError() {

            }
        });
    }


}
