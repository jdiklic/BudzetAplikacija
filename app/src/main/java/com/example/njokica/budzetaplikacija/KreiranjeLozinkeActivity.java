package com.example.njokica.budzetaplikacija;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class KreiranjeLozinkeActivity extends AppCompatActivity  {



    EditText editText1, editText2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kreiranje_lozinke);

        editText1 = (EditText) findViewById(R.id.editText1);
        editText2 = (EditText) findViewById(R.id.editText2);
        button = (Button) findViewById(R.id.button);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1 = editText1.getText().toString();
                String text2 = editText2.getText().toString();

                if(text1.equals("") || text2.equals("")){
                    //nema lozinke
                    Toast.makeText(KreiranjeLozinkeActivity.this, "Niste unijeli lozinku!", Toast.LENGTH_SHORT).show();
                } else{
                    if(text1.equals(text2)){
                        //spremanje lozinke
                        SharedPreferences settings = getSharedPreferences("PREFS",0);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString("password", text1);
                        editor.apply();

                        //ulaz u aplikaciju
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        //kad lozinke nisu jednake
                        Toast.makeText(KreiranjeLozinkeActivity.this, "Lozinke nisu jednake!", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }

}
