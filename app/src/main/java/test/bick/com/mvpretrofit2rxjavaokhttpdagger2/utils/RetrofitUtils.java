package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils;

/**
 * User:白二鹏
 * Created by Administrator-12-13 20 : 52
 */


import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.service.ApiService;

/**
 * Created by DANGEROUS_HUI on 2017/12/12.
 */

public class RetrofitUtils {

    private static Retrofit mRetrofit;
    private static OkHttpClient mokHttpClient;


    public static void getInstance(String url, Map<String,String> map, final RetrofitInterface retrofitInterface){
        if(mRetrofit==null){
            synchronized (RetrofitUtils.class){
                if(mRetrofit==null){
                    mRetrofit=new Retrofit.Builder()
                            .baseUrl("")
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .addConverterFactory(GsonConverterFactory.create())
                            .client(getOkInstance())
                            .build();
                    System.out.println("88");
                    ApiService apiService = mRetrofit.create(ApiService.class);
                    apiService.getRequest(url, map)
                            .subscribeOn(Schedulers.io())
                            .observeOn(AndroidSchedulers.mainThread())
                            .doOnNext(new Consumer<ResponseBody>() {
                                @Override
                                public void accept(ResponseBody body) throws Exception {
                                    System.out.println("66");
                                }
                            }).subscribe(new Observer<ResponseBody>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(ResponseBody responseBody) {
                            try {
                                retrofitInterface.rxsuccess(responseBody.string());
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onError(Throwable e) {
                            retrofitInterface.rxError(e);
                            retrofitInterface.rxfail("失败了");
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
                }
            }

        }
    }

    public static OkHttpClient getOkInstance(){
        if(mokHttpClient==null){
            synchronized (RetrofitUtils.class){
                if(mokHttpClient==null){
                    mokHttpClient=new OkHttpClient.Builder()
                            .connectTimeout(5000, TimeUnit.SECONDS)
                            .readTimeout(5000,TimeUnit.SECONDS)
                            .writeTimeout(5000,TimeUnit.SECONDS)
                            .build();
                }
            }
        }
        return mokHttpClient;
    }

}
