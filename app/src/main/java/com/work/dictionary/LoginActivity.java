package com.work.dictionary;


import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.google.gson.Gson;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    // private EditText pwEt;
    private EditText userNameEt;
    private Button loginBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        init();
    }
    private void init() {
        // pwEt = findViewById(R.id.kullanici_pw_et_id);
        userNameEt = findViewById(R.id.kullanici_adi_et_id);
        loginBtn = findViewById(R.id.login_btn_id);
        loginBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        if(v == loginBtn){
            String userName = userNameEt.getText().toString().trim();
            // String pw = pwEt.getText().toString().trim();
            userControl(userName/*,pw*/);
        }
    }
    private void userControl(final String userName/*, String pw*/) {
        if(userName.isEmpty()/* || pw.isEmpty()*/){
            dialogAc("Kullanıcı adı veya parola boş olamaz!");
            return;
        }
        else if(userName.length() < 5/* || pw.length() < 5*/){
            dialogAc("Girilen değerler çok kısa!");
        }
        else{
            AndroidNetworking.post("http://bilimtadinda.com/cankasoft/aranacak_kelime/servis.php")
                    .addBodyParameter("userName", userName)
                    //.addBodyParameter("pw", pw)
                    .setPriority(Priority.MEDIUM)
                    .build()
                    .getAsString(new StringRequestListener() {
                        @Override
                        public void onResponse(String  response) {
                            Log.i("LoginActivity",response);
                            cevapaBak(response,userName);
                            Toast.makeText(LoginActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                        }
                        @Override
                        public void onError(ANError error) {
                            // handle error
                            Log.e("LoginActivity",error.getMessage());
                        }
                    });
        }
    }
    private void cevapaBak(String response,String userName) {
        Gson gson = new Gson();
        ResponseModel responseModel = gson.fromJson(response,ResponseModel.class);

        if(responseModel.getSonuc() == 1){

            Bundle bundle = new Bundle();
            bundle.putString("kullaniciAdi",responseModel.getMesaj());
            //bundle.putLong("loginTarihi",System.currentTimeMillis());

            Intent intent = new Intent(this,MainActivity.class);
            intent.putExtras(bundle);
            //intent.putExtra("kullaniciAdi",userName); bu sekilde de data yollanabilr
            startActivity(intent);
        }
        else{
            dialogAc("Giriş Başarısız!");
            finish();
        }
    }
    private void dialogAc(String mesaj) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("DİKKAT");
        builder.setMessage(mesaj);
        builder.setNegativeButton("TAMAM", null);
        builder.show();
    }
}
