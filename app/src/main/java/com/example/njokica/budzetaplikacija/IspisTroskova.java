package com.example.njokica.budzetaplikacija;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class IspisTroskova extends AppCompatActivity {



    private static final String DATABASE_NAME = "IspisTroskovaActivity";
    HandlerTrosak myDb3;

    private ListView listaTroskova;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_troskova);

        listaTroskova= (ListView) findViewById(R.id.listaTroskova);
        myDb3 = new HandlerTrosak(this);

        popuniListu3();
    }

    public void popuniListu3() {
        Log.d(DATABASE_NAME, "popuniListu: prikaz podataka");

        Cursor data3 = myDb3.getData3();
        ArrayList<String> listaTroska = new ArrayList<>();
        while (data3.moveToNext()){
            listaTroska.add(data3.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaTroska);
        listaTroskova.setAdapter(adapter);



    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


}
