package com.example.dzfbase.ui.login;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.dzfbase.R;
import com.example.dzfbase.base.BaseActivity;
import com.example.dzfbase.router.RouterActivityPath;

/**
 * Created by Android Studio.
 * User: daizhifeng1
 * Date: 2021/6/1
 * Time: 11:32
 */
@Route(path = RouterActivityPath.PAGER_LOGIN)
public class LoginActivity extends BaseActivity<LoginContract.LoginView, LoginContract.Presenter> implements
        LoginContract.LoginView {

    private TextView tvRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public LoginContract.Presenter createPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    public LoginContract.LoginView createView() {
        return this;
    }

    @Override
    public void init() {
        tvRegister = findViewById(R.id.tvRegister);
    }

    @Override
    public void initData() {
//        getPresenter().login("15623236735", "12345");
    }

    @Override
    public void initListener() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterActivityPath.PAGER_REGISTER)
                        .navigation();
                finish();
            }
        });

    }

    @Override
    public void backLoginSuc(LoginBean mLoginBean) {

    }

    @Override
    public void backRegisterFail(String msg) {

    }

    @Override
    public void backLoginFail(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
