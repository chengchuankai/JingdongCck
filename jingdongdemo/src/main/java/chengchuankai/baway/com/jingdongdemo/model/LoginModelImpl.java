package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.LoginBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.view.OnfinishListener;

/**
 * Created by C-PC on 2017/11/2.
 */

public class LoginModelImpl implements LoginModel{

    @Override
    public void getLoginModel(Map map, final OnfinishListener listener) {
        HttpUtils.getInstance().doPost(ApiUrl.Login, map, LoginBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                LoginBean loginBean= (LoginBean) baseBean;
                if (listener!=null){
                    listener.onsuccess(loginBean);
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
