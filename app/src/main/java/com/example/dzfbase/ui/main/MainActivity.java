package com.example.dzfbase.ui.main;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.example.dzfbase.R;
import com.example.dzfbase.base.BaseActivity;
import com.example.dzfbase.router.RouterActivityPath;

@Route(path = RouterActivityPath.PAGER_MAIN)
public class MainActivity extends BaseActivity<MainContract.MainView,MainContract.Presenter> implements MainContract.MainView {

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    public MainContract.Presenter createPresenter() {
        return new MainPresenter(this);
    }

    @Override
    public MainContract.MainView createView() {
        return this;
    }

    @Override
    public void init() {

    }

    @Override
    public void initData() {

    }

    @Override
    public void initListener() {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }
}