package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.DeleteBean;

/**
 * Created by C-PC on 2017/11/13.
 */

public interface DeletePrecenter {
    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(DeleteBean deleteBean);
}
