package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.XiangQingPrecenter;

/**
 * Created by C-PC on 2017/11/7.
 */

public class XiangQingModelImpl implements XiangQingModel{
    XiangQingPrecenter xiangQingPrecenter;
    public XiangQingModelImpl(XiangQingPrecenter xiangQingPrecenter) {
        this.xiangQingPrecenter=xiangQingPrecenter;
    }

    @Override
    public void getdata(Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.XIANGQING, map, XiangQingBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                XiangQingBean xiangQingBean= (XiangQingBean) baseBean;
                xiangQingPrecenter.getSuccess(xiangQingBean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
