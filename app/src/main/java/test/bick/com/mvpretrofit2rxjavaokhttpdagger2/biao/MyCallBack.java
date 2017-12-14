package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.biao;

import okhttp3.ResponseBody;

/**
 * Created by mabiao on 2017/12/1.
 */

public abstract class MyCallBack {
    public  abstract void onError(Throwable e);
    public abstract void onSuccess(ResponseBody value);

}
