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

public class MapFragment2 extends Fragment {

    ArrayList<LatLng>arrayList1 = new ArrayList<LatLng>();
    LatLng police1 = new LatLng(-1.303275,  36.806269);
    LatLng police2 = new LatLng(-1.304958, 36.825213);
    // arraylist for names of markers
    ArrayList<String> title1 = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.map_fragment2, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.google_map2);

        //Async map
        Objects.requireNonNull(supportMapFragment).getMapAsync(new OnMapReadyCallback() {



            @Override
            public void onMapReady(@NonNull GoogleMap googleMap1) {

                //when map is loaded
                arrayList1.add(police1);
                arrayList1.add(police2);
                // adding titles

                title1.add("K.N.H Police Station");
                title1.add("Nyayo Police Station");

                for (int p=0;p<arrayList1.size();p++){
                    //for adding markers
                    for (int q=0;q<title1.size();q++){
                        //setting titles
                        googleMap1.addMarker(new MarkerOptions().position(arrayList1.get(p)).title(String.valueOf(title1.get(p))));
                    }
                    googleMap1.moveCamera(CameraUpdateFactory.newLatLng(arrayList1.get(p)));

                }

                // adding on click listeners for markers
                googleMap1.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        String markertitle = marker.getTitle();
                        Intent p = new Intent(MapFragment2.this.getActivity(), DetailsActivity.class);
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