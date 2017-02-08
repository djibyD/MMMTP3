package istic.gla.mmm.tp3.mmmtp3;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import static java.security.AccessController.getContext;

/**
 * Created by djiby on 07/02/17.
 */

public class CityViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if((findViewById(R.id.city) != null)){

            if(savedInstanceState != null){
                return;
            }

            CityViewFragment cityViewFragment = new CityViewFragment();
            cityViewFragment.setArguments(getIntent().getExtras());

            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.city, cityViewFragment).commit();

        }
    }
}
