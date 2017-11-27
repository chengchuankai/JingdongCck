package chengchuankai.baway.com.jingdongdemo.api;

/**
 * Created by C-PC on 2017/11/2.
 */

public class ApiUrl {
    //登录
    public static final String Login = "https://www.zhaoapi.cn/user/login";
    //注册
    public static final String register = "https://www.zhaoapi.cn/user/reg";
    //首页广告
    public static final String ImageTUPIAN = "http://120.27.23.105/ad/getAd";
    //京东超市、分类父类
    public static final String CHAOSHI = "http://120.27.23.105/product/getCatagory";
    //分类子类
    public static final String FENLEIIMPL = "http://120.27.23.105/product/getProductCatagory";
    //商品
    public static final String SHANGPIN = "http://120.27.23.105/product/getProducts";
    //详情
    public static final String XIANGQING = "https://www.zhaoapi.cn/product/getProductDetail";
    //天假购物车
    public static final String ADDSHOPCAR = "https://www.zhaoapi.cn/product/addCart";
    //展示购物车
    public static final String FINCAR = "https://www.zhaoapi.cn/product/getCarts";
    //展示用户详情
    public static final String GETUSER = "https://www.zhaoapi.cn/user/getUserInfo";
    //删除
    public static final String DELETE = "https://www.zhaoapi.cn/product/deleteCart";
    //订单
    public static final String DINGDAN = "https://www.zhaoapi.cn/product/getOrders";
    //创建订单
    public static final String CREATEDD = "https://www.zhaoapi.cn/product/createOrder";
    //创建收货地址
    public static final String ADDR = "https://www.zhaoapi.cn/user/addAddr";
    //获取订单列表
    public static final String GETADDR = "https://www.zhaoapi.cn/user/getAddrs";

}
