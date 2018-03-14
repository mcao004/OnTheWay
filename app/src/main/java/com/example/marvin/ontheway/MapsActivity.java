package com.example.marvin.ontheway;

import android.content.Intent;
import android.location.Location;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.location.places.ui.PlacePicker;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.PlaceDetectionClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, OnConnectionFailedListener {

    private GoogleMap mMap;
    private CameraPosition mCameraPosition;

    private GeoDataClient mGeoDataClient;
    private PlaceDetectionClient mPlaceDetectionClient;


    public static CharSequence name;

    private Location mLastKnownLocation;
    int PLACE_PICKER_REQUEST = 1;
    private GoogleApiClient mGoogleApiClient;

    // keys to store activity state
    private static final String KEY_CAMERA_POSITION = "camera_position";
    private static final String KEY_LOCATION = "location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        // Retrieve location and camera position from saved instance state
//        if (savedInstanceState != null) {
//            mLastKnownLocation = savedInstanceState.getParcelable(KEY_LOCATION);
//            mCameraPosition = savedInstanceState.getParcelable(KEY_CAMERA_POSITION);
//        }

        PlacePicker.IntentBuilder intentBuilder = new PlacePicker.IntentBuilder();
        try {
            final Intent intent = intentBuilder.build(this);
            startActivityForResult(intentBuilder.build(this), PLACE_PICKER_REQUEST);
        } catch (GooglePlayServicesRepairableException | GooglePlayServicesNotAvailableException e) {
            e.printStackTrace();
        }
        // getting info from mainMenu
        // Bundle mainMenuData = getIntent().getExtras();
        // if(mainMenuData == null) return;
        // else {
        // String mainMenuMessage = mainMenuData.getString("mainMenuMessage");
        // final TextView mapText = (TextView) findViewById(R.id.blah);
        // mapText.setText(mainMenuMessage);
        // }

        // Construct a GeoDataClient for access to Google's local place and business info
//        mGeoDataClient = Places.getGeoDataClient(this, null);
//
//        // Construct a PlaceDetectionClient
//        mPlaceDetectionClient = Places.getPlaceDetectionClient(this, null);
//
//        mGoogleApiClient = new GoogleApiClient
//                .Builder(this)
//                .addApi(Places.GEO_DATA_API)
//                .addApi(Places.PLACE_DETECTION_API)
//                .enableAutoManage(this, this)
//                .build();
//
//        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
//        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.map);
//        mapFragment.getMapAsync(this);
    }
    
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (mMap != null) {
            outState.putParcelable(KEY_CAMERA_POSITION, mMap.getCameraPosition());
            outState.putParcelable(KEY_LOCATION, mLastKnownLocation);
            super.onSaveInstanceState(outState);
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
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        // Doesn't handle anything yet
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PLACE_PICKER_REQUEST && resultCode == RESULT_OK) {
            //chose place
            Place place = PlacePicker.getPlace(data, this);

            //store restaurant info
            name = place.getName();
            Toast.makeText(getApplicationContext(),name, Toast.LENGTH_SHORT).show();

//            phone = place.getPhoneNumber();
//            rating = place.getRating();
//            mytext = Float.toString(rating);

            //create a restaurant page for chosen place
            Intent intent = new Intent(this, MainMenu.class);
            startActivity(intent);

            //notification saying restaurant name
            // String toastMsg = String.format("Place: %s", name);
            // Toast.makeText(this, toastMsg, Toast.LENGTH_LONG).show();
        }
    }
}
