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

    private String kullaniciAdi;

    private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.linear_layout);
        kullaniciBilgileriTv = findViewById(R.id.kullanici_tv_id);
        Bundle bundle = getIntent().getExtras();
        if(bundle != null){
            kullaniciAdi = bundle.getString("word");
            kullaniciBilgileriTv.setText(kullaniciAdi);
        }
    }
}
