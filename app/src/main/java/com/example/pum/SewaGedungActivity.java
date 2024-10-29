package com.example.pum;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SewaGedungActivity extends AppCompatActivity {
    int harga_sewa_gedung, jml_lmsw, ttl_hargasewa, jml_uang;
    String s_nama;

    Spinner ad_listalat;
    Spinner ad_listruang;
    TextView harga_gedung;
    EditText lama_sewa, nama_penyewa;

    String list_alat[] = {"CANGKUL", "SPRAYER", "KORED", "GOLOK", "PENYIRAM"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sewa_gedung);

        nama_penyewa = findViewById(R.id.nama_penyewa);
        ad_listalat = findViewById(R.id.ad_listgedung);
        harga_gedung = findViewById(R.id.nama_kegiatan);
        lama_sewa = findViewById(R.id.lama_sewa);

        ArrayAdapter<String> ad_gedung = new ArrayAdapter<>(SewaGedungActivity.this,
                android.R.layout.simple_spinner_dropdown_item, list_alat);
        ad_listalat.setAdapter(ad_gedung);

        // Atur pendengar untuk perubahan pada gedung yang dipilih
        ad_listalat.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                // Perbarui opsi ruangan berdasarkan gedung yang dipilih
                updateRoomOptions(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Tidak lakukan apa-apa di sini
            }
        });
    }

    private void updateRoomOptions(int buildingPosition) {
        // Perbarui opsi ruangan berdasarkan gedung yang dipilih
        String selectedBuilding = list_alat[buildingPosition];
        ArrayAdapter<String> ad_ruang = new ArrayAdapter<>(SewaGedungActivity.this,
                android.R.layout.simple_spinner_dropdown_item, getRoomOptions(selectedBuilding));
        ad_listruang.setAdapter(ad_ruang);
    }

    private String[] getRoomOptions(String selectedBuilding) {
        // Sediakan opsi ruangan berdasarkan gedung yang dipilih
        switch (selectedBuilding) {
            case "CANGKUL":
                return new String[]{"", "", ""};
            case "SPRAYER":
                return new String[]{"", ""};
            case "KORED":
                return new String[]{"", ""};
            case "GOLOK":
                return new String[]{"", "", ""};
            case "ALAT PENYIRAM":
                return new String[]{"", ""};
            default:
                return new String[]{};
        }
    }


    public void hal_utama (View view){
        Intent intent = new Intent(SewaGedungActivity.this, MainActivity.class);
        startActivity(intent);
    }

    public void selectFile(View view) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("*/*"); // Allow all file types
        startActivityForResult(intent, 1); // You can use any requestCode
    }

    // Override onActivityResult to handle the result of file selection
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 1 && resultCode == RESULT_OK && data != null) {
            // Get the selected file URI
            // You can use this URI to perform further operations (e.g., upload the file)
            String selectedFileUri = data.getDataString();
            // Perform your file upload logic here
        }
    }
}