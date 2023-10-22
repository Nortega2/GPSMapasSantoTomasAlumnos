package com.example.gpsmapas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback, GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener {
    EditText txtLatitud, txtLongitud; //declaran e inicializan las variables
    GoogleMap mMap;// Objeto googleMap que se utilizara para interactuar con el mapa
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitud=findViewById(R.id.txt_Latitud);
        txtLongitud=findViewById(R.id.txt_Longitud);
        //se llama el fragmento mapa para asegurar qie el mapa este listo para su uso
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.maps);
        mapFragment.getMapAsync(this);
    }


    @Override//se llama cuando el mapa esta listo
    public void onMapReady(@NonNull GoogleMap googleMap) {
        mMap=googleMap;//Se inicializa el objeto mMAp con googleMao
        this.mMap.setOnMapClickListener(this);//Se configura el manejador del eventos de clic
        this.mMap.setOnMapLongClickListener(this);
        //Se coloca un marcador en una ubicacion especifica y se mueve la camara oara centrarla en esa ubicacion
        LatLng Chile = new LatLng(-35.675147,-71.542969);
        mMap.addMarker(new MarkerOptions().position(Chile).title("Chilito <3"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(Chile));
    }

    @Override//Utilizan este metodo para manejar los eventos del clic largo en el mapa
    public void onMapClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }
    //Se actualizan los campos de texto con las cordenadas de latitud y longitud
    @Override
    public void onMapLongClick(@NonNull LatLng latLng) {
        txtLatitud.setText(""+latLng.latitude);
        txtLongitud.setText(""+latLng.longitude);
    }
}