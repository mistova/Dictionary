package com.work.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] str = new String[3];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ListView listemiz = findViewById(R.id.listView1);

        Bundle bundle     = getIntent().getExtras();

        if(bundle != null){
            str[0] = bundle.getString("msg1");
            str[1] = bundle.getString("msg2");
            str[2] = bundle.getString("msg3");
        }
        ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, android.R.id.text1, str);
        listemiz.setAdapter(veriAdaptoru);


    }
}
