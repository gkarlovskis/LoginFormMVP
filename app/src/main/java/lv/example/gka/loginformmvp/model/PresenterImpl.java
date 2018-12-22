package lv.example.gka.loginformmvp.model;

import android.text.TextUtils;

import lv.example.gka.loginformmvp.presenter.LoginPresenter;
import lv.example.gka.loginformmvp.view.LoginView;

public class PresenterImpl implements LoginPresenter {

    LoginView mLoginView;

    public PresenterImpl(LoginView loginView) {
        this.mLoginView = loginView;
    }
    @Override
    public void performLogin(String userName, String password) {
            if (TextUtils.isEmpty(userName) || TextUtils.isEmpty((password))) {
                mLoginView.loginValidations();
            } else {
                if (userName.equals("Mani") && password.equals("Mani")) {
                    mLoginView.loginSuccess();
                } else {
                    mLoginView.loginError();
                }

            }
    }
}
