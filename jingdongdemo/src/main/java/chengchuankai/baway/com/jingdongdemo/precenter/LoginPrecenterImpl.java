package chengchuankai.baway.com.jingdongdemo.precenter;

import java.util.Map;

import chengchuankai.baway.com.jingdongdemo.bean.LoginBean;
import chengchuankai.baway.com.jingdongdemo.bean.ResgterBean;
import chengchuankai.baway.com.jingdongdemo.model.LoginModel;
import chengchuankai.baway.com.jingdongdemo.model.LoginModelImpl;
import chengchuankai.baway.com.jingdongdemo.view.LoginView;
import chengchuankai.baway.com.jingdongdemo.view.OnfinishListener;

/**
 * Created by C-PC on 2017/11/2.
 */

public class LoginPrecenterImpl implements LoginPrecenter,OnfinishListener{
    LoginView loginView;
    private final LoginModel loginModel;

    public LoginPrecenterImpl(LoginView loginView){
        this.loginView=loginView;
        loginModel = new LoginModelImpl();
    }

    @Override
    public void getLoginMap(Map<String,String> map) {
        loginModel.getLoginModel(map,this);
    }

    //关联M
    @Override
    public void onsuccess(LoginBean loginBean) {
        loginView.ShowLoginView(loginBean);
    }

    @Override
    public void onRegister(ResgterBean resgterBean) {

    }
}
