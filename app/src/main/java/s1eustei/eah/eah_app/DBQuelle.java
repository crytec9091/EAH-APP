package s1eustei.eah.eah_app;

import java.sql.Time;
import java.util.Date;

/**
 * Created by helmu on 29.01.2017.
 */



public class DBQuelle extends lernModul {   //Kindklasse der Klasse lernModul
    int id;
    public String Name;
    public modul_type modul_type;
    public String Dozent;
    public boolean Sichtbar;
    public String Raum;
    public Date Anfang;
    public Date Ende;

    public DBQuelle(String Name, modul_type modul_type, String Dozent,  String Raum, Date Anfang, Date Ende) {  //Konstruktor der Klasse DBQuelle
        this.Name = Name;
        this.modul_type = modul_type;
        this.Dozent = Dozent;
        this.Raum = Raum;
        this.Anfang = Anfang;
        this.Ende = Ende;
    }
//Get und Set Methoden

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public modul_type getmodul_type() {
        return modul_type;
    }

    public void setmodul_type(modul_type modul_type){
        this.modul_type = modul_type;
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

    public Date getAnfang() {
        return Anfang;
    }

    public void setAnfang(Time Anfang) {
        this.Anfang = Anfang;
    }

    public Date getEnde() {
        return Ende;
    }

    public void setEnde(Time Ende) {
        this.Ende = Ende;
    }
}