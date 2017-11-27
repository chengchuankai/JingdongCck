package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.AddShopCarBean;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.AddShopCarPrecenter;

/**
 * Created by C-PC on 2017/11/8.
 */

public class AddShopCarModelImpl implements AddShopCarModel{
    AddShopCarPrecenter addShopCarPrecenter;
    public AddShopCarModelImpl(AddShopCarPrecenter addShopCarPrecenter) {
        this.addShopCarPrecenter=addShopCarPrecenter;
    }

    @Override
    public void getData(Map<String,String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.ADDSHOPCAR, map, AddShopCarBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                AddShopCarBean addShopCarBea= (AddShopCarBean) baseBean;
                addShopCarPrecenter.OngetView(addShopCarBea);
            }

            @Override
            public void onError() {

            }
        });
    }
}
