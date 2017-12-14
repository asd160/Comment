package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.dagger;

import android.app.Application;

import javax.inject.Singleton;
import dagger.Component;

/**
 * User:白二鹏
 * Created by Administrator-12-12 19 : 15
 * 桥梁 Module.class
 */
@Singleton //单例
@Component(modules = {AppModule.class})
public interface AppComponent {

    Application Application();
}
