package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.http;

/**
 * User:白二鹏
 * Created by Administrator-12-13 13 : 55
 */

public class MyApi {

    //false 线上  true测试
    private  static boolean isDebug =true;

    private static final String  TESTURL="http://baobab.kaiyanapp.com/"; //测试
    private static final String  LINEURL = "http://baobab.kaiyanapp.com/";

    public static final String MURL=baseUrl()+"api/v2/";
    public static final String QIANURL=baseUrl()+"api/v2/";
    private  static String baseUrl(){
        return isDebug ? TESTURL: LINEURL;
    }
}
