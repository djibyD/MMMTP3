package istic.gla.mmm.tp3.mmmtp3;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Switch;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityViewFragment extends Fragment {


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
            String city = bundle.getString("cityName");
            webView.loadUrl("http://technoresto.org/vdf/"+ processString(city) + "/index.html");
        }
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
    public void locate(View view){

    }

}
