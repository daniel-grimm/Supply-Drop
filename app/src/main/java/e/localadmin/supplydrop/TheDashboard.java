/**This class defines what an organization is able to see on the dashboard.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

//Android imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

//Firebase imports
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//GraphView imports
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.BarGraphSeries;

//Language imports
import java.util.Date;
import java.util.HashMap;
import java.util.ArrayList;

public class TheDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dashboard);

        initializeOverall();//Graph all of the data
    }

    //Don't allow the user to go back the previous page
    @Override
    public void onBackPressed() {}

    /**Send the user to the map view.*/
    public void goToMap(View view) {
        startActivity(new Intent(TheDashboard.this, TheMap.class));
    }

    //
    private void initializeOverall() {
        //TODO: Change to number of requests by day
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int[] numTypes = new int[8];
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();
                int i = 0;
                for (DataSnapshot dataSnap : ds) {
                    //number of total requests
                    i++;

                    //Get all requests
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");

                    //Get all of the values of the stuff
                    boolean food = (boolean) map.get("food");
                    boolean sleepingStuff = (boolean) map.get("sleepingStuff");
                    boolean socks = (boolean) map.get("socks");
                    boolean underwear = (boolean) map.get("underwear");
                    boolean coat = (boolean) map.get("coat");
                    boolean toothbrush = (boolean) map.get("toothbrush");
                    boolean toothpaste = (boolean) map.get("toothpaste");
                    boolean soap = (boolean) map.get("soap");

                    //Increase the count of that type of supply.
                    if (food) { numTypes[0]++; }
                    if (sleepingStuff) { numTypes[1]++; }
                    if (socks) { numTypes[2]++; }
                    if (underwear) { numTypes[3]++; }
                    if (coat) { numTypes[4]++; }
                    if (toothbrush) { numTypes[5]++; }
                    if (toothpaste) { numTypes[6]++; }
                    if (soap) { numTypes[7]++; }
                }

                GraphView requests = findViewById(R.id.num_requests);

                BarGraphSeries<DataPoint> dataPoints = new BarGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, numTypes[0]),
                        new DataPoint(1, numTypes[1]),
                        new DataPoint(2, numTypes[2]),
                        new DataPoint(3, numTypes[3]),
                        new DataPoint(4, numTypes[4]),
                        new DataPoint(5, numTypes[5]),
                        new DataPoint(6, numTypes[6]),
                        new DataPoint(7, numTypes[7])
                });
                requests.addSeries(dataPoints);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    /*Searches the database for */
    public void search(View view) {
        String search = ((EditText) findViewById(R.id.search_box)).getText().toString();
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        Query query = dr.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String search = ((EditText) findViewById(R.id.search_box)).getText().toString();
                int[] values = new int[8];
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();

                //Determine if the request was submitted by this user, and then count the number,
                //of items requested, by type.
                for (DataSnapshot dataSnap : ds) {
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");
                    String user = search;
                    String storedUser = (String) map.get("user");
                    if (!storedUser.equals(user) && ((String) map.get("closeDate") != new Date(0, 0, 0).toString())) {
                        continue;//not the same user
                    } else {
                        //Count the number of requests the person has per type
                        values[0] += toInt((boolean) map.get("food"));
                        values[1] += toInt((boolean) map.get("sleepingStuff"));
                        values[2] += toInt((boolean) map.get("socks"));
                        values[3] += toInt((boolean) map.get("underwear"));
                        values[4] += toInt((boolean) map.get("coat"));
                        values[5] += toInt((boolean) map.get("toothbrush"));
                        values[6] += toInt((boolean) map.get("toothpaste"));
                        values[7] += toInt((boolean) map.get("soap"));
                    }
                }

                //Get all of the graphical elements
                TextView food = findViewById(R.id.food_stuff);
                TextView sleepingStuff = findViewById(R.id.sleeping_stuff);
                TextView socks = findViewById(R.id.socks_stuff);
                TextView underwear = findViewById(R.id.underwear_stuff);
                TextView coat = findViewById(R.id.coat_stuff);
                TextView toothbrush = findViewById(R.id.toothbrush_stuff);
                TextView toothpaste = findViewById(R.id.toothpaste_stuff);
                TextView soap = findViewById(R.id.soap_stuff);

                //Set the text values for all of the elements
                String setToVal = "" + values[0] + " requests";
                food.setText(setToVal);
                setToVal = "" + values[1] + " requests";
                sleepingStuff.setText(setToVal);
                setToVal = "" + values[2] + " requests";
                socks.setText(setToVal);
                setToVal = "" + values[3] + " requests";
                underwear.setText(setToVal);
                setToVal = "" + values[4] + " requests";
                coat.setText(setToVal);
                setToVal = "" + values[5] + " requests";
                toothbrush.setText(setToVal);
                setToVal = "" + values[6] + " requests";
                toothpaste.setText(setToVal);
                setToVal = "" + values[7] + " requests";
                soap.setText(setToVal);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    public void delete(View view) {
        String search = ((EditText) findViewById(R.id.search_box)).getText().toString();
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        Query query = dr.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String search = ((EditText) findViewById(R.id.search_box)).getText().toString();
                int[] values = new int[8];
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();

                //Determine if the request was submitted by this user, and then count the number,
                //of items requested, by type.
                for (DataSnapshot dataSnap : ds) {
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");
                    String user = search;
                    String storedUser = (String) map.get("user");
                    if (((String) map.get("closeDate") == new Date(0, 0, 0).toString()) && storedUser.equals(user)) {
                        Date now = new Date();
                        map.remove(new Date(0, 0, 0).toString());
                        map.put("closeDate", now.toString());
                    }
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    /**/
    private int toInt(boolean value) {
        if (value) {
            return 1;
        }
        return 0;
    }

}