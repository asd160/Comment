package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.di.bao;

import dagger.Module;
import dagger.Provides;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.view.ActivityView;

/**
 * User:白二鹏
 * Created by Administrator-12-13 14 : 10
 */

@Module
public class VideoModule {

    private ActivityView videoView;

    public VideoModule(ActivityView videoModule) {
        this.videoView = videoModule;
    }

    @Provides
    ActivityView providesView(){
        return videoView;
    }
}
