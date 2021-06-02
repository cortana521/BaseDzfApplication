package com.example.dzfbase.ui.login.splash;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;

import com.alibaba.android.arouter.launcher.ARouter;
import com.example.dzfbase.R;
import com.example.dzfbase.base.BaseActivity;
import com.example.dzfbase.router.RouterActivityPath;
import com.example.dzfbase.ui.login.LoginActivity;


@SuppressLint("Registered")
public class SplashActivity extends BaseActivity<SplashContract.View,
        SplashContract.Presenter> implements SplashContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_splash;
    }


    @Override
    public SplashContract.Presenter createPresenter() {
        return new SplashPresenter(this);
    }

    @Override
    public SplashContract.View createView() {
        return this;
    }

    @Override
    public void init() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                goMain();
            }
        }, 3 * 1000);
    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    /**
     * 进入主页面
     */
    private void goMain() {
        ARouter.getInstance().build(RouterActivityPath.PAGER_LOGIN)
                .navigation();
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}
