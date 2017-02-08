package istic.gla.mmm.tp3.mmmtp3;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CityFragment extends Fragment {


    private List<String> cities;
    ListView listView;

    public CityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_city, container, false);

        cities = new ArrayList<String>();
        cities.add("Alsace");
        cities.add("Beaujolais");
        cities.add("Jura");
        cities.add("Champagne");
        cities.add("Savoie");
        cities.add("Languedoc-Roussillon");
        cities.add("Bordelais");
        cities.add("Vallée du Rhone");
        cities.add("Provence");
        cities.add("Val de Loire");
        cities.add("Sud-Ouest");
        cities.add("Corse");
        cities.add("Bourgogne");


        listView = (ListView) view.findViewById(R.id.cityListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

               startCityViewActivity(view);
            }
        });
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext(),
                R.layout.city_items,
                cities);
        listView.setAdapter(arrayAdapter);

        return view;
    }

    private void startCityViewActivity(View view) {
        TextView textView = (TextView) view.findViewById(R.id.city_item);
        if( getActivity().getSupportFragmentManager().findFragmentById(R.id.cityView) != null){//Fragment present
            CityViewFragment cityViewFragment = new CityViewFragment();
            Bundle bundle = new Bundle();
            bundle.putString("cityName", textView.getText().toString());
            cityViewFragment.setArguments(bundle);

            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            fragmentManager.beginTransaction().add(R.id.cityView, cityViewFragment).commit();
        }
        else {

            Intent intent = new Intent(getContext(), CityViewActivity.class);
            String n = textView.getText().toString();
            intent.putExtra("cityName", n);
            startActivity(intent);
        }
    }

}

