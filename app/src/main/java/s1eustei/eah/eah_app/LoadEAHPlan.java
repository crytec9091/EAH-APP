package s1eustei.eah.eah_app;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;




/**diese Klasse lädt je nach id, welche als Parameter übergeben wird, den jeweiligen Campusplan**/
public class LoadEAHPlan extends Activity {
    ImageView image_campus;
    int haus=0;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_eahplan);
        haus=getIntent().getIntExtra(Stundenplan.hausnummer,0);
        haus=5;
        image_campus = (ImageView) findViewById(R.id.campusplan_big);
        getLagePlan(haus);
    }
    public void getLagePlan(final int haus_id) {


                if (haus_id == 0) {
                    image_campus.setImageResource(R.drawable.campusplan_big);
                }
                if (haus_id == 1) {
                    image_campus.setImageResource(R.drawable.campusplan_haus_1);
                }
                if (haus_id == 2) {
                    image_campus.setImageResource(R.drawable.campusplan_haus_2);
                }
                if (haus_id == 3) {
                    image_campus.setImageResource(R.drawable.campusplan_haus_3);
                }
                if (haus_id == 4) {
                    image_campus.setImageResource(R.drawable.campusplan_haus_4);
                }
                if (haus_id == 5) {
                    image_campus.setImageResource(R.drawable.campusplan_haus_5);
                }
            }

    }

