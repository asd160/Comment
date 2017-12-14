package test.bick.com.mvpretrofit2rxjavaokhttpdagger2.base;

import javax.inject.Inject;

/**
 * User:白二鹏
 * Created by Administrator-12-12 19 : 05
 * 绑定View
 */

public class BasePresenter<V,M> {

    private V mView;

    @Inject
    public M model;
    /**
     * 这里重写 构造方法  ，那么子类 必须 重写  父类的构造方法 完成 父亲的职责
     * @param
     */

    public V getmView(){
        if(mView!=null){
            return mView;
        }else {
            return null;
        }

    }

    public void attchView(V view){
        this.mView = view;
    }


    public void detach(){
        if(mView!=null){
            this.mView=null;
        }
    }

}
