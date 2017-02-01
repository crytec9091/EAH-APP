package s1eustei.eah.eah_app;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.sql.Time;
import java.util.Date;


/**
 * Created by helmu on 29.01.2017.
 */

public class DBHelper extends SQLiteOpenHelper {        //Hilfsklasse zum Erstellen Der Datenbank

    //Die Bestandteile der DB


    public static final String DB_NAME = "EAH_StundenplanDB.db";
    public static final int DB_VERSION = 1;
        //Tabelle
    public static final String TABLE_STUNDENPLAN = "stundenplan";
        //Spalten
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_MODULTYPE = "modul_type";
    public static final String COLUMN_DOZENT = "dozent";
    public static final String COLUMN_RAUM = "raum";
    public static  Time COLUMN_ANFANG;
    public static  Time COLUMN_ENDE ;





    public static final String SQL_CREATE =                         //Der auszuführende SQL-String
            "CREATE TABLE " + TABLE_STUNDENPLAN +
                    "(" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    COLUMN_NAME + " TEXT NOT NULL, " +
                    COLUMN_MODULTYPE + " TEXT NOT NULL, " +
                    COLUMN_DOZENT + " TEXT NOT NULL, " +
                    COLUMN_ANFANG + " DATE NOT NULL, " +
                    COLUMN_ENDE + " DATE NOT NULL)";




    public DBHelper(Context context) { //Konstruktor
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {        //Methode der Hilfsklasse DBHelfer zum Erstellen der DB
        try {
            db.execSQL(SQL_CREATE);                 //Der SQL-String wird ausgeführt
        }
        catch (Exception ex) {
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {       //Methode der Hilfsklasse DBHelfer zum Upgraden der DB

    }
}
