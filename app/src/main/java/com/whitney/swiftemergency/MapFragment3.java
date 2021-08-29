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

public class MapFragment3 extends Fragment {

    ArrayList<LatLng> arrayList2 = new ArrayList<LatLng>();
    LatLng fire1 = new LatLng(-1.287635,  36.813613);
    LatLng fire2 = new LatLng(-1.281757, 36.823121);
    // arraylist for names of markers
    ArrayList<String> title2 = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.map_fragment3, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map3);

        //Async map
        Objects.requireNonNull(supportMapFragment).getMapAsync(new OnMapReadyCallback() {



            @Override
            public void onMapReady(@NonNull GoogleMap googleMap2) {

                //when map is loaded
                arrayList2.add(fire1);
                arrayList2.add(fire2);
                // adding titles

                title2.add("G4S Fire Service");
                title2.add("Nairobi County Fire Station");

                for (int p=0;p<arrayList2.size();p++){
                    //for adding markers
                    for (int q=0;q<title2.size();q++){
                        //setting titles
                        googleMap2.addMarker(new MarkerOptions().position(arrayList2.get(p)).title(String.valueOf(title2.get(p))));
                    }
                    googleMap2.moveCamera(CameraUpdateFactory.newLatLng(arrayList2.get(p)));

                }

                // adding on click listeners for markers
                googleMap2.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        String markertitle = marker.getTitle();
                        Intent p = new Intent(MapFragment3.this.getActivity(), DetailsActivity.class);
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