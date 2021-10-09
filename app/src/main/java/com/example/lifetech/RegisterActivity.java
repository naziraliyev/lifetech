package com.example.lifetech;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {
        private EditText edt_name,edt_surname,edt_address;
        private RadioGroup radioGroup;
        private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initViews();
        spinnerGetItem();
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        hideStatusBar();
    }
    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void spinnerGetItem() {
        spinner =findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this,R.array.member,R.layout.color_spinner);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinner.setAdapter(adapter);
    }

    private void initViews() {
        edt_name = findViewById(R.id.edt_name);
        edt_surname = findViewById(R.id.edt_surname);
        edt_address = findViewById(R.id.edt_address);
    }

    public void sendInfo(View view) {
        if (edt_name.equals("")&&edt_surname.equals("")&&edt_address.equals("")){
            Toast.makeText(this, "Please Enter All Space", Toast.LENGTH_SHORT).show();
            return;
        }else {
            Intent intent = new Intent(RegisterActivity.this, ConfirmLoginActivity.class);
            startActivity(intent);
        }
        finish();
    }
}