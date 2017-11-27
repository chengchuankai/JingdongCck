package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.DingDanBean;
import chengchuankai.baway.com.jingdongdemo.model.DingDanModel;
import chengchuankai.baway.com.jingdongdemo.model.DingDanModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.DingDanView;

/**
 * Created by C-PC on 2017/11/14.
 */

public class DingDanPrecenterImpl implements DingDanPrecenter {
    DingDanView dingDanView;
    private final DingDanModel dingDanModel;


    public DingDanPrecenterImpl(DingDanView dingDanView) {
        this.dingDanView = dingDanView;
        dingDanModel = new DingDanModelImpl(this);
    }

    @Override
    public void GuanlianM(Map<String, String> map) {
        dingDanModel.getData(map);
    }

    @Override
    public void OngetView(DingDanBean dingDanBean) {
        dingDanView.showData(dingDanBean);
    }


}
