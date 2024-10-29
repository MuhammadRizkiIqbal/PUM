package com.example.pum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void tombol_login(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class); // Ganti dengan LoginActivity
        startActivity(intent);
    }

    public void tombol_register(View view) {
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class); // Ganti dengan RegisterActivity
        startActivity(intent);
    }

    public void hal_utama(View view) {
    }
}

