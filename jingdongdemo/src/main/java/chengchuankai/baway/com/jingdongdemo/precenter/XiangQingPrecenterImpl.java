package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;
import chengchuankai.baway.com.jingdongdemo.model.XiangQingModel;
import chengchuankai.baway.com.jingdongdemo.model.XiangQingModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.XiangQingView;

/**
 * Created by C-PC on 2017/11/7.
 */

public class XiangQingPrecenterImpl implements XiangQingPrecenter {

    private XiangQingView xiangQingView;
    private final XiangQingModel xiangQingModel;

    public XiangQingPrecenterImpl(XiangQingView xiangQingView) {
        this.xiangQingView = xiangQingView;
        xiangQingModel = new XiangQingModelImpl(this);
    }

    @Override
    public void guanlian(Map<String, String> map) {
        xiangQingModel.getdata(map);
    }

    @Override
    public void getSuccess(XiangQingBean xiangQingBean) {
        xiangQingView.showData(xiangQingBean);
    }
}
