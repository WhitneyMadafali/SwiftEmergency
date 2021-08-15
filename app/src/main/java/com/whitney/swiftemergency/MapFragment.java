package com.whitney.swiftemergency;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

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

public class MapFragment extends Fragment {

    ArrayList<LatLng>arrayList = new ArrayList<LatLng>();
    LatLng hospital1 = new LatLng(-1.309449,  36.814782);
    LatLng hospital2 = new LatLng(-1.3079015, 36.8033858);
    LatLng police1 = new LatLng(-1.303275,  36.806269);
    LatLng police2 = new LatLng(-1.304958, 36.825213);
    LatLng fire1 = new LatLng(-1.287635,  36.813613);
    LatLng fire2 = new LatLng(-1.281757, 36.823121);
    LatLng violence1 = new LatLng(-1.300707,  36.806465);
    // arraylist for names of markers
    ArrayList<String> title = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Initialize view
        View view = inflater.inflate(R.layout.fragment_map, container, false);

        // Initialize map fragment
        SupportMapFragment supportMapFragment = (SupportMapFragment)
                getChildFragmentManager().findFragmentById(R.id.google_map);

        //Async map
        Objects.requireNonNull(supportMapFragment).getMapAsync(new OnMapReadyCallback() {



            @Override
            public void onMapReady(@NonNull GoogleMap googleMap) {

                //when map is loaded
                arrayList.add(hospital1);
                arrayList.add(hospital2);
                arrayList.add(police1);
                arrayList.add(police2);
                arrayList.add(fire1);
                arrayList.add(fire2);
                arrayList.add(violence1);
                // adding titles

                title.add("Strathmore Clinic");
                title.add("Mbaghathi Hospital");
                title.add("K.N.H Police Station");
                title.add("Nyayo Police Station");
                title.add("G4S Fire Service");
                title.add("Nairobi County Fire Station");
                title.add("Gender Based Violence Recovery Centre K.N.H");


                for (int i=0;i<arrayList.size();i++){
                    //for adding markers
                    for (int j=0;j<title.size();j++){
                        //setting titles
                        googleMap.addMarker(new MarkerOptions().position(arrayList.get(i)).title(String.valueOf(title.get(i))));
                    }
                    googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(arrayList.get(i), 10));

                }

                // adding on click listeners for markers
                googleMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(@NonNull Marker marker) {
                        String markertitle = marker.getTitle();
                        Intent i = new Intent(MapFragment.this.getActivity(), DetailsActivity.class);
                        //passing title to new activity
                        i.putExtra("title", markertitle);
                        startActivity(i);

                        return false;
                    }
                });


            }
        });

        return view;
    }
}