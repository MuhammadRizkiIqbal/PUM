package com.example.pum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HalamanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman);
    }

    public void Tombol_info(View view) {
        Intent intent = new Intent(HalamanActivity.this, DaftarGedungActivity.class);
        startActivity(intent);
    }

    public void tombol_sewa(View view) {
        Intent intent = new Intent(HalamanActivity.this, SewaGedungActivity.class);
        startActivity(intent);
    }

    public void tombol_contact(View view) {
        Intent intent = new Intent(HalamanActivity.this, ContactActivity.class);
        startActivity(intent);
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(HalamanActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void tombol_report(View view) {
        Intent intent = new Intent(HalamanActivity.this, report.class); // Ganti dengan RegisterActivity
        startActivity(intent);
    }
}
