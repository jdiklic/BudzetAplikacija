package com.example.njokica.budzetaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class PogresnaLozinkaActivity extends AppCompatActivity  {

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pogresna_lozinka);

        //ucitaj lozinku
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){

            public void run(){
                if(password.equals("")){
                    //ako nema lozinke
                    Intent intent = new Intent(getApplicationContext(), KreiranjeLozinkeActivity.class);
                    startActivity(intent);
                    finish();
                }else{
                    //ako postoji lozinka
                    Intent intent = new Intent(getApplicationContext(), UnosLozinkeActivity.class);
                    startActivity(intent);
                    finish();
                }

            }
        },2000);
    }

}
