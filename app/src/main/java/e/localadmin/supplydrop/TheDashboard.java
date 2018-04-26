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

//Firebase imports
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

//GraphView imports
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.BarGraphSeries;

//Language imports
import java.util.HashMap;

public class TheDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dashboard);
        initializeGraphs();//Graph all of the data
    }

    @Override
    public void onBackPressed() {}

    /**Send the user to the map view.*/
    public void goToMap(View view) {
        startActivity(new Intent(TheDashboard.this, TheMap.class));
    }

    /*Initialize all of the graphs with data.*/
    private void initializeGraphs() {
        //initialize all graphs
        initializeOverall();
    }

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
}