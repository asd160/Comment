package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.persenter;

import javax.inject.Inject;

import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.base.BasePresenter;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.view.ActivityView;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.model.VideoModel;

/**
 * User:白二鹏
 * Created by Administrator-12-12 18 : 41
 */

public class ActivityPresenter extends BasePresenter<ActivityView,VideoModel> {

      @Inject
    public ActivityPresenter() {
        System.out.println("ssssssssssssssssssPresenter");
    }

    /**
     * 请求网络
     */
    public void getNetWork(){
        System.out.println("chengle ");

        //model.main();
    }


}
