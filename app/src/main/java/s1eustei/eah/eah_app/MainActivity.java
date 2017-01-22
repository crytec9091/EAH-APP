package s1eustei.eah.eah_app;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.icu.text.DateFormat;
import android.icu.util.Calendar;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;


import java.util.Date;

import static s1eustei.eah.eah_app.R.layout.activity_main;

public class MainActivity extends AppCompatActivity {

    //get access to createt Objekt in CreateScrollView
    LinearLayout _linearLayout;
    int _week = 1;
    String _BackgroundColor = "#e7ffff";
    String _ColorActivModul = "#009696";
    String _ColorButton = "#FF56FAB8";


    private void createView() {
        //create ScrollView and LinearLayout
        ScrollView scrollView = new ScrollView(this);
        LinearLayout linearLayout = new LinearLayout(this);
        CoordinatorLayout extLayout = new CoordinatorLayout(this);
        Button ButtonNextWeek = new Button(this);
        Button ButtonPreviosWeek = new Button(this);
        Button ButtonEdit = new Button(this);
        // define layout
        scrollView.setLayoutParams(new ScrollView.LayoutParams(ScrollView.LayoutParams.MATCH_PARENT, ScrollView.LayoutParams.MATCH_PARENT));
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        linearLayout.setOrientation(LinearLayout.VERTICAL);
        DisplayMetrics metrics = this.getResources().getDisplayMetrics(); // get display dim
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        width = width - 190;
        height = height - 270;
        ButtonPreviosWeek.setX(10);
        ButtonPreviosWeek.setY(height);
        ButtonPreviosWeek.setBackgroundColor(Color.parseColor(_ColorButton));
        ButtonPreviosWeek.setText("<");
        ButtonNextWeek.setX(200);
        ButtonNextWeek.setY(height);
        ButtonNextWeek.setBackgroundColor(Color.parseColor(_ColorButton));
        ButtonNextWeek.setText(">");
        ButtonEdit.setX(width);
        ButtonEdit.setY(height);
        ButtonEdit.setBackgroundColor(Color.parseColor(_ColorButton));
        ButtonEdit.setText("Edit");
        //add to LinearLayout
        scrollView.addView(linearLayout);
        extLayout.addView(scrollView);
        extLayout.addView(ButtonNextWeek);
        extLayout.addView(ButtonPreviosWeek);
        extLayout.addView(ButtonEdit);
        setContentView(extLayout);
        _linearLayout = linearLayout;
    }

    private void addWeek() {
        //create objects
        TableRow tableRow = new TableRow(this);
        TextView column1 = new TextView(this);
        TextView column2 = new TextView(this);
        //define layout
        tableRow.setBackgroundColor(Color.parseColor(_BackgroundColor));
        column1.setTextSize(25);
        column1.setGravity(0);
        column1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));
        column2.setTextSize(15);
        column2.setGravity(5);
        column2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));
        //content
        column1.setText("Woche " + _week);
        column2.setText("88.88. - 88.88.");
        //add to ScrollView
        tableRow.addView(column1);
        tableRow.addView(column2);
        _linearLayout.addView(tableRow);
    }

    //die Funktion des aktuellen Moduls muss noch implementiert werden, Zur Zeit werden alle Einträge als solche markiert!!!
    private void addModul(String start, String modul, String dozent, String raum, String ende, String day) {
        //create objects
        TableRow tableRow = new TableRow(this);
        TextView column1 = new TextView(this);
        TextView column2 = new TextView(this);
        TextView column3 = new TextView(this);
        //define layout
        column1.setTextSize(15);
        column1.setGravity(0);
        column1.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));
        column2.setTextSize(15);
        column2.setGravity(17);
        column2.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));
        column3.setTextSize(15);
        column3.setGravity(5);
        column3.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, 0.1f));

        //content
        column1.setText(start);
        column2.setText(modul + "\n" + dozent + "\n" + raum);
        column3.setText(ende);

        //marks the current Modules
        Date calendar = new Date();

        String timeClock;
        String timeDate;

        start.replace(":","");
        ende.replace(":","");
        day.replace(".","");
        timeClock = String.valueOf(calendar.getHours()) + String.valueOf(calendar.getMinutes());
        timeDate = String.valueOf(calendar.getDay())  + String.valueOf(calendar.getMonth()) + String.valueOf(calendar.getYear());

        if (Integer.valueOf(timeDate) == Integer.valueOf(day))
            if (Integer.valueOf(timeClock) >= Integer.valueOf(start) || Integer.valueOf(timeClock) <= Integer.valueOf(ende))
                tableRow.setBackgroundColor(Color.parseColor(_ColorActivModul));

        //add to ScrollView;
        tableRow.addView(column1);
        tableRow.addView(column2);
        tableRow.addView(column3);
        _linearLayout.addView(tableRow);
    }

    private void addDay(String tag){
        TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setBackgroundColor(Color.parseColor(_BackgroundColor));
        textView.setText(tag);
        _linearLayout.addView(textView);
    }

    private void getModuleforDay(String day){
        addModul("00:01","ET(BA)Computergrafik/V/Ü/P/01.5", "Braungart, Herbst", "05.02.38", "23:59", "22.01.2016");
    }

    private void getFloatingActionButtonNextWeek(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        createView();
        addWeek();
        addDay(" Montag");
        getModuleforDay("22.01.2017");
        addDay(" Dienstag");
        getModuleforDay("23.01.2017");
        addDay(" Mittwoch");
        getModuleforDay("24.01.2017");
        addDay(" Donnerstag");
        getModuleforDay("25.01.2017");
        addDay(" Freitag");
        getModuleforDay("26.01.2017");
        addDay(" Sonnabend");
        getModuleforDay("27.01.2017");


    }
}
