/**This class defines what an organization is able to see on the dashboard.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

//Language imports
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.util.Log;
import android.view.View;

//Firebase imports
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

//GraphView imports
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

//Language imports
import java.util.HashMap;
import java.util.Map;

public class TheDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dashboard);
        initializeGraphs();//Graph all of the data
    }

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

                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();
                int i = 0;
                for (DataSnapshot dataSnap : ds) {
                    i++;
                }

                GraphView requests = findViewById(R.id.num_requests);
                LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 0),
                        new DataPoint(1, i)
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