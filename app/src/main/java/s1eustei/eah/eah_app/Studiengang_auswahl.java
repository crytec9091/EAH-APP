package s1eustei.eah.eah_app;

import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Studiengang_auswahl extends AppCompatActivity {

    private String getStringFromBufferedReader(BufferedReader bufferedReader) throws IOException
    {
        String line = "";
        String bufferedString = "";

        while (line != null)
        {
            line = bufferedReader.readLine();
            if (line != null)
            {
                bufferedString += line;
            }
        }
        return bufferedString;
    }

    private void htmlView(){
        LinearLayout linearLayout = new LinearLayout(this);
        final WebView webView = new WebView(this);

        //set Layout
        linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        //webView.setLayoutParams(new WebView.LayoutParams(WebView.LayoutParams.MATCH_PARENT, WebView.LayoutParams.MATCH_PARENT));

        //content
        AssetManager assetManager = getAssets();
        BufferedReader bufferedReader = null;

        try {
            bufferedReader = new BufferedReader(new InputStreamReader(assetManager.open("Formular.html")));
            String html = getStringFromBufferedReader(bufferedReader);

            String mime = "text/html";
            String encoding = "utf-8";

            //load html code
            WebView myWebView = (WebView) webView;
            myWebView.getSettings().setJavaScriptEnabled(true);
            myWebView.loadDataWithBaseURL(null, html, mime, encoding, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setContentView(webView);

        //handle site load instead of click
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView myWebView, String url) {
                webView.loadUrl(webView.getUrl());
                setContentView(R.layout.studiengang_auswahl);
                TextView textView = (TextView) findViewById(R.id.Studiengang_Wahl_Info);
                textView.setText(webView.getUrl());
                return true;
            }
        });
    }

    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //load activity
        setContentView(R.layout.studiengang_auswahl);
        htmlView();
    }
}
