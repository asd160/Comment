package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.service;

import java.util.List;
import java.util.Map;

import io.reactivex.Flowable;
import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;
import retrofit2.http.Url;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.bean.VideoInfo;

/**
 * User:白二鹏
 * Created by Administrator-12-13 14 : 20
 */

public interface ApiService {


    @GET("categories")
    Flowable<List<VideoInfo>> getData(@Query("udid") String udid, @Query("vc") int vc);


    @FormUrlEncoded
    @POST()
    @Headers("Accept:*")
    Observable<ResponseBody> getRequest(@Url String path, @FieldMap Map<String,String> map);
}
