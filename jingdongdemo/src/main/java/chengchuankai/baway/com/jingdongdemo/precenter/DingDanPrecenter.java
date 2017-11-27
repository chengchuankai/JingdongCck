package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.DingDanBean;

/**
 * Created by C-PC on 2017/11/14.
 */

public interface DingDanPrecenter {
    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(DingDanBean dingDanBean);
}
