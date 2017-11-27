package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;
import chengchuankai.baway.com.jingdongdemo.model.FinCarModel;
import chengchuankai.baway.com.jingdongdemo.model.FinCarModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.FindCarView;

/**
 * Created by C-PC on 2017/11/9.
 */

public class FindCarPrecenterImpl implements FindCarPrecenter{
    FindCarView findCarView;
    private final FinCarModel finCarModel;

    public FindCarPrecenterImpl(FindCarView findCarView) {
        this.findCarView=findCarView;
        finCarModel = new FinCarModelImpl(this);
    }

    @Override
    public void GuanlianM(Map<String, String> map) {
        finCarModel.getData(map);
    }

    @Override
    public void OngetView(FindCarBean findCarBean) {
        findCarView.showData(findCarBean);
    }
}
