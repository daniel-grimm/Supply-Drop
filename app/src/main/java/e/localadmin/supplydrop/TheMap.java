/**This class creates a map with data points of unfulfilled requests.
 * @author Daniel Grimm*/
package e.localadmin.supplydrop;

//imports
import android.location.Address;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.location.Geocoder;

//google map imports
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

//language imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TheMap extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    /**navigate back to the dashboard*/
    public void goToTheDashboard(View view) {
        startActivity(new Intent(TheMap.this, TheDashboard.class));
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
    /**Currently this just loads the map with a marker near Seattle.*/
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        getLocations();//Add all of the locations to the map

        //Set up the UI
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);

        //Initialize the cammera position
        LatLng seattle = new LatLng(47.606600, -122.332984);
        mMap.addMarker(new MarkerOptions().position(seattle).title("SPL"));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(seattle, 10), 5000, null);
    }

    //gets all unfulfilled request locations
    private void getLocations() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                /*Iterable<DataSnapshot> ds = dataSnapshot.getChildren();
                for (DataSnapshot dataSnap : ds) {
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");

                    String location = (String) map.get("location");
                    if (location.length() >= 5) {
                        Geocoder gc = new Geocoder(getApplicationContext());
                        List<Address> list;
                        try {
                            list = gc.getFromLocationName(location, 1);

                            //list not initialized
                            if (list == null) {
                                continue;
                            }

                            //no results
                            if (list.size() == 0) {
                                continue;
                            }

                            //Get the coordinates of the address
                            double lat = list.get(0).getLatitude();
                            double lon = list.get(0).getLongitude();
                            LatLng latlng = new LatLng(lat, lon);
                            mMap.addMarker(new MarkerOptions().position(latlng).title((String) map.get("username")));

                        } catch(IOException ioe) {
                            continue;//keep looping
                        }
                    }
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    /*Zoom into the map.*/
    public void zoomIn(View view) {
        mMap.animateCamera(CameraUpdateFactory.zoomIn());
    }

    /*Zoom out of the map.*/
    public void zoomOut(View view) {
        mMap.animateCamera(CameraUpdateFactory.zoomOut());
    }
}