package istic.gla.mmm.tp3.mmmtp3;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityViewFragment extends Fragment {

    private String cityName;

    public CityViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city_view, container, false);
        WebView webView = (WebView) view.findViewById(R.id.city_web_view);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        //Get city the selected city
        Bundle bundle = this.getArguments();
        if (bundle != null){
            cityName = bundle.getString("cityName");
            webView.loadUrl("http://technoresto.org/vdf/"+ processString(cityName) + "/index.html");
        }
        Button button = (Button) view.findViewById(R.id.localisationButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                locate();
            }
        });
        return view;
    }

    //Process to get the right city name(for the linx) from the one received from the intent
    private String processString(String cityNameFromItent){


        switch(cityNameFromItent){

            case "Alsace" : return "alsace";
            case "Beaujolais" : return "beaujolais";
            case "Jura" : return "jura";
            case "Champagne" : return "champagne";
            case "Savoie" : return "savoie";
            case "Languedoc-Roussillon" : return "languedoc";
            case "Bordelais" : return "bordelais";
            case "Vallée du Rhone" : return "cotes_du_rhone";
            case "Provence" : return "provence";
            case "Val de Loire" : return "val_de_loire";
            case "Sud-Ouest" : return "sud-ouest";
            case "Corse" : return "corse";
            case "Bourgogne" : return "bourgogne";
            default : return "";


        }

    }

    //Exercice 1.2
    private void locate() {
        if( getActivity().getSupportFragmentManager().findFragmentById(R.id.cityView) != null){//Fragment present
            MapsFragment mapsFragment = new MapsFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cityName", cityName);
            mapsFragment.setArguments(bundle);
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.cityView, mapsFragment).commit();
        }
        else {
            Intent intent = new Intent(getContext(), MapsActivity.class);
            intent.putExtra("cityName", cityName);
            startActivity(intent);
        }
    }
}
