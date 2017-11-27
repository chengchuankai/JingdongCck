package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.FindCarPrecenter;

/**
 * Created by C-PC on 2017/11/9.
 */

public class FinCarModelImpl implements FinCarModel {
    FindCarPrecenter findCarPrecenter;

    public FinCarModelImpl(FindCarPrecenter findCarPrecenter) {
        this.findCarPrecenter = findCarPrecenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.FINCAR, map, FindCarBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                FindCarBean findCarBean= (FindCarBean) baseBean;
                findCarPrecenter.OngetView(findCarBean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
