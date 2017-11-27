package chengchuankai.baway.com.jingdongdemo.utils;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.Config;
import com.umeng.socialize.PlatformConfig;
import com.umeng.socialize.UMShareAPI;

/**
 * Created by C-PC on 2017/11/3.
 */

public class Myapp extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        Config.DEBUG=true;
        UMShareAPI.get(this);
        Fresco.initialize(this);
    }

    {
        PlatformConfig.setWeixin("","");
        PlatformConfig.setQQZone("1106466720","vBkyeYg6wSJcyxLd");
        PlatformConfig.setSinaWeibo("","","");
    }
}
