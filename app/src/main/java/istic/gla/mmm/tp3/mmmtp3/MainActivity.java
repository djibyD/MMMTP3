package istic.gla.mmm.tp3.mmmtp3;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Configuration configuration = getResources().getConfiguration();
        if(configuration.screenLayout >= Configuration.SCREENLAYOUT_SIZE_LARGE){

            if((findViewById(R.id.city) != null) && (findViewById(R.id.cityView) != null)){

                if(savedInstanceState != null){
                    return;
                }

                CityFragment cityFragment = new CityFragment();
                CityViewFragment cityViewFragment = new CityViewFragment();

                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.city, cityFragment).commit();
                fragmentManager.beginTransaction().add(R.id.cityView, cityViewFragment).commit();

            }

        }
        if((configuration.screenLayout >= Configuration.SCREENLAYOUT_SIZE_MASK)) {
            if(findViewById(R.id.city) != null){
                if(savedInstanceState != null){
                    return;
                }
                CityFragment cityFragment = new CityFragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().add(R.id.city, cityFragment).commit();
            }

        }

    }
}
