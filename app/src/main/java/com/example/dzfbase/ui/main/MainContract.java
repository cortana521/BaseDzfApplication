package com.example.dzfbase.ui.main;


import com.example.dzfbase.base.BasePresenter;
import com.example.dzfbase.base.BaseViewImp;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/3/29
 * Time: 14:52
 */
public interface MainContract {

    interface MainView extends BaseViewImp {

    }

    abstract class Presenter extends BasePresenter<MainView> {


    }
}
