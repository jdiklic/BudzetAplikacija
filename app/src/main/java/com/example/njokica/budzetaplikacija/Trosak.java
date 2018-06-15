package com.example.njokica.budzetaplikacija;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Trosak extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    ArrayList<String> listaTRoskova = new ArrayList<>();

    private static final String DATABASE_NAME = "MainActivity";

    DBHandler myDb;
    HandlerTrosak myDb3;
    Button button3;
    Button button6;
    EditText editText4;
    ListView listaTroskova;
    Spinner spinnerKategorije;
    ListView listaKategorija;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trosak);
        spinnerKategorije = (Spinner)  findViewById(R.id.spinnerKategorije);
        editText4 = (EditText) findViewById(R.id.editText4);
        button3 = (Button) findViewById(R.id.button3);
        listaTroskova = (ListView) findViewById(R.id.listaTroskova);
        myDb = new DBHandler(this);
        myDb3 = new HandlerTrosak(this);
        button6 = (Button) findViewById(R.id.button6);



        spinnerKategorije.setOnItemSelectedListener(this);
        loadSpinnerData();

        button3.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String noviUnos3 = editText4.getText()+ " kn" + " " +spinnerKategorije.getSelectedItem().toString();

                if (editText4.length() != 0) {
                    HandlerTrosak db3 = new HandlerTrosak(getApplicationContext());
                    AddData3(noviUnos3);
                    editText4.setText("");
                    loadSpinnerData();

                } else {
                    toastMessage("Morate unjeti iznos troška!");
                }



                Intent intent = new Intent(Trosak.this, IspisTroskova.class);
                startActivity(intent);
            }



        });




        button6.setOnClickListener (new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                    HandlerTrosak db3 = new HandlerTrosak(getApplicationContext());
                deleteData();
                    editText4.setText("");
                    loadSpinnerData();




                Intent intent = new Intent(Trosak.this, IspisTroskova.class);
                startActivity(intent);
            }



        });








    }

    private void loadSpinnerData(){
        HandlerKategorije myDb2 = new HandlerKategorije(getApplicationContext());
        List<String> kategorije = myDb2.getAllKategorije();
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, kategorije);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerKategorije.setAdapter(dataAdapter);
    }





    private void toastMessage(String message){
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }


    public void AddData3(String noviUnos3){
        boolean unosPodataka = myDb3.addData3(noviUnos3);

        if(unosPodataka){
            toastMessage("Podaci su uspješno unešeni!");
        }else{
            toastMessage("Nešto nije u redu!");
        }
    }



    public void deleteData(){
        boolean unosPodataka = myDb3.deleteData();

        if(unosPodataka){
            toastMessage("Podaci su uspješno izbrisani!");
        }else{
            toastMessage("Nešto nije u redu!");
        }
    }


    private void setEditTextDefaultValue() {
        editText4.setText(String.valueOf(0));
        editText4.selectAll();
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String kategorije = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }



}
