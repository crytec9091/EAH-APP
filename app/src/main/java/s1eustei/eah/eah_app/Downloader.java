package s1eustei.eah.eah_app;

// nach einer Vorlage aus dem Netz. hier wird die Url im Asynctask geladen und als string an die MainActivity weitergeben
//TODO übergabe von verschiedenen URLS aus verschiedenen Activities als variable
//TODO parsen
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import android.os.AsyncTask;
import android.util.Log;

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
    public interface DownloadCompleteListener {
        	void onDownloadComplete(String result);
        	}
    private DownloadCompleteListener dc = null;
	//public Downloader(DownloadCompleteListener dc){

	//}
    public Downloader(DownloadCompleteListener dc) {
       	this.dc = dc;
        	}

    @Override
    	protected void onPostExecute(String result) {
    	dc.onDownloadComplete(result);
    	}

    }
