package com.example.dzfbase.ui.login.register;

import android.content.Context;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/6/1
 * Time: 14:17
 */
public class RegisterPresenter extends RegisterContract.Presenter{

    private Context mContext;

    public RegisterPresenter(Context context) {
        this.mContext = context;
    }


    //注册
    @Override
    public void register(String username, String password, String repassword) {
//        addSubscribe(create(ApiService.class).register(username, password, repassword),
//                new BaseObserver<RegisterBean>(getView()) {
//            @Override
//            protected void onSuccess(RegisterBean data) {
//                getView().backRegisterSuc(data);
//            }
//
//            @Override
//            protected void onFail(Throwable data) {
//                getView().backRegisterFail(data.getMessage());
//            }
//
//        });
    }
}
