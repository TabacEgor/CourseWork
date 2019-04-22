package com.example.coursework.view.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.coursework.BuildConfig;
import com.example.coursework.R;
import com.example.coursework.presenter.LoginPresenter;
import com.example.coursework.presenter.contract.ILoginContract;

public class LoginActivity extends AppCompatActivity implements ILoginContract.View {

    EditText username, password;
    Button login;
    ProgressBar loading;

    ILoginContract.Presenter loginPresenter;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        username = (EditText) findViewById(R.id.username);
        password = (EditText)  findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        loading = (ProgressBar) findViewById(R.id.loading);

        if (BuildConfig.DEBUG) {
            username.setText("admin");
            password.setText("adminadmin");
        }

        loginPresenter = new LoginPresenter(this);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.doLogin(username.getText().toString(), password.getText().toString());
            }
        });
    }

    @SuppressLint("ShowToast")
    @Override
    public void onLoginSuccess() {
        Toast.makeText(this, R.string.welcome, Toast.LENGTH_LONG);
        Intent mainActivityIntent = new Intent(this, MainActivity.class);
        startActivity(mainActivityIntent);
    }

    @SuppressLint("ShowToast")
    @Override
    public void onLoginFailed() {
        Toast.makeText(this, R.string.login_failed, Toast.LENGTH_LONG);
    }
}
