package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils;

/**
 * User:白二鹏
 * Created by Administrator-12-13 20 : 53
 */

public interface RetrofitInterface {
    void rxsuccess(String msg);
    void rxfail(String msg);
    void rxError(Throwable e);
}
