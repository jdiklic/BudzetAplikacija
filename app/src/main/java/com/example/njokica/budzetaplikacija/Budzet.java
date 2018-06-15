package com.example.njokica.budzetaplikacija;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Budzet extends AppCompatActivity {


    ArrayList<String> listaBUdzet = new ArrayList<>();

    private static final String DATABASE_NAME = "MainActivity";

    DBHandler myDb;
    Button button2;
    Button button6;
    EditText editText3;
    ListView listaView;
    Spinner spinnerKategorije;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_budzet);

        editText3 = (EditText) findViewById(R.id.editText3);
        button2 = (Button) findViewById(R.id.button2);
        button6 = (Button) findViewById(R.id.button6);
        listaView = (ListView) findViewById(R.id.listaView);
        myDb = new DBHandler(this);
        spinnerKategorije = (Spinner) findViewById(R.id.spinnerKategorije);



        button2.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String noviUnos = editText3.getText() + " kn" + " " +spinnerKategorije.getSelectedItem().toString() ;
                //String noviUnos2 = spinner.getSelectedItem().toString();

                if (editText3.length() != 0) {
                    AddData(noviUnos); /*noviUnos2*/
                    editText3.setText("");
                } else {
                    toastMessage("Morate unjeti iznos budzeta!");
                }

                Intent intent = new Intent(Budzet.this, IspisPodataka.class);
                startActivity(intent);

            }



        });


        button6.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                HandlerTrosak db3 = new HandlerTrosak(getApplicationContext());
                deleteData1();




                Intent intent = new Intent(Budzet.this, IspisPodataka.class);
                startActivity(intent);
            }



        });

// Spinner click listener


        // Loading spinner data from database
        loadSpinnerData();

    }


    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    public void AddData(String noviUnos){ ///* String noviUnos2*/
        boolean unosPodataka = myDb.addData(noviUnos);
        //boolean unosPod = myDb.addData(noviUnos2);



        if(unosPodataka ){ //&& unosPod
            toastMessage("Podaci su uspješno spremljeni!");
        }else{
            toastMessage("Nešto nije u redu!");
        }
    }

    public void deleteData1(){
        boolean unosPodataka = myDb.deleteData1();

        if(unosPodataka){
            toastMessage("Podaci su uspješno izbrisani!");
        }else{
            toastMessage("Nešto nije u redu!");
        }
    }

    private void loadSpinnerData() {
        // database handler
        HandlerKategorije db2 = new HandlerKategorije(getApplicationContext());

        // Spinner Drop down elements
        List<String> kategorije = db2.getAllKategorije();

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, kategorije);

        // Drop down layout style - list view with radio button
        dataAdapter
                .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerKategorije.setAdapter(dataAdapter);
    }


}
