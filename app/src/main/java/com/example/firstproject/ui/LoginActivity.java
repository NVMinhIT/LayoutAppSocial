package com.example.firstproject.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.firstproject.R;
import com.example.firstproject.presenter.LoginPresenter;

public class LoginActivity extends AppCompatActivity implements ILogin {
    LoginPresenter loginPresenter;
    private EditText edtEmail;
    private EditText edtPassword;
    private Button btLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
    }

    private void initView() {
        edtEmail = findViewById(R.id.edit_email);
        edtPassword = findViewById(R.id.edit_password);
        loginPresenter = new LoginPresenter(this);
        btLogin = findViewById(R.id.btn_login);
        btLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginPresenter.onLogin(edtEmail.getText().toString(), edtPassword.getText().toString());

            }
        });
    }

    @Override
    public void LoginSucess() {
        Toast.makeText(this, "Đăng nhập thành công", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(LoginActivity.this, TimeLineActivity.class);
        startActivity(intent);
    }
    @Override
    public void LoginFail() {
        Toast.makeText(this, "Nhập email và mật khẩu", Toast.LENGTH_LONG).show();
    }
}
