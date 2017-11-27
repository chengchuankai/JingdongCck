package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;
import chengchuankai.baway.com.jingdongdemo.model.ZhuceModelImpl;
import chengchuankai.baway.com.jingdongdemo.model.ZhuceModle;
import chengchuankai.baway.com.jingdongdemo.view.ZhuceView;

/**
 * Created by C-PC on 2017/11/2.
 */

public class ZhucePrecenterImpl implements ZhucePrecenter{
    private ZhuceView zhuceView;
    private ZhuceModle zhuceModle;

    public ZhucePrecenterImpl(ZhuceView zhuceView){
        this.zhuceView=zhuceView;
        zhuceModle = new ZhuceModelImpl(this);
    }

    //连接M层
    @Override
    public void connectMzhuce(Map<String, String> map) {
        zhuceModle.getdata(map);
    }

    //连接V层
    @Override
    public void connectVzhuce(ResgterBean resgterBean) {
        zhuceView.setData(resgterBean);
    }
}
