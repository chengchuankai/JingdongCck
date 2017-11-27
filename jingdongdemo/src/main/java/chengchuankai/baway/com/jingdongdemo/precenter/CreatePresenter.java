package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.CreateDdbean;

/**
 * Created by C-PC on 2017/11/17.
 */

public interface CreatePresenter {
    //M
    void GuanlianM(Map<String,String> map);

    //V
    void OngetView(CreateDdbean createDdbean);
}
