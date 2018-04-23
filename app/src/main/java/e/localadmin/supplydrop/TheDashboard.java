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
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

//GraphView imports
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

//Language imports
import java.util.HashMap;

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
        initializeFood();
        initializeSocks();
        initializeUnderwear();
        initializeSleepingStuff();
        initializeCoat();
        initializeToothbrush();
        initializeToothpaste();
        initializeSoap();
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
                        new DataPoint(0, i)
                });
                requests.addSeries(dataPoints);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    private void initializeFood() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();
                for (DataSnapshot dataSnap : ds) {
                    Object returnVal = dataSnap.getValue();
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) returnVal;
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");
                    boolean getValue = (boolean) map.get("food");
                }

                //TODO: Change to requests by time
                GraphView food = findViewById(R.id.num_food);
                LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                        new DataPoint(0, 1),
                        new DataPoint(1, 5),
                        new DataPoint(2, 3)
                });
                food.addSeries(dataPoints);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

    private void initializeSocks() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView socks = findViewById(R.id.num_socks);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        socks.addSeries(dataPoints);
    }

    private void initializeUnderwear() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView underwear = findViewById(R.id.num_underwear);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        underwear.addSeries(dataPoints);
    }

    private void initializeSleepingStuff() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView sleepStuff = findViewById(R.id.num_sleeping_equipment);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        sleepStuff.addSeries(dataPoints);
    }

    private void initializeCoat() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView coat = findViewById(R.id.num_coat);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        coat.addSeries(dataPoints);
    }

    private void initializeToothbrush() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView toothbrush = findViewById(R.id.num_toothbrush);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        toothbrush.addSeries(dataPoints);
    }

    private void initializeToothpaste() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView toothpaste = findViewById(R.id.num_toothpaste);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        toothpaste.addSeries(dataPoints);
    }

    private void initializeSoap() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        dr.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //TODO: Implement me
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
        GraphView soap = findViewById(R.id.num_soap);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        soap.addSeries(dataPoints);
    }
}