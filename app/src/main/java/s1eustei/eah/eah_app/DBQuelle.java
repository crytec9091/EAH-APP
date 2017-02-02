package s1eustei.eah.eah_app;

import com.google.android.gms.cast.Cast;

import java.sql.Time;
import java.util.Date;

/**
 * Created by helmu on 29.01.2017.
 */



public class DBQuelle extends lernModul {   //Kindklasse der Klasse lernModul
    int id;
    public String Name;
    public modul_type Modul_type;
    public String Dozent;
    public boolean Sichtbar;
    public String Raum;
    public Date Anfang;
    public Date Ende;

    String strAnfang = Anfang.toString();
    String strEnde = Ende.toString();


    public DBQuelle(int id, String Name, modul_type Modul_type, String Dozent, String Raum, String strAnfang, String strEnde) {  //Konstruktor der Klasse DBQuelle
        this.id = id;
        this.Name = Name;
        this.Modul_type = Modul_type;
        this.Dozent = Dozent;
        this.Raum = Raum;
        this.strAnfang = strAnfang;
        this.strEnde = strEnde;
    }


//Get und Set Methoden


    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public modul_type getmodul_type() {
        return Modul_type;
    }

    public void setmodul_type(modul_type modul_type) {
        this.Modul_type = modul_type;
    }

    public String getDozentD() {
        return Dozent;
    }

    public void setDozent(String Dozent) {
        this.Dozent = Dozent;
    }

    public String getRaum() {
        return Raum;
    }

    public void setRaum(String Raum) {
        this.Raum = Raum;
    }

    public String getstrAnfang() {
        return strAnfang;
    }

    public void setstrAnfang(String strAnfang) {
        this.strAnfang = strAnfang;
    }

    public String getstrEnde() {
        return strEnde;
    }

    public void setstrEnde(String strEnde) {
        this.strEnde = strEnde;
    }

}