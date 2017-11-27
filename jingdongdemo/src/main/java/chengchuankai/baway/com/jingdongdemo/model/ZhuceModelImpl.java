package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.ZhucePrecenter;

/**
 * Created by C-PC on 2017/11/2.
 */

public class ZhuceModelImpl implements ZhuceModle {
    ZhucePrecenter zhucePrecenter;

    public ZhuceModelImpl(ZhucePrecenter zhucePrecenter) {
        this.zhucePrecenter = zhucePrecenter;
    }

    @Override
    public void getdata(Map map) {
        HttpUtils.getInstance().doPost(ApiUrl.register, map, ResgterBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                ResgterBean resgterBean= (ResgterBean) baseBean;
                zhucePrecenter.connectVzhuce(resgterBean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
