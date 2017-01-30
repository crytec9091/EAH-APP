package s1eustei.eah.eah_app;

import android.provider.DocumentsContract;

/**
 * Created by franz on 26.01.17.
 */

import org.jsoup.Jsoup;
import org.jsoup.helper.Validate;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
//import lern
public class ParseKalender {
    private org.jsoup.nodes.Document htmlSite;
    private boolean success;
    private  org.jsoup.select.Elements tbody;

    public void getHtml(String uri){
        try{
            htmlSite=Jsoup.connect(uri);
            success=true;
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    public Parse(){
        tbody = htmlSite.select("tbody");
        for(org.jsoup.nodes.Element table :tbody){
            org.jsoup.select.Elements trs = table.children();
            for(org.jsoup.nodes.Element tr: trs){
                org.jsoup.select.Elements tds = tr.children();
                String Anfang =tds.get(0).text();
                String Ende= tds.get(1).text();
                String Name=tds.get(2).text();
                String Dozent = tds.get(3).text();
                String Raum=tds.get(4).text();
                String Wochen= tds.get(5).text();
                String Beginn=tds.get(6).text();
            }
        }
    }
}
