package s1eustei.eah.eah_app;

/**
 * Created by helmu on 29.01.2017.
 */

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.content.ContentValues;
import android.database.Cursor;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class DBVerwaltung {


    private SQLiteDatabase database;
    private DBHelper dbHelper;


    private String[] columns = {           //Spalten der Datenbank
            DBHelper.COLUMN_ID,
            DBHelper.COLUMN_NAME,
            DBHelper.COLUMN_MODULTYPE,
            DBHelper.COLUMN_DOZENT,
            DBHelper.COLUMN_RAUM,
            DBHelper.COLUMN_ANFANG,
            DBHelper.COLUMN_ENDE
    };


    public DBVerwaltung(Context context) {
        dbHelper = new DBHelper(context);
    }
    public void open() {
        database = dbHelper.getWritableDatabase();                          //Schreibenender Zugriff auf die DB
    }

    public void close() {
        dbHelper.close();
    }

    public DBQuelle createDBQuelle(String Name, modul_type modul_type, String Dozent, String Raum, String strAnfang, String strEnde) {
        ContentValues values = new ContentValues();                     //Daten in die DB schreiben
        values.put(DBHelper.COLUMN_NAME, Name);
        values.put(DBHelper.COLUMN_MODULTYPE, String.valueOf(modul_type));
        values.put(DBHelper.COLUMN_DOZENT, Dozent);
        values.put(DBHelper.COLUMN_RAUM, Raum);
        values.put(DBHelper.COLUMN_ANFANG, strAnfang);
        values.put(DBHelper.COLUMN_ENDE, strEnde);



        long insertId = database.insert(DBHelper.TABLE_STUNDENPLAN, null, values);

        Cursor cursor = database.query(DBHelper.TABLE_STUNDENPLAN, null, null, null, null, null, null); //Ganze Tabelle auslesen ohne zusätzliche Einstellungen ( wie z. B.Select, Having, Grouped BY

        cursor.moveToFirst();           // Bewegt den Cursor zum ersten Datensatz.
        DBQuelle dbQuelle = cursorToDBQuelle(cursor);
        cursor.close();

        return dbQuelle;
    }

    private DBQuelle cursorToDBQuelle(Cursor cursor) {
        int idIndex = cursor.getColumnIndex(DBHelper.COLUMN_ID);        //int sind die Indizes der Datensätze
        int idName= cursor.getColumnIndex(DBHelper.COLUMN_NAME);
        int idModul_type = cursor.getColumnIndex(DBHelper.COLUMN_MODULTYPE);
        int idDozent = cursor.getColumnIndex(DBHelper.COLUMN_DOZENT);
        int idRaum = cursor.getColumnIndex(DBHelper.COLUMN_RAUM);
        int idAnfang = cursor.getColumnIndex(DBHelper.COLUMN_ANFANG);
        int idEnde = cursor.getColumnIndex(DBHelper.COLUMN_ENDE);


        int id = cursor.getInt(idIndex);
        String Name = cursor.getString(idName);
        String Modul_type = cursor.getString(idModul_type);
        String Dozent = cursor.getString(idDozent);
        String Raum = cursor.getString(idRaum);         //Wandelt die int in Sting um
        String Anfang = cursor.getString(idAnfang);
        String Ende = cursor.getString(idEnde);


        DBQuelle dbQuelle = new DBQuelle(id, Name, modul_type.valueOf(Modul_type), Dozent,Raum,Anfang,Ende);

        return dbQuelle;
    }

    public List<DBQuelle> getAllDBQuelle() {
        List<DBQuelle> DBQuelleList = new ArrayList<>();

        Cursor cursor = database.query(DBHelper.TABLE_STUNDENPLAN,
                columns, null, null, null, null, null);

        cursor.moveToFirst();
        DBQuelle dbQuelle;

        while(!cursor.isAfterLast()) {          //Falls der letzte Datensatz noch NICHT erreicht wurde zum nächsten Datensatz gehen.
            dbQuelle = cursorToDBQuelle(cursor);
            DBQuelleList.add(dbQuelle);
            cursor.moveToNext();
        }

        cursor.close();

        return DBQuelleList;
    }
}


