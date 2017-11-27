package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.FenleiIMPL;

/**
 * Created by C-PC on 2017/11/6.
 */

public interface FenLeiRightPrecenter {
    //连接M层进行请求
    void guanlian(Map<String,String> map);
    //连接V层
    void ConnectRingV(FenleiIMPL fenleiIMPL);
}
