package s1eustei.eah.eah_app;


import android.content.Context;

import android.content.pm.PackageManager;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by eugen on 30.01.2017.
 */

public class GPS extends AppCompatActivity implements LocationListener {
    private TextView latitudeField;
    private TextView longitudeField;
    private LocationManager locationManager;
    private String provider;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        latitudeField = (TextView) findViewById(R.id.TextView02);

        longitudeField = (TextView) findViewById(R.id.TextView04);

        /** Kontakt mit Location Manager**/
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        /** festlegen wie der location provider ausgewählt wird**/

        Criteria criteria = new Criteria();
        provider = locationManager.getBestProvider(criteria, false);
        /** Berechtigungscheck**/
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        /** aktuelle Posoition**/
        Location location = locationManager.getLastKnownLocation(provider);

        /** initialisieren der Location**/
    if(location!=null)

    {
        System.out.println("Provider " + provider + " has been selected.");
        onLocationChanged(location);
    }

    else

    {
        latitudeField.setText("Location not available");
        longitudeField.setText("Location not available");
    }

}
    @Override
    protected void onResume() {
        super.onResume();
        /** Berechtigungscheck**/
        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(provider, 400, 1, this);

    }

    @Override
    protected void onPause() {
        super.onPause();

        if (ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(this);
    }


@Override
public void onLocationChanged(Location location) {
        double lat =  (location.getLatitude());
        double lng =  (location.getLongitude());
        latitudeField.setText(String.valueOf(lat));
        longitudeField.setText(String.valueOf(lng));
        }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }



@Override
public void onProviderEnabled(String provider) {
        Toast.makeText(this, "Enabled new provider " + provider,
        Toast.LENGTH_SHORT).show();

        }

@Override
public void onProviderDisabled(String provider) {
        Toast.makeText(this, "Disabled provider " + provider,
        Toast.LENGTH_SHORT).show();
        }

}
