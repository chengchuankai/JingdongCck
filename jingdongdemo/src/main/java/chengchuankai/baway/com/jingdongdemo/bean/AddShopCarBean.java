package chengchuankai.baway.com.jingdongdemo.bean;

/**
 * Created by C-PC on 2017/11/8.
 */

public class AddShopCarBean extends BaseBean{
    private String msg;

    public AddShopCarBean() {
    }

    public AddShopCarBean(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "AddShopCarBean{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
