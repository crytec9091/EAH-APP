package s1eustei.eah.eah_app;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private TextView finalResult;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        finalResult=(TextView) findViewById(R.id.stundenplan);
        //alles bzgl des layouts war nur für test...kann weg
        Button btDownloadStart = (Button) findViewById(R.id.startDownload);
        btDownloadStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Downloader downloader=new Downloader();
                downloader.execute("http://stundenplanung.eah-jena.de");
            }
        });
    }

    public class Downloader extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... urls) {
            String response = "";
            for (String url : urls) {
                response += downloadWebpage(url);
            }

            return response.toString();
        }

        private String downloadWebpage(String url) {
            try {
                HttpClient client = new DefaultHttpClient();
                HttpGet get = new HttpGet(url);
                HttpResponse response = client.execute(get);
                InputStream in = response.getEntity().getContent();
                BufferedReader reader = new BufferedReader(
                        new InputStreamReader(in));
                String source = "";
                String tmp;
                while ((tmp = reader.readLine()) != null) {
                    source += tmp;
                }

                return source;
            } catch (IOException io) {
                Log.e("Downloader", "Couldn't downlaod " + url);
                io.printStackTrace();
                return "Error when downloading Webpage" + url;
            }
        }

        @Override
        protected void onPostExecute(String result) {
            finalResult.setText(result);
        }

    }




    @Override
    protected void onResume() {
        super.onResume();


    }

    @Override
    protected void onPause() {
        super.onPause();


    }


}
