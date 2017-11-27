package chengchuankai.baway.com.jingdongdemo.view;

import chengchuankai.baway.com.jingdongdemo.bean.LoginBean;
import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;

/**
 * Created by C-PC on 2017/11/2.
 */

public interface OnfinishListener {
    void onsuccess(LoginBean loginBean);
    void onRegister(ResgterBean resgterBean);
}
