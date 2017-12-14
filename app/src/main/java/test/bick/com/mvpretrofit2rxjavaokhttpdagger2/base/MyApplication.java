package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.base;

import android.app.Application;

import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.dagger.AppComponent;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.ToastUtil;

/**
 * User:白二鹏
 * Created by Administrator-12-12 19 : 13
 */

public class MyApplication extends Application {

    private AppComponent mAppComponent; //找到调用者 桥梁

    @Override
    public void onCreate() {
        super.onCreate();
//        mAppComponent = DaggerAppComponent
//                .builder()
//                .appModule(new AppModule(this))
//                .build();


        ToastUtil.init(this);//初始化Toast，减少对context的引用

    }

    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
