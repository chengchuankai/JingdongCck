package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.XiangQingBean;

/**
 * Created by C-PC on 2017/11/7.
 */

public interface XiangQingPrecenter {
    //M
    void guanlian(Map<String, String> map);

    //V
    void getSuccess(XiangQingBean xiangQingBean);
}
