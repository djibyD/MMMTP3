package istic.gla.mmm.tp3.mmmtp3;

import android.content.res.Configuration;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

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
