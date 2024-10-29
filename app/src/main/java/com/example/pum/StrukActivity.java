package com.example.pum;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StrukActivity extends AppCompatActivity {
    TextView nama_penyewa, jenis_gedung, lama_sewa; // TextView untuk menampilkan data

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_struk);

        // Inisialisasi TextView
        nama_penyewa = findViewById(R.id.nama_penyewa);
        jenis_gedung = findViewById(R.id.jenis_gedung);
        lama_sewa = findViewById(R.id.lama_sewa);

        // Mendapatkan data dari Intent
        Intent intent = getIntent();
        if (intent != null) {
            String nama = intent.getStringExtra("nama");
            String gedung = intent.getStringExtra("gedung");
            int lama = intent.getIntExtra("lama", 0);

            // Menampilkan data ke TextView
            nama_penyewa.setText(nama);
            jenis_gedung.setText(gedung);
            lama_sewa.setText(String.valueOf(lama));

            // Menyimpan data ke SharedPreferences
            saveDataToSharedPreferences(nama, gedung, lama);
        } else {
            Log.e("StrukActivity", "Intent is null");
        }
    }

    private void saveDataToSharedPreferences(String nama, String gedung, int lama) {
        SharedPreferences sharedPreferences = getSharedPreferences("sewa_data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString("nama", nama);
        editor.putString("gedung", gedung);
        editor.putInt("lama", lama);

        editor.apply();
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(StrukActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
