package s1eustei.eah.eah_app;

import java.sql.Date;

/**
 * Created by franz on 26.01.17.
 * Daten Struktur zur speicherung einzelner moduöl Einträge
 */

public class lernModul {
    int id;
    public String Name;
    public modul_type Type;
    public String Dozent;
    public boolean Sichtbar;
    public String Raum;
    public Date Anfang;
    public Date Ende;
}
