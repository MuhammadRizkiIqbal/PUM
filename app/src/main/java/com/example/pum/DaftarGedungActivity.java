package com.example.pum;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DaftarGedungActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_gedung);
    }

    public void hal_sewa(View view) {
        // Implementasi yang dijalankan saat tombol "Sewa Sekarang" diklik
        Intent intent = new Intent(DaftarGedungActivity.this, SewaGedungActivity.class);
        startActivity(intent);
    }
}

