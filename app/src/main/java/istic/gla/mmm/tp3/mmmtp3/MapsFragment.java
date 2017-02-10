package istic.gla.mmm.tp3.mmmtp3;

import android.location.Geocoder;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.identity.intents.Address;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.List;

/**
 * Created by djiby on 10/02/17.
 */

public class MapsFragment extends Fragment implements OnMapReadyCallback{

    private MapView mapView;
    private GoogleMap mMap;
    private String selectedCityName;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.maps_fragment_layout, container, false);

        Bundle bundle = this.getArguments();
        if (bundle != null){
            selectedCityName = bundle.getString("cityName");
        }

        mapView = (MapView) view.findViewById(R.id.map_fragment);
        mapView.onCreate(savedInstanceState);
        mapView.onResume();
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double latitude = 0;
        double longitude = 0;

        Geocoder geocoder = new Geocoder(getContext());
        try {
            List<android.location.Address> addresses = geocoder.getFromLocationName(selectedCityName, 5);
            if(addresses.size()>0){
                latitude = addresses.get(0).getLatitude();
                longitude = addresses.get(0).getLongitude();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

        // Add a marker in Sydney and move the camera
        LatLng city = new LatLng(latitude, longitude);
        mMap.addMarker(new MarkerOptions().position(city).title(selectedCityName));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(city));
    }
}
