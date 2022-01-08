package com.example.lab2_mob201;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.lab2_mob201.Fragment.Fragment_Bai1;
import com.example.lab2_mob201.Fragment.Fragment_Bai2;
import com.example.lab2_mob201.Fragment.Fragment_Bai3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {
    private BottomNavigationView bottomNavigationView;
    private ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.initViewByID();

        this.initBottomViewNav();
    }

    private void initBottomViewNav() {
        this.bottomNavigationView.setOnNavigationItemSelectedListener(MainActivity.this);
        this.bottomNavigationView.getMenu().findItem(R.id.bottom_bai1).setChecked(true);
        this.actionBar.setTitle("Bài 1");
        loadFragment(new Fragment_Bai1());

    }

    private void initViewByID() {
        this.actionBar = getSupportActionBar();
        this.bottomNavigationView = findViewById(R.id.bottomNavView);
    }

    private void loadFragment(Fragment fragment) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    private void checkIDItemNav(int item) {
        this.bottomNavigationView.getMenu().findItem(item).setChecked(true);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.bottom_bai1:
                Fragment_Bai1 fragment_bai1 = new Fragment_Bai1();
                loadFragment(fragment_bai1);
                this.actionBar.setTitle("Bài 1");
                checkIDItemNav(R.id.bottom_bai1);
                break;
            case R.id.bottom_bai2:
                Fragment_Bai2 fragment_bai2 = new Fragment_Bai2();
                loadFragment(fragment_bai2);
                this.actionBar.setTitle("Bài 2");
                checkIDItemNav(R.id.bottom_bai2);
                break;
            case R.id.bottom_bai3:
                Fragment_Bai3 fragment_bai3 = new Fragment_Bai3();
                loadFragment(fragment_bai3);
                this.actionBar.setTitle("Bài 3");
                checkIDItemNav(R.id.bottom_bai3);
                break;
        }
        return true;
    }
}