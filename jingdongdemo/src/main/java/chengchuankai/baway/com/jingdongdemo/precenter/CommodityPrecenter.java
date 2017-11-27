package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.Commodity;

/**
 * Created by C-PC on 2017/11/7.
 */

public interface CommodityPrecenter {

    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(Commodity commodity);

}
