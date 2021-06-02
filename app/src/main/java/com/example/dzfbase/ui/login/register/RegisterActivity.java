package com.example.dzfbase.ui.login.register;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.example.dzfbase.R;
import com.example.dzfbase.base.BaseActivity;
import com.example.dzfbase.router.RouterActivityPath;
import com.example.dzfbase.view.ClearEditText;


@Route(path = RouterActivityPath.PAGER_REGISTER)
public class RegisterActivity extends BaseActivity<RegisterContract.RegisterView, RegisterContract.Presenter> implements RegisterContract.RegisterView{

    @Autowired(name = "title")
    String title;
//    @BindView(R.id.cetName1)
    ClearEditText cetName1;
//    @BindView(R.id.cetPsd1)
    ClearEditText  cetPsd1;
//    @BindView(R.id.cetPsd2)
    ClearEditText cetPsd2;
//    @BindView(R.id.tvLogin1)
    private TextView tvRegister;

    @Override
    public int getLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    public RegisterContract.Presenter createPresenter() {
        return new RegisterPresenter(this);
    }

    @Override
    public RegisterContract.RegisterView createView() {
        return this;
    }

    @Override
    public void init() {
        tvRegister = findViewById(R.id.tvLogin1);

    }

    @Override
    public void initData() {
//        getPresenter().register(cetName1.getText().toString(), cetPsd1.getText().toString(), cetPsd2.getText().toString());
    }

    @Override
    public void initListener() {
        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(RouterActivityPath.PAGER_LOGIN)
                        .navigation();
                finish();
            }
        });
    }


    @Override
    public boolean isOpenImmersive() {
        return true;
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }


    @Override
    public void backRegisterSuc(RegisterBean mRegisterBean) {
        ARouter.getInstance().build(RouterActivityPath.PAGER_MAIN)
                .navigation();
        finish();
    }

}
