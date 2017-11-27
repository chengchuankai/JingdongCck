package chengchuankai.baway.com.jingdongdemo.model;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.view.OnFenLeiFinishListener;

/**
 * Created by C-PC on 2017/11/4.
 */

public class FenLeiLeftModelImpl implements FenLeiLeftModel{
    @Override
    public void GetFenleiModel(final OnFenLeiFinishListener listener) {
        HttpUtils.getInstance().doget(ApiUrl.CHAOSHI, ChaoShiBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                ChaoShiBean chaoShiBean= (ChaoShiBean) baseBean;
                if (listener!=null){
                    listener.success(chaoShiBean);
                }
            }

            @Override
            public void onError() {

            }
        });
    }
}
