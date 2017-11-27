package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.FenLeiRightPrecenter;

/**
 * Created by C-PC on 2017/11/6.
 */

public class FenLeiRightModelImpl implements FenLeiRightModel {
    FenLeiRightPrecenter fenLeiRightPrecenter;

    public FenLeiRightModelImpl(FenLeiRightPrecenter fenLeiRightPrecenter) {
        this.fenLeiRightPrecenter = fenLeiRightPrecenter;
    }

    @Override
    public void getData(Map map) {
        HttpUtils.getInstance().doPost(ApiUrl.FENLEIIMPL, map, FenleiIMPL.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                FenleiIMPL fenleiIMPL = (FenleiIMPL) baseBean;
                //同过P层里的方法 把值給V层
                fenLeiRightPrecenter.ConnectRingV(fenleiIMPL);
            }

            @Override
            public void onError() {

            }
        });
    }
}
