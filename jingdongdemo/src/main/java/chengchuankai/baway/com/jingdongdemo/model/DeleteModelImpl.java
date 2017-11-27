package chengchuankai.baway.com.jingdongdemo.model;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.api.ApiUrl;
import chengchuankai.baway.com.jingdongdemo.bean.BaseBean;
import chengchuankai.baway.com.jingdongdemo.bean.DeleteBean;
import chengchuankai.baway.com.jingdongdemo.net.HttpUtils;
import chengchuankai.baway.com.jingdongdemo.net.OnNetListener;
import chengchuankai.baway.com.jingdongdemo.precenter.DeletePrecenter;

/**
 * Created by C-PC on 2017/11/13.
 */

public class DeleteModelImpl implements DeleteModel {
    DeletePrecenter deletePrecenter;

    public DeleteModelImpl(DeletePrecenter deletePrecenter) {
        this.deletePrecenter = deletePrecenter;
    }

    @Override
    public void getData(Map<String, String> map) {
        HttpUtils.getInstance().doPost(ApiUrl.DELETE, map, DeleteBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                DeleteBean deleteBean = (DeleteBean) baseBean;
                deletePrecenter.OngetView(deleteBean);
            }

            @Override
            public void onError() {

            }
        });
    }
}
