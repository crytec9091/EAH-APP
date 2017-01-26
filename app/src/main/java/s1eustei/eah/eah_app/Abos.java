package s1eustei.eah.eah_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;


public class Abos extends AppCompatActivity {
    LinearLayout _linearLayout;
    String _BackgroundColor = "#e7ffff";


    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.abos);

        Button buttonAddSet = (Button)findViewById(R.id.abos_ButtonAddSet);
        buttonAddSet.setOnClickListener(OnButtonAddSetListener);
    }

    private View.OnClickListener OnButtonAddSetListener = new View.OnClickListener()
    {
        @Override
        public void onClick(View view)
        {
            Intent intent = new Intent(Abos.this, Studiengang_auswahl.class);
            startActivity(intent);
        }
    };
}
