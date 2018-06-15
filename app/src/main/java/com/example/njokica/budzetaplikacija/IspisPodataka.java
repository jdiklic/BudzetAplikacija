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

public class IspisPodataka extends AppCompatActivity {



    private static final String DATABASE_NAME = "IspisPodatakaActivity";
    DBHandler myDb;

    private ListView listaView;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_layout);

        listaView = (ListView) findViewById(R.id.listaView);
        myDb = new DBHandler(this);

        popuniListu();
    }

    public void popuniListu() {
        Log.d(DATABASE_NAME, "popuniListu: prikaz podataka");

        Cursor data = myDb.getData();
        ArrayList<String> listaPodataka = new ArrayList<>();
        while (data.moveToNext()){
            listaPodataka.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaPodataka);
        listaView.setAdapter(adapter);

    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }

    public void isprazniListu() {
        Log.d(DATABASE_NAME, "popuniListu: prikaz podataka");

        Cursor data = myDb.delete();
        ArrayList<String> listaPodataka = new ArrayList<>();
        while (data.moveToNext()){
            listaPodataka.remove(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaPodataka);
        listaView.setAdapter(adapter);



    }


}
