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
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//language imports
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    /**This method adds a marker to the map*/
    public void addMarker(String address, int requestID) {
        //TODO: If there is a google map api call to translate string address into lat/long
        //coordinates.

        //TODO: Get the username of the person requesting
        //LatLng latitudeLongitude = new LatLng(00, 00);
        //mMap.addMarker(new MarkerOptions().position(LatitudeLongitude).title(
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
        ArrayList<String> list = getLocations();

        // Add a marker in Sydney and move the camera
        LatLng seattle = new LatLng(47, -122);
        mMap.addMarker(new MarkerOptions().position(seattle).title("Marker near Seattle"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(seattle));
    }

    //gets all unfulfilled request locations
    private ArrayList<String> getLocations() {
        ArrayList<String> list = new ArrayList<>();

        DatabaseReference requests = Database.DATABASE.getReference().child("request");
        requests.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();

                /*for (DataSnapshot dataSnap : ds) {
                    Map<String, Object> map = dataSnap.getValue(Map.class);
                    String address = (String) map.get("location");
                    Geocoder gc = new Geocoder(getApplicationContext());
                    List<Address> list = null;
                    try {
                        list = gc.getFromLocationName(address, 1);
                    } catch (IOException e) {
                        e.printStackTrace();//print error message
                    }

                    //get the coordinates of the address
                    double latitude = list.get(0).getLatitude();
                    double longitude = list.get(0).getLongitude();
                    LatLng latLng = new LatLng(latitude, longitude);
                    mMap.addMarker(new MarkerOptions().position(latLng).title((String)
                            map.get("user")));
                }*/
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });

        return list;
    }
}