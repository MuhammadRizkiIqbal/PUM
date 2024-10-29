package com.example.pum;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ContactActivity extends AppCompatActivity {

    ListView listView;
    String mTitle[] = {"Facebook", "Whatsapp", "Instagram", "Youtube"};
    String mDescription[] = {"Politeknik Negeri Lampung", "085217214837", "@politeknik_negeri_lampung", "Politeknik Negeri Lampung"};
    int images[] = {R.drawable.facebook, R.drawable.whatsapp, R.drawable.instagram, R.drawable.youtube};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        listView = findViewById(R.id.listView);

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener((parent, view, position, id) -> {
            // Memeriksa posisi item yang diklik dan membuka aplikasi yang sesuai
            switch (position) {
                case 0: // Facebook
                    openFacebook();
                    break;
                case 1: // WhatsApp
                    openWhatsapp();
                    break;
                case 2: // Instagram
                    openInstagram();
                    break;
                case 3: // YouTube
                    openYouTube();
                    break;
            }
        });
    }

    private void openInstagram() {
        Intent instagramIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.instagram:"));
        if (instagramIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(instagramIntent);
        } else {
            // Jika aplikasi Instagram tidak ditemukan, buka Instagram di browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.instagram.com/politeknik_negeri_lampung"));
            startActivity(browserIntent);
        }
    }

    private void openWhatsapp() {
        Intent whatsappIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.whatsapp:"));
        if (whatsappIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(whatsappIntent);
        } else {
            // Jika aplikasi Whatsapp tidak ditemukan, buka Whatsapp di browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://wa.me/6282289300185"));
            startActivity(browserIntent);
        }
    }

    private void openFacebook() {
        Intent facebookIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.facebook:"));
        if (facebookIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(facebookIntent);
        } else {
            // Jika aplikasi Facebook tidak ditemukan, buka Faccebook di browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.facebook.com/humaspolinela/?locale=id_ID"));
            startActivity(browserIntent);
        }
    }

    private void openApp(String packageName) {
        PackageManager pm = getPackageManager();
        try {
            Intent intent = pm.getLaunchIntentForPackage(packageName);
            if (intent != null) {
                startActivity(intent);
            } else {
                // Jika aplikasi tidak ditemukan, buka aplikasi Play Store
                intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("market://details?id=" + packageName));
                startActivity(intent);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void openYouTube() {
        // Coba membuka YouTube melalui aplikasi
        Intent youtubeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("vnd.youtube:"));
        if (youtubeIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(youtubeIntent);
        } else {
            // Jika aplikasi YouTube tidak ditemukan, buka YouTube di browser
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/@politekniknegerilampung9459"));
            startActivity(browserIntent);
        }
    }

    public void hal_utama(View view) {
        Intent intent = new Intent(ContactActivity.this, MainActivity.class);
        startActivity(intent);
    }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);

            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);

            return row;
        }
    }
}
