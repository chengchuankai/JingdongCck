package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.ChaoShiBean;
import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;

/**
 * Created by C-PC on 2017/11/2.
 */

public interface ZhucePrecenter {
    //连接M层 进行注册
    void connectMzhuce(Map<String,String> map);
    //连接V层
    void connectVzhuce(ResgterBean resgterBean);

}
