package com.example.pum;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class report extends AppCompatActivity {

    private TextView namaPenyewaTextView;
    private TextView gedungDisewaTextView;
    private TextView lamaSewaTextView;
    private TextView namaKegiatanTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        namaPenyewaTextView = findViewById(R.id.nama_penyewa_pertama);
        gedungDisewaTextView = findViewById(R.id.gedungDisewa_pertama);
        lamaSewaTextView = findViewById(R.id.lama_sewa_pertama);
        namaKegiatanTextView = findViewById(R.id.nama_kegiatan_pertama);

        String namaPenyewa = "iqbal";
        String gedungDisewa = "cangkul";
        String lamaSewa = "1 Hari";
        String namaKegiatan = "Praktikum Perkebunan";

        namaPenyewaTextView.setText("Nama Penyewa: " + namaPenyewa);
        gedungDisewaTextView.setText("Gedung Disewa: " + gedungDisewa);
        lamaSewaTextView.setText("Lama Sewa: " + lamaSewa);
        namaKegiatanTextView.setText("Nama Kegiatan: " + namaKegiatan);
    }
}
