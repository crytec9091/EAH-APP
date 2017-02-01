package s1eustei.eah.eah_app;

import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


/**diese Klasse lädt je nach id, welche als Parameter übergeben wird, den jeweiligen Campusplan**/
public class LoadEAHPlan extends Activity {

    Button btn_campus;
    ImageView image_campus;


    public void getLagePlan(final int haus_id){

    image_campus=(ImageView) findViewById(R.id.campusplan_big);


        setContentView(R.layout.activity_load_eahplan);
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
    });

}





}
