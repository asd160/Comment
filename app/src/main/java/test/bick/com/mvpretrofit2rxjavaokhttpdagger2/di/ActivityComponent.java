package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.di;

import dagger.Component;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.MainActivity;

/**
 * User:白二鹏
 * Created by Administrator-12-12 21 : 05
 */
//桥梁
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(MainActivity mainactivity);

}
