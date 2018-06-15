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

public class IspisUstedevina extends AppCompatActivity {

    private static final String DATABASE_NAME = "IspisUstedevinaActivity";
    HandlerUstedevina myDb5;

    private ListView listaUstedevina;

    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista_ustedevina);

        listaUstedevina = (ListView) findViewById(R.id.listaUstedevina);
        myDb5 = new HandlerUstedevina(this);

        popuniListu();
    }

    public void popuniListu() {
        Log.d(DATABASE_NAME, "popuniListu: prikaz podataka");

        Cursor data = myDb5.getData5();
        ArrayList<String> listaUstedevine = new ArrayList<>();
        while (data.moveToNext()){
            listaUstedevine.add(data.getString(1));
        }
        ListAdapter adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,listaUstedevine);
        listaUstedevina.setAdapter(adapter);

    }
    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}
