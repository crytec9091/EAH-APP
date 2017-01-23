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
