package com.whitney.swiftemergency;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.Objects;

public class MapFragment4 extends Fragment {

    ArrayList<LatLng> arrayList3 = new ArrayList<LatLng>();
    LatLng violence1 = new LatLng(-1.300707,  36.806465);
    // arraylist for names of markers
    ArrayList<String> title3 = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.map_fragment4, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map4);

        //Async map
        Objects.requireNonNull(supportMapFragment).getMapAsync(new OnMapReadyCallback() {



            @Override
            public void onMapReady(@NonNull GoogleMap googleMap3) {

                //when map is loaded
                arrayList3.add(violence1);
                // adding titles

                title3.add("Gender Based Violence Recovery Centre K.N.H");

                for (int p=0;p<arrayList3.size();p++){
                    //for adding markers
                    for (int q=0;q<title3.size();q++){
                        //setting titles
                        googleMap3.addMarker(new MarkerOptions().position(arrayList3.get(p)).title(String.valueOf(title3.get(p))));
                    }
                    googleMap3.moveCamera(CameraUpdateFactory.newLatLng(arrayList3.get(p)));

                }

                // adding on click listeners for markers
                googleMap3.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        String markertitle = marker.getTitle();
                        Intent p = new Intent(MapFragment4.this.getActivity(), DetailsActivity.class);
                        //passing title to new activity
                        p.putExtra("title", markertitle);
                        startActivity(p);

                        return false;
                    }
                });


            }
        });

        return view;

    }
}