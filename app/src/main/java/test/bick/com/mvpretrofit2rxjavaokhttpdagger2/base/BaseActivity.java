package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.base;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import javax.inject.Inject;

import butterknife.ButterKnife;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.R;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.dagger.AppComponent;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.di.ActivityComponent;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.di.ActivityModule;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.di.DaggerActivityComponent;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.AppManager;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.LogUtil;
import test.bick.com.mvpretrofit2rxjavaokhttpdagger2.utils.StatusBarUtil;

/**
 * User:白二鹏
 * Created by Administrator-12-12 18 : 43
 */

public abstract class BaseActivity<P extends BasePresenter> extends AppCompatActivity implements View.OnClickListener {

    private boolean isStatus=false;//沉浸式
    private boolean isShowActionBar =false;//ActionBar
    private boolean isFullScreen=false;//是否支持全屏

    protected String TAG = "BaseActivity";
    protected MyApplication myApplication;

    @Inject
    public P presenter;
    public ActivityComponent build;

    /**
     * 布局文件ID
     * @return
     */
    protected abstract int getLayoutId();
    //protected abstract P initPresenter();
    protected View mRootView;
    protected abstract void setListener();//监听事件
    protected abstract void mClick(View view); //点击
    public abstract void initView();//初始化事件
    public abstract void initData();//初始化事件
    public abstract void getContnet();

    /**
     * Dagger 注入
     */
    protected abstract void initInjector(AppComponent appComponent);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setFullScreen(false);//显示全屏
        mRootView= LayoutInflater.from(this).inflate(getLayoutId(),null);
        //设置布局
        setContentView(mRootView);
        AppManager.getAppManager().addActivity(this);//向栈中添加Activity
        ButterKnife.bind(this);//注入此Activity

        build = DaggerActivityComponent.builder().activityModule(new ActivityModule()).build();
        getContnet();
        // 绑定VIew
        if(presenter!=null){
            presenter.attchView(this);
        }else {
            System.out.println("wode ");
        }


        //myApplication = (MyApplication) getApplication();
        //initInjector(myApplication.getAppComponent());//Dagger 注入

        initView();//初始化View
        setListener();
        initData();//初始化Data
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detach();
    }

    /**
     * 是否全屏和显示标题，true为全屏和无标题，false为无标题，请在setContentView()方法前调用
     * @param fullScreen
     */
    public void setFullScreen(boolean fullScreen)
    {
        if(fullScreen)
        {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        } else
        {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
        }
        StatusBarUtil.setStatusBarColor(this , R.color.title_whites);
        StatusBarUtil.StatusBarLightMode(this);
    }

    /**
     * 无参数  跳转
     * @param clz
     */
    public void startActivity(Class<?> clz){
        Intent in=new Intent(this,clz);
        startActivity(in);
    }

    /**
     * 有参跳跳转
     * @param clz
     * @param bundle
     */
    public void startActivity(Class<?> clz,Bundle bundle){
        Intent in=new Intent(this,clz);
        in.putExtras(bundle);
        startActivity(in);
    }

    /**
     * 重写点击事件
     * @param view
     */
    @Override
    public void onClick(View view) {
        //点击事件的回调  在那边会重写
        //那边的Click 就相当于点击事件了
        mClick(view);
    }

    /**
     * inner执行OnKeyDown方法
     */
    protected void onKeyDown()
    {
    }
    protected boolean isBaseOpeartion = true;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if (keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(isBaseOpeartion)
            {
                LogUtil.log("页面销毁"+TAG);
                AppManager.getAppManager().finishActivity();
            }else
            {
                LogUtil.log("执行页面"+TAG);
                onKeyDown();
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    /**
     * 设置ActionBar 是否显示
     * @param showActionBar
     */
    public void setShowActionBar(boolean showActionBar){
        isShowActionBar=showActionBar;
        if(isShowActionBar){
            getSupportActionBar().show();
        }else {
            getSupportActionBar().hide();
        }
    }

    /**
     * 设置是否全屏
     * @param fullScreen
     */
    public void setFullScreenX(boolean fullScreen){
        isFullScreen=fullScreen;
        if(isFullScreen){
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
    }


    /**
     * 设置透明状态 沉浸式
     */
    public void setStatus(boolean status){
        isStatus =status;
        if(isStatus){
            if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.KITKAT){

                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            }
        }
    }
}
