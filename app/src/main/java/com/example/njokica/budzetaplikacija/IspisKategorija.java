package com.example.njokica.budzetaplikacija;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;


public class IspisKategorija extends AppCompatActivity  {

    private static final String DATABASE_NAME = "IspisKategorijaActivity";
    HandlerKategorije myDb2;

    private ListView listaKategorija;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_kategorija);

        listaKategorija= (ListView) findViewById(R.id.listaKategorija);
        myDb2 = new HandlerKategorije(this);

        popuniListu2();
    }

    public void popuniListu2() {
        Log.d(DATABASE_NAME, "popuniListu: prikaz podataka");

        Cursor data2 = myDb2.getData2();
        ArrayList<String> listaKategorije = new ArrayList<>();
        while (data2.moveToNext()){
            listaKategorije.add(data2.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaKategorije);
        listaKategorija.setAdapter(adapter);



    }

    public void isprazniListu2() {
        Log.d(DATABASE_NAME, "isprazni listu: prikaz podataka");

        Cursor data2 = myDb2.delete2();
        ArrayList<String> listaKategorije = new ArrayList<>();
        while (data2.moveToNext()){
            listaKategorije.remove(data2.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaKategorije);
        listaKategorija.setAdapter(adapter);



    }



    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

}
