package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.dagger;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * User:白二鹏
 * Created by Administrator-12-12 19 : 16
 * Module 创建实例
 */

@Module
public class AppModule {

    private Application mApplication;

    /**
     * 构造器
     * @param mApplication
     */
    public AppModule(Application mApplication) {
        this.mApplication = mApplication;
    }

    @Singleton //单例
    @Provides //关键字表明 该方法 提供依赖对象
    public Application provideApplication(){
        return mApplication;
    }

}
