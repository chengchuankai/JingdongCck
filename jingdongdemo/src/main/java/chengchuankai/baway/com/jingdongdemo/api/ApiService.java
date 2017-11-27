package chengchuankai.baway.com.jingdongdemo.api;

import chengchuankai.baway.com.jingdongdemo.bean.DeleteBean;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by C-PC on 2017/11/13.
 */

public interface ApiService {

    //删除
    @GET("product/deleteCart")
    Call<DeleteBean> getDelete(@Query("uid") String uid,@Query("pid") String pid,@Query("token") String token);


}
