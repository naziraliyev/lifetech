package com.example.lifetech;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lifetech.Adapters.MyAdapter;
import com.example.lifetech.model.MyModel;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ConfirmLoginActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private RecyclerView recyclerView;
    private List<MyModel> list;
    RecyclerView.Adapter adapter;
    private DrawerLayout drawerLayout;
    private Toolbar supportActionBar;
    private Toolbar toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_login_ativity);
        recyclerView = findViewById(R.id.recyclerView);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setVisibility(View.GONE);
        loadDrawerLayout();
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        hideStatusBar();
        initStatusBar();
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        list = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            String time = "14:00";
            String teacher = "Ismoilxon";
            String course = "Web design";
            String desc = "Siz Qatnashayotgan Kurslar";
            MyModel item = new MyModel(course, teacher, time, desc);
            list.add(item);
        }
        responseList();
        adapter = new MyAdapter(getApplicationContext(), list);
        recyclerView.setAdapter(adapter);


    }
    private void hideStatusBar() {
        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
    }
    private void initStatusBar() {
        if (Build.VERSION.SDK_INT >= 23) {
            getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        }
    }


    private void responseList() {

    }


    private void loadDrawerLayout() {
        drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about_me:
                startActivity(new Intent(ConfirmLoginActivity.this, AboutActivity.class));
                finish();
                break;
            case R.id.registration:
                startActivity(new Intent(ConfirmLoginActivity.this, RegisterActivity.class));
                finish();
                break;
            case R.id.log_in:
                startActivity(new Intent(ConfirmLoginActivity.this, LoginConfirmActivity.class));
                finish();
                break;
            case R.id.profile:
                startActivity(new Intent(ConfirmLoginActivity.this, ProfileActivity.class));
                finish();
                break;
            case R.id.log_out:
                startActivity(new Intent(ConfirmLoginActivity.this, SplashActivity.class));
                finish();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + item.getItemId());
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    public void setSupportActionBar(Toolbar supportActionBar) {
        this.supportActionBar = supportActionBar;
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        super.onBackPressed();
    }
}