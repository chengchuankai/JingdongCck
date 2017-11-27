package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.DingDanBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.DingDanPrecenter;

/**
 * Created by C-PC on 2017/11/14.
 */

public class DingDanModelImpl implements DingDanModel{
    DingDanPrecenter dingDanPrecenter;

    public DingDanModelImpl(DingDanPrecenter dingDanPrecenter) {
        this.dingDanPrecenter = dingDanPrecenter;
    }

    @Override
    public void getData(final Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.DINGDAN, map, DingDanBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                DingDanBean dingDanBean= (DingDanBean) baseBean;
                dingDanPrecenter.OngetView(dingDanBean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
