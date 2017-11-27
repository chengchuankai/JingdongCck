package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.AddShopCarBean;

/**
 * Created by C-PC on 2017/11/8.
 */

public interface AddShopCarPrecenter {
    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(AddShopCarBean addShopCarBean);
}
