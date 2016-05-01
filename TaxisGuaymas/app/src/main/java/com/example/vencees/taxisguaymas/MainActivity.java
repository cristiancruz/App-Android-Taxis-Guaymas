package com.example.vencees.taxisguaymas;


import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;

import android.location.Address;
import android.location.Criteria;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.provider.Settings;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.List;


public class MainActivity extends FragmentActivity implements OnMapReadyCallback{

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState)throws SecurityException {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Button pedirTaxi= (Button)findViewById(R.id.BotonPedir);
        pedirTaxi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent lista = new Intent(MainActivity.this, ListaActivity.class);
                startActivity(lista);

            }
        });


        Geocoder geocoder = new Geocoder(getApplicationContext());
        List<Address> direcciones = null;
        try {
            getBestCriteria();
            LocationManager locManager = (LocationManager) getSystemService((Context.LOCATION_SERVICE));
            Location loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
            direcciones = geocoder.getFromLocation(loc.getLatitude(),loc.getLongitude(),1);
        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Sin conexión", Toast.LENGTH_SHORT).show();
        }

        if(direcciones != null && direcciones.size() > 0 ){
            Address direccion = direcciones.get(0);
            TextView dir=(TextView)findViewById(R.id.Direccion);
            dir.setText(" Ubicación "+direccion.getAddressLine(0));
        }

    }
    private Criteria getBestCriteria(){
        Criteria req = new Criteria();
        req.setAccuracy(Criteria.ACCURACY_FINE);
        req.setAltitudeRequired(true);
        return req;
    }
    public void getLocationOnClick(View v) throws SecurityException {
        try {
            LocationManager locManager = (LocationManager) getSystemService((Context.LOCATION_SERVICE));
            Location loc = locManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);


            LatLng MyUbicacion = new LatLng(loc.getLatitude(),loc.getLongitude());
            mMap.addMarker(new MarkerOptions()
                    .position(MyUbicacion)
                    .title("¡Aqui Estas!")
                    .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicacion)));
            mMap.moveCamera(CameraUpdateFactory.newLatLng(MyUbicacion));

        } catch(Exception e){
            LatLng redireccion = new LatLng(27.920126, -110.902780);
            mMap.moveCamera(CameraUpdateFactory.newLatLng(redireccion));
            Toast.makeText(getApplicationContext(), "Gps apagado, se recomienda activarlo", Toast.LENGTH_SHORT).show();
        }

    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */

    @Override
    public void onMapReady(GoogleMap googleMap)throws SecurityException {
        mMap = googleMap;
        //++++++++++++++++++++++ INICIO SITIO DE TAXIS++++++++++++++++++++++++++++++++++
        getBestCriteria();
        getLocationOnClick(null);

        LatLng taxi1 = new LatLng(27.946242, -110.929448);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi1)
                        .title("Taxis Semeson Guaymas Norte")
                        .snippet("01 622 125 2850")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );

        LatLng taxi2 = new LatLng( 27.917515, -110.912359);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi2)
                        .title("Radio Servicios")
                        .snippet("01 622 224 0466")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        LatLng taxi3 = new LatLng(27.914012, -110.905841);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi3)
                        .title("Union de Taxis Super Rapidos")
                        .snippet("01 622 222 7859")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        LatLng taxi4 = new LatLng(27.925371, -110.905111);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi4)
                        .title("Sitio Tufesa")
                        .snippet("01 622 222 3301")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        LatLng taxi5 = new LatLng(27.923240, -110.902313);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi5)
                        .title("Sitio del Seguro de la 10")
                        .snippet("01 622 222 0377")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        LatLng taxi6 = new LatLng(27.925986, -110.893003);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi6)
                        .title("Radio Taxis del Puerto A.C")
                        .snippet("01 622 222 9322")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        LatLng taxi7 = new LatLng(27.923398, -110.874410);
        mMap.addMarker(new MarkerOptions()
                        .position(taxi7)
                        .title("Sitio Centenario")
                        .snippet("01 622 222 4041")
                        .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ubicasiones))
        );
        //+++++++++++++++++++++++++++ FIN SITIO DE TAXIS ++++++++++++++++++++++++++++++


        //************************AJUSTES DEL MAPA PARA VISTA*****************//

        mMap.setMyLocationEnabled(true);//PERMITE GESTIONAR LOCALIZACION
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);//DEFINE EL TIPO DE MAPA
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15));//DA UN ZOOM DE 15%
        mMap.getUiSettings().setZoomControlsEnabled(false);//PERMITE APARECER LOS BOTONES DE ZOOM
        mMap.getUiSettings().isRotateGesturesEnabled();//DEFINE PODER ROTAR EL MAPA
        mMap.getUiSettings().isScrollGesturesEnabled();//PERMITE MOVERSE EN EL MAPA
        mMap.getUiSettings().isTiltGesturesEnabled();//PERMITE MOVER CON 2 DEDOS LA CAMARA
        mMap.getUiSettings().isZoomGesturesEnabled();//Obtiene si gestos de zoom están habilitados / deshabilitados.
        mMap.getUiSettings().isCompassEnabled();//ACTIVA BRUJULA QUE DICE DONDE ESTA EL NORTE
    }

}
