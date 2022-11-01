package edu.upi.cs.mobileapp.techi.pedulilansia;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import edu.upi.cs.mobileapp.techi.pedulilansia.databinding.ActivityRelativeMapsBinding;

public class RelativeMapsActivity extends FragmentActivity implements OnMapReadyCallback
{

    private ActivityRelativeMapsBinding binding;
    private FragmentTransaction transaction;

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        binding = ActivityRelativeMapsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        transaction = getSupportFragmentManager().beginTransaction();
        transaction.add(R.id.map, new RelativeMapsButtonFragment()).commit();
    }

    @Override
    public void onMapReady(GoogleMap googleMap)
    {
        mMap = googleMap;

        // Add a marker in UPI and move the camera.
        LatLng sydney = new LatLng(-6.859870494855354, 107.59378225116951);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }
}