package s1eustei.eah.eah_app;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Date;


public class Stundenplan extends AppCompatActivity {
    LinearLayout _linearLayout;
    Button _ButtonNextWeek, _ButtonPreviosWeek, _ButtonEdit;
    int _week = 1, _counterModul = 1;
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
        //getLayoutInflater().in XAML zur Laufzeit laden
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

        //add View
        scrollView.addView(linearLayout);
        extLayout.addView(scrollView);
        extLayout.addView(ButtonNextWeek);
        extLayout.addView(ButtonPreviosWeek);
        extLayout.addView(ButtonEdit);
        setContentView(extLayout);

        //get access to objects
        _linearLayout = linearLayout;
        _ButtonNextWeek = ButtonNextWeek;
        _ButtonPreviosWeek = ButtonPreviosWeek;
        _ButtonEdit = ButtonEdit;
    }

    private void addWeek(int week,String wocheAnfangEnde) {
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
        column1.setText("Woche " + week);
        column2.setText(wocheAnfangEnde);

        //add to ScrollView
        tableRow.addView(column1);
        tableRow.addView(column2);
        _linearLayout.addView(tableRow);
    }

    private void addModul(String start, String modul, String dozent, String raum, String ende, String datum) {
        Date calendar = new Date();
        String timeClock, cache ="", timeDate = "";
        int datumModul, startzeitModul, endzeitModul, datumCurrent, zeitCurrent, counter;

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
        /*
        start = start.replaceAll(":","");
        if (start.charAt(0) == '0'){
            for (counter = 1; counter <= 4; counter++){
                cache = cache.valueOf(start.charAt(counter));
            }
        }
        start = cache;

        ende = ende.replaceAll(":","");
        if (ende.charAt(0) == '0'){
            for (counter = 1; counter <= 4; counter++) {
                cache = cache.valueOf(ende.charAt(counter));
            }
        }
        ende = cache;

        //datum = datum.replaceAll(".","");
        //datum.replaceAll("0","");



        timeClock = String.valueOf(calendar.getHours()) + String.valueOf(calendar.getMinutes());

        cache = String.valueOf(calendar.getDate());
        timeDate = timeDate + cache;
        cache = String.valueOf(calendar.getMonth());
        timeDate = timeDate + String.valueOf(Integer.valueOf(cache) + 1);
        cache = String.valueOf(calendar.getYear());
        timeDate = timeDate + String.valueOf(Integer.valueOf(cache) + 1900);
        timeDate.replaceAll("0","");

        datumCurrent = Integer.valueOf(timeDate);
        zeitCurrent = Integer.valueOf(timeClock);
        datumModul = Integer.valueOf(datum);
        startzeitModul = Integer.valueOf(start);
        endzeitModul = Integer.valueOf(ende);

        if (datumCurrent == datumModul)
            if (zeitCurrent >= startzeitModul || zeitCurrent <= endzeitModul)
                tableRow.setBackgroundColor(Color.parseColor(_ColorActivModul));
        */

        // enabel the modul to be clickable
        String id;

        id = raum.charAt(0) + String.valueOf(_counterModul);
        tableRow.setId(Integer.valueOf(id));
        tableRow.isClickable();
        tableRow.setOnClickListener(getLageplan);

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

    private void getStundenplan(){
        int counter, id;
        String wocheAnfangEnde;
        String Day[] = {"Montag","Dienstag","Mittwoch","Donnerstag","Freitag","Sonnabend"};

        //create ScrollView and Buttons
        createView();
        //wocheAnfangEnde = Datenbank.getWocheAnfangEnde(week);
        addWeek(_week,"17.10.2016 - 22.10.2016");
        for (counter = 0; counter <= 5; counter++) {
            id = 1;
            addDay(Day[counter]);
            addModul("00:02", "ET(BA)Computergrafik/V/Ü/P/01.5", "Braungart, Herbst", "05.02.38", "23:59", "22012017");
            /*
            Datenbank modul = Datenbank.getNextModul(week,counter,id);
            while (modul != null){
                addModul(modul);
                //click Listener
                id++;
            }*/

        }
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.stundenplan);
        getStundenplan();
        //getLageplan();

        _ButtonPreviosWeek.setOnClickListener(OnBtnPreviosWeekListener);
        _ButtonNextWeek.setOnClickListener(OnBtnNextWeekListener);
        _ButtonEdit.setOnClickListener(OnBtnEditListener);

    }

    private View.OnClickListener OnBtnPreviosWeekListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if (_week > 1) {
                _week = _week - 1;
                getStundenplan();
                _ButtonPreviosWeek.setOnClickListener(OnBtnPreviosWeekListener);
                _ButtonNextWeek.setOnClickListener(OnBtnNextWeekListener);
                _ButtonEdit.setOnClickListener(OnBtnEditListener);
            } else AllertWocheRunter();
        }
    };

    private View.OnClickListener OnBtnNextWeekListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            if (_week < 17) {
                _week = _week + 1;
                getStundenplan();
                _ButtonPreviosWeek.setOnClickListener(OnBtnPreviosWeekListener);
                _ButtonNextWeek.setOnClickListener(OnBtnNextWeekListener);
                _ButtonEdit.setOnClickListener(OnBtnEditListener);
            } else AllertWocheHoch();


        }
    };

    private View.OnClickListener OnBtnEditListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(Stundenplan.this, Abos.class);
            startActivity(intent);
        }
    };

    View.OnClickListener getLageplan = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            String idTableRow;
            int haus;

            // get id of TableRow
            idTableRow = String.valueOf(view.getId());
            haus = Integer.valueOf(idTableRow.charAt(0));

            //load activity Lageplan with parameter
            LoadEAHPlan lageplan = new LoadEAHPlan();
            Intent intent = new Intent(Stundenplan.this, LoadEAHPlan.class);
            startActivity(intent);
            lageplan.getLagePlan(haus);
        }
    };

    private void AllertWocheHoch (){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Fehlermeldung");
        msg.setMessage("Sie befinden sich bereits in der letzten Woche!!!");
        msg.setCancelable(true);
        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    };

    private void AllertWocheRunter(){
        AlertDialog.Builder msg = new AlertDialog.Builder(this);
        msg.setTitle("Fehlermeldung");
        msg.setMessage("Sie befinden sich bereits in der ersten Woche!!!");
        msg.setCancelable(true);
        AlertDialog msgDialog = msg.create();
        msgDialog.show();
    };


    protected void onSaveInstanceState(Bundle saving) {
        //save the variable _week, when app is going on pause
        saving.putInt("_week",_week);
        super.onSaveInstanceState(saving);
    }

    protected void onRestoreInstanceState(Bundle restoring) {
        //restore the variable _week when the app is onStart()
        _week = restoring.getInt("_week",1);
        super.onRestoreInstanceState(restoring);
        getStundenplan();
        _ButtonPreviosWeek.setOnClickListener(OnBtnPreviosWeekListener);
        _ButtonNextWeek.setOnClickListener(OnBtnNextWeekListener);
        _ButtonEdit.setOnClickListener(OnBtnEditListener);
    }

}
