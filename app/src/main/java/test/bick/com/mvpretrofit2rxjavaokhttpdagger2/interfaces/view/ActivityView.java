package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.view;

import java.util.List;

import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.bean.VideoInfo;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.BaseView;

/**
 * User:白二鹏
 * Created by Administrator-12-12 20 : 19
 */

public interface ActivityView extends BaseView {

    void getStringTest(List<VideoInfo> videoInfos);

}
