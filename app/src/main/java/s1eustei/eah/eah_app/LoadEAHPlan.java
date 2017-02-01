package s1eustei.eah.eah_app;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;



public class LoadEAHPlan extends Activity {

    Button btn_campus;
    ImageView image_campus;
    //public int haus_id=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_eahplan);
        //addListenerButton();
    }/*
public void addListenerButton(){

    image_campus=(ImageView) findViewById(R.id.campusplan_big);
    btn_campus=(Button) findViewById(R.id.btn_campus_plan);
    //TODO hier muss die Haus_ID übergebenw werden

    btn_campus.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (haus_id==0){
                image_campus.setImageResource(R.drawable.campusplan_big);
            }if (haus_id==1){
                image_campus.setImageResource(R.drawable.campusplan_haus_1);
            }if (haus_id==2){
                image_campus.setImageResource(R.drawable.campusplan_haus_2);
            }if (haus_id==3){
                image_campus.setImageResource(R.drawable.campusplan_haus_3);
            }if (haus_id==4){
                image_campus.setImageResource(R.drawable.campusplan_haus_4);
            }if (haus_id==5){
                image_campus.setImageResource(R.drawable.campusplan_haus_5);
            }

        }
    });*/

    public void getLageplan_1(int haus_id){
        if (haus_id==0){
            image_campus.setImageResource(R.drawable.campusplan_big);
        }if (haus_id==1){
            image_campus.setImageResource(R.drawable.campusplan_haus_1);
        }if (haus_id==2){
            image_campus.setImageResource(R.drawable.campusplan_haus_2);
        }if (haus_id==3){
            image_campus.setImageResource(R.drawable.campusplan_haus_3);
        }if (haus_id==4){
            image_campus.setImageResource(R.drawable.campusplan_haus_4);
        }if (haus_id==5){
            image_campus.setImageResource(R.drawable.campusplan_haus_5);
        }
    }

}






