/*This activity lists the supplies previously requested by the user.
* @author*/

//Default package
package e.localadmin.supplydrop;

//Android imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//Fire base imports
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;

public class OutstandingRequests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outstanding_requests);

        fillFields();
    }

    public void goToRequestForm(View view) {
        startActivity(new Intent(OutstandingRequests.this, RequestForm.class));
    }

    private void fillFields() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        Query query = dr.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> ds = dataSnapshot.getChildren();

                for (DataSnapshot dataSnap : ds) {
                    HashMap<String, Object> wrapper = (HashMap<String, Object>) dataSnap.getValue();
                    HashMap<String, Object> map = (HashMap<String, Object>) wrapper.get("map");
                    String user = FirebaseAuth.getInstance().getCurrentUser().getEmail();
                    String storedUser = (String) map.get("user");
                    if (!storedUser.equals(user)) {
                        continue;//not the same user
                    } else {
                        //TODO:
                    }
                }

                TextView food = findViewById(R.id.food_stuff);
                TextView sleepingStuff = findViewById(R.id.sleeping_stuff);
                TextView socks = findViewById(R.id.socks_stuff);
                TextView underwear = findViewById(R.id.underwear_stuff);
                TextView coat = findViewById(R.id.coat_stuff);
                TextView toothbrush = findViewById(R.id.toothbrush_stuff);
                TextView toothpaste = findViewById(R.id.toothpaste_stuff);
                TextView soap = findViewById(R.id.soap_stuff);

                food.setText("");
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

}
