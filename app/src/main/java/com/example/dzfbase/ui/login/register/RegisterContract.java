package com.example.dzfbase.ui.login.register;

import com.example.dzfbase.base.BasePresenter;
import com.example.dzfbase.base.BaseViewImp;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/6/1
 * Time: 14:16
 */
public interface RegisterContract {

    interface RegisterView extends BaseViewImp {
        void backRegisterSuc(RegisterBean mRegisterBean);
    }

    abstract class Presenter extends BasePresenter<RegisterView> {

        public abstract void register(String username, String password, String repassword);
    }

}
