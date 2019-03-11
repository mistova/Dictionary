package com.work.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] ulkeler = new String[3];

    private String words     = new String();
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listemiz =(ListView) findViewById(R.id.listView1);

        Bundle bundle     = getIntent().getExtras();



        if(bundle != null){
            ulkeler[0] = bundle.getString("msg1");
            ulkeler[1] = bundle.getString("msg2");
            ulkeler[2] = bundle.getString("msg3");
        }
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler);
        listemiz.setAdapter(veriAdaptoru);


    }
}
