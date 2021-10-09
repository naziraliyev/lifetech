package com.example.lifetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lifetech.Adapters.MyAdapter;
import com.example.lifetech.model.UserResponse;
import com.example.lifetech.networks.APiClient;
import com.example.lifetech.networks.ApiInterface;

import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;



public class LoginConfirmActivity extends AppCompatActivity {
    private EditText edt_login, edt_pass;
    String login, password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_confirm);
        edt_login = findViewById(R.id.edt_login);
        edt_pass = findViewById(R.id.edt_password);
        initStatusBar();
        hideStatusBar();
        loadPrefs();
    }
    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            View decorView = getWindow().getDecorView();
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
    private void loadPrefs() {
        SharedPreferences preferences = getSharedPreferences("myPrefs", MODE_PRIVATE);
        String log = preferences.contains("login") + "";
        edt_login.setText(log);
    }

    public void confirmLogin(View view) {
        login = edt_login.getText().toString();
        password = edt_pass.getText().toString();

        startActivity(new Intent(LoginConfirmActivity.this, ConfirmLoginActivity.class));



    }

}

