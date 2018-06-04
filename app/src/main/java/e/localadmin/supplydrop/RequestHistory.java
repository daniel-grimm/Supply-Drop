/*History of requests.
*
* @author Daniel Grimm*/

//Default Package
package e.localadmin.supplydrop;

//Android Imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class RequestHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_history);
    }

    private void fillFields() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        Query query = dr.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                int[] values = new int[8];
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();

                //Determine if the request was submitted by this user, and then count the number,
                //of items requested, by type.
                for (DataSnapshot dataSnap : ds) {
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");
                    String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                    String storedUser = (String) map.get("user");
                    if (!storedUser.equals(user)) {
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

    /**/
    private int toInt(boolean value) {
        if (value) {
            return 1;
        }
        return 0;
    }

    public void deleteRequest(View view) {
        //
    }

    public void goBack(View view) {
        startActivity(new Intent(RequestHistory.this, RequestForm.class));
    }
}