package lv.example.gka.loginformmvp.activities;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import lv.example.gka.loginformmvp.R;
import lv.example.gka.loginformmvp.model.PresenterImpl;
import lv.example.gka.loginformmvp.presenter.LoginPresenter;
import lv.example.gka.loginformmvp.view.LoginView;

public class LoginActivity extends Activity implements View.OnClickListener, LoginView {

    EditText etUserName, etPassword;
    TextView tvLogin;

    LoginPresenter mLoginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etPassword = findViewById(R.id.etPassword);
        etUserName = findViewById(R.id.etUserName);
        tvLogin = findViewById(R.id.tvLogin);
        tvLogin.setOnClickListener(this);

        mLoginPresenter = new PresenterImpl(LoginActivity.this);

    }

    @Override
    public void onClick(View v) {
        String userName = etUserName.getText().toString();
        String password = etPassword.getText().toString();
        mLoginPresenter.performLogin(userName,password);


    }

    @Override
    public void loginValidations() {
         Toast.makeText(getApplicationContext(),"Please Enter userName and PAssword",Toast.LENGTH_LONG).show();

    }

    @Override
    public void loginSuccess() {
        Log.d("GIRTS","Login Success");
        Toast.makeText(getApplicationContext(),"Login Success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginError() {
        Log.d("GIRTS","Login Failure");
        Toast.makeText(getApplicationContext(),"Login Failure", Toast.LENGTH_SHORT).show();
    }
}
