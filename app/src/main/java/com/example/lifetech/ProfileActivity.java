package com.example.lifetech;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity {
        private EditText edt_surname,edt_name,edt_email,edt_phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        iniVars();
        setInfo();
        hideStatusBar();
        Objects.requireNonNull(getSupportActionBar()).setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        initStatusBar();
    }
    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }

    private void setInfo() {
        SharedPreferences preferences = getSharedPreferences("myPref",MODE_PRIVATE);
        edt_surname.setText(preferences.getString("surname",""));
        edt_name.setText(preferences.getString("name",""));
        edt_email.setText(preferences.getString("email",""));
        edt_phone.setText(preferences.getString("phone",""));
    }

    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }
    private void iniVars() {
        edt_surname = findViewById(R.id.edt_surname);
        edt_name = findViewById(R.id.edt_nameProfile);
        edt_email = findViewById(R.id.editTextTextEmailAddress);
        edt_phone = findViewById(R.id.editTextPhone);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void saveInfo(View view) {
        String surname = edt_surname.getText().toString();
        String name = edt_name.getText().toString();
        String email = edt_email.getText().toString();
        String phone = edt_phone.getText().toString();
        SharedPreferences.Editor editor= getSharedPreferences("myPref",MODE_PRIVATE).edit();
        editor.putString("surname",surname);
        editor.putString("name",name);
        editor.putString("email",email);
        editor.putString("phone",phone);
        editor.apply();

        startActivity(new Intent(this,ConfirmLoginActivity.class));
        finish();
    }
}