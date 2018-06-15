package com.example.njokica.budzetaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class UnosLozinkeActivity extends AppCompatActivity  {

    EditText editText;
    Button button;

    String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unos_lozinke);

        //ucitaj lozinku
        SharedPreferences settings = getSharedPreferences("PREFS", 0);
        password = settings.getString("password", "");


        editText = (EditText) findViewById(R.id.editText);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();

                if (text.equals(password)){
                    //ulaz u aplikaciju
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(UnosLozinkeActivity.this, "Pogresna lozinka!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

}
