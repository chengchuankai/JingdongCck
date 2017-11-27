package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.CreateDdbean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.CreatePresenter;

/**
 * Created by C-PC on 2017/11/17.
 */

public class CreateModelImpl implements CreateModel {
    CreatePresenter createPresenter;

    public CreateModelImpl(CreatePresenter createPresenter) {
        this.createPresenter = createPresenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.CREATEDD, map, CreateDdbean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                CreateDdbean createDdbean = (CreateDdbean) baseBean;
                createPresenter.OngetView(createDdbean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
