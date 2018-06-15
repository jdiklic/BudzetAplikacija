package com.example.njokica.budzetaplikacija;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.EditText;



public class HandlerUstedevina extends SQLiteOpenHelper {


    public static final String DATABASE_NAME = "Ustedevina";

    //tablica Kategorija
    public static final String TABLICA_USTEDEVINA = "Ustedevina";
    public static final String sifra_ustedevine = "sifra_ustedevine";
    public static final String RED_iznos_ustedevine = "iznos_ustedevine";

    public HandlerUstedevina(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db4 = this.getReadableDatabase();
    }

    public void onCreate(SQLiteDatabase db4) {
        db4.execSQL("CREATE TABLE " + TABLICA_USTEDEVINA + "(sifra_ustedevine INTEGER PRIMARY KEY AUTOINCREMENT, iznos_ustedevine DOUBLE)");

    }

    public void onUpgrade(SQLiteDatabase db4, int oldVersion, int newVersion) {
        db4.execSQL("DROP TABLE IF EXISTS " + TABLICA_USTEDEVINA);

        onCreate(db4);

    }

    public Cursor addData4(){
        SQLiteDatabase db4 = this.getWritableDatabase();
       //String query4 = "INSERT INTO " + TABLICA_USTEDEVINA +"SELECT SUM"+ DBHandler.RED_iznos_budzeta +"from"+ DBHandler.TABLICA_BUDZET - HandlerTrosak.RED_naziv_troska +"FROM"+HandlerTrosak.TABLICA_TROSAK;


        Cursor data4 = db4.rawQuery("SELECT SUM(DBHandler.RED_iznos_budzeta)-(SELECT SUM(HandlerTrosak.RED_naziv_troska) FROM HandlerTrosak.TABLICA_TROSAK) FROM DBHandler.TABLICA_BUDZET", null);

        return data4;
    }

    public Cursor getData4(){
        SQLiteDatabase db4 = this.getWritableDatabase();
        String query4 = "SELECT * FROM " + TABLICA_USTEDEVINA;
        Cursor data4 = db4.rawQuery(query4, null);
        return data4;
    }


}
