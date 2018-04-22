/**This class defines what an organization is able to see on the dashboard.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

//Graph imports
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.LineGraphSeries;

//For the graph

public class TheDashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_dashboard);
        initializeGraphs();
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
        GraphView requests = findViewById(R.id.num_requests);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        requests.addSeries(dataPoints);
    }

    private void initializeFood() {
        GraphView food = findViewById(R.id.num_food);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        food.addSeries(dataPoints);
    }

    private void initializeSocks() {
        GraphView socks = findViewById(R.id.num_socks);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        socks.addSeries(dataPoints);
    }

    private void initializeUnderwear() {
        GraphView underwear = findViewById(R.id.num_underwear);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        underwear.addSeries(dataPoints);
    }

    private void initializeSleepingStuff() {
        GraphView sleepStuff = findViewById(R.id.num_sleeping_equipment);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        sleepStuff.addSeries(dataPoints);
    }

    private void initializeCoat() {
        GraphView coat = findViewById(R.id.num_coat);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        coat.addSeries(dataPoints);
    }

    private void initializeToothbrush() {
        GraphView toothbrush = findViewById(R.id.num_toothbrush);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        toothbrush.addSeries(dataPoints);
    }

    private void initializeToothpaste() {
        GraphView toothpaste = findViewById(R.id.num_toothpaste);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        toothpaste.addSeries(dataPoints);
    }

    private void initializeSoap() {
        GraphView soap = findViewById(R.id.num_soap);
        LineGraphSeries<DataPoint> dataPoints = new LineGraphSeries<>(new DataPoint[] {
                new DataPoint(0, 1),
                new DataPoint(1, 5),
                new DataPoint(2, 3)
        });
        soap.addSeries(dataPoints);
    }
}