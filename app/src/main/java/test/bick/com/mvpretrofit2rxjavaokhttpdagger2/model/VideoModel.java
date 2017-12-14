package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.model;

import android.util.Log;

import java.util.Map;

import javax.inject.Inject;

import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.RetrofitInterface;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.RetrofitUtils;

/**
 * User:白二鹏
 * Created by Administrator-12-13 15 : 07
 */

public class VideoModel {

    //实例化
    @Inject
    public VideoModel() {

        Log.e("chulaile","ccccccc");
        System.out.println("ssssssssssssssssssModelGouZaoQi");
    }


    public void main(Map<String,String> map){
        Log.e("chuanMain","qqqqqqqqqqq");
        System.out.println("ssssssssssssssssssModelFunction");
        RetrofitUtils.getInstance("", map, new RetrofitInterface() {
            @Override
            public void rxsuccess(String msg) {

            }

            @Override
            public void rxfail(String msg) {

            }

            @Override
            public void rxError(Throwable e) {

            }
        });
    }


}
