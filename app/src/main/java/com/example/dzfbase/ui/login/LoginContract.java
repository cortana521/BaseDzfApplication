package com.example.dzfbase.ui.login;

import android.app.Activity;
import android.view.View;


import com.example.dzfbase.base.BasePresenter;
import com.example.dzfbase.base.BaseViewImp;

import java.util.ArrayList;


public interface LoginContract {

    interface LoginView extends BaseViewImp {

        void backLoginSuc(LoginBean mLoginBean);

        void backRegisterFail(String msg);
        void backLoginFail(String msg);
    }

   abstract class Presenter extends BasePresenter<LoginView> {


       public abstract void login(String username, String password);

       public abstract void initPhotoPicker(Activity context, ArrayList selectedPhotos);

       public abstract void initJsonData();

      public abstract void upLoadImg(String path);

    }

}
