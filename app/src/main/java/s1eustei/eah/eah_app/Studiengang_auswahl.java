package s1eustei.eah.eah_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;


public class Studiengang_auswahl extends AppCompatActivity {

    private void htmlView(){
        LinearLayout linearLayout = new LinearLayout(this);
        WebView webView = new WebView(this);

        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
      //  webView.setLayoutParams(new WebView.LayoutParams(WebView.LayoutParams.MATCH_PARENT, WebView.LayoutParams.MATCH_PARENT));
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.studiengang_auswahl);
    }
}
