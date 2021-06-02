package com.example.dzfbase.ui.login.splash;


import com.example.dzfbase.base.BasePresenter;
import com.example.dzfbase.base.BaseViewImp;

public interface SplashContract {

    interface View extends BaseViewImp {


    }

    abstract class Presenter extends BasePresenter<View> {

        public abstract void getList();
    }

}
