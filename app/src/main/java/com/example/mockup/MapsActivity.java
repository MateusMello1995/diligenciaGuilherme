package com.example.mockup;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MapsActivity extends AppCompatActivity implements OnMapReadyCallback {
    private DrawerLayout drawer;
    private GoogleMap mMap;

    //declara variaveis para permissão location
    private static final String[] LOCATION_PERMS={
            Manifest.permission.ACCESS_FINE_LOCATION
    };
    private static final int INITIAL_REQUEST=1337;
    private static final int LOCATION_REQUEST=INITIAL_REQUEST+3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, myToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();


    }


    @Override
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng taquara = new LatLng(-29.649537, -50.779593);
        LatLng portoAlegre = new LatLng(-30.026224, -51.228218);
        LatLng caxiasDoSul = new LatLng(-29.195007, -51.187176);
        LatLng gramado = new LatLng(-29.394283, -50.877335);
        LatLng torres = new LatLng(-29.355709, -49.734598);
        mMap.addMarker(new MarkerOptions().position(taquara).title("Marker in Porto Alegre"));
        mMap.addMarker(new MarkerOptions().position(portoAlegre).title("Marker in Porto Alegre"));
        mMap.addMarker(new MarkerOptions().position(caxiasDoSul).title("Marker in caxiasDoSul"));
        mMap.addMarker(new MarkerOptions().position(gramado).title("Marker in gramado"));
        mMap.addMarker(new MarkerOptions().position(torres).title("Marker in torres"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(taquara));

        //setar o zoom do telaMapa2
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(taquara, (8.0f)));
        //mostra controles do zoom
        mMap.getUiSettings().setZoomControlsEnabled(true);

        //verifica se é permitido ao aplicativo pegar a localização atual do dispositivo
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {
            mMap.setMyLocationEnabled(true);
        } else {
            //caso ainda não tenha sido dada a permissão, solicitar a permissão
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                requestPermissions(LOCATION_PERMS, LOCATION_REQUEST);
            }
        }

        //adiciona rota
        mMap.addPolyline(new PolylineOptions()
                .add(portoAlegre, caxiasDoSul, gramado, torres, portoAlegre)
                .width(5)
                .color(Color.RED));

        mMap.addCircle(
                new CircleOptions()
                        .center(taquara)
                        .radius(120000.0)
                        .strokeWidth(3f)
                        .strokeColor(Color.RED)
                        .fillColor(Color.argb(70,150,50,50))


        );
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);

    }
}