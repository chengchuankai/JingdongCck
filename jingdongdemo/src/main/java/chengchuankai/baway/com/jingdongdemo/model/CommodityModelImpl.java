package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.Commodity;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.CommodityPrecenter;

/**
 * Created by C-PC on 2017/11/7.
 */

public class CommodityModelImpl implements CommodityModel{
    CommodityPrecenter commodityPrecenter;
    public CommodityModelImpl(CommodityPrecenter commodityPrecenter) {
        this.commodityPrecenter=commodityPrecenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.SHANGPIN, map, Commodity.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                Commodity commodity= (Commodity) baseBean;
                commodityPrecenter.OngetView(commodity);
            }

            @Override
            public void onError() {

            }
        });
    }
}
