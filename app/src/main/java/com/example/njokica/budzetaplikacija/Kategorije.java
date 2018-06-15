package com.example.njokica.budzetaplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class Kategorije extends AppCompatActivity  {

    ArrayList<String> listaKategorije = new ArrayList<>();

    private static final String DATABASE_NAME = "Kategorije";

    HandlerKategorije myDb2;
    Button button4;
    EditText editText5;
    ListView listaKategorija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorije);

        editText5 = (EditText) findViewById(R.id.editText5);
        button4 = (Button) findViewById(R.id.button4);
        listaKategorija = (ListView) findViewById(R.id.listaKategorija);
        myDb2 = new HandlerKategorije(this);



        button4.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noviUnos2 = editText5.getText().toString();

                if (editText5.length() != 0) {
                    AddData2(noviUnos2);
                    editText5.setText("");
                } else {
                    toastMessage("Morate unjeti naziv kategorije!");
                }

                Intent intent = new Intent(Kategorije.this, IspisKategorija.class);
                startActivity(intent);
            }



        });


    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    public void AddData2(String noviUnos2){
        boolean unosPodataka = myDb2.addData2(noviUnos2);

        if(unosPodataka){
            toastMessage("Podaci su uspješno unešeni!");
        }else{
            toastMessage("Nešto nije u redu!");
        }
    }


}
