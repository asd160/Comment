package test.bick.com.mvpretrofit2rxjavaokhttpdagger2;


import android.view.View;

import java.util.List;

import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.base.BaseActivity;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.bean.VideoInfo;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.dagger.AppComponent;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.interfaces.view.ActivityView;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.persenter.ActivityPresenter;

public class MainActivity extends BaseActivity<ActivityPresenter> implements ActivityView {


    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {


    }

    @Override
    public void showFailure(String FileMsg) {

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void setListener() {

    }

    @Override
    protected void mClick(View view) {

    }

    @Override
    public void initView() {



        presenter.getNetWork();

    }

    @Override
    public void initData() {

    }

    @Override
    public void getContnet() {
        build.inject(this);
    }

    @Override
    protected void initInjector(AppComponent appComponent) {

    }

    @Override
    public void getStringTest(List<VideoInfo> videoInfos) {

    }
}
