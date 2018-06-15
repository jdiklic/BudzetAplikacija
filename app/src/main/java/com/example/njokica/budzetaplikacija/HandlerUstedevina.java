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

    public boolean addData5(String item){
        SQLiteDatabase db5 = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(RED_iznos_ustedevine, item);

        Log.d(DATABASE_NAME, "dodaj podatke: dodavanje" + item + " u " + TABLICA_USTEDEVINA);
        long result_trosak = db5.insert(TABLICA_USTEDEVINA, null, contentValues);

        if(result_trosak == -1){
            return false;
        } else {
            return true;
        }
    }

    public Cursor getData5(){
        SQLiteDatabase db5 = this.getWritableDatabase();
        String query5 = "SELECT * FROM " + TABLICA_USTEDEVINA;
        Cursor data5 = db5.rawQuery(query5, null);
        return data5;
    }


}
