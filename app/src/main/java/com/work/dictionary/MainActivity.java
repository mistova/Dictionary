package com.work.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.work.dictionary.R;

public class MainActivity extends AppCompatActivity {

    private TextView kullaniciBilgileriTv;
    private int temp;

    private String kullaniciAdi;
    private String girisTarihi;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        linearLayout = findViewById(R.id.linear_layout);
        kullaniciBilgileriTv = findViewById(R.id.kullanici_tv_id);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            kullaniciAdi = bundle.getString("kullaniciAdi");
            kullaniciBilgileriTv.setText(kullaniciAdi);
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        // Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onPause() {
        super.onPause();
        //  Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onStop() {
        super.onStop();
        // Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();
        // Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();

    }
}
