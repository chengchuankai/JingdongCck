package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.FindCarBean;

/**
 * Created by C-PC on 2017/11/9.
 */

public interface FindCarPrecenter {
    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(FindCarBean findCarBean);
}
