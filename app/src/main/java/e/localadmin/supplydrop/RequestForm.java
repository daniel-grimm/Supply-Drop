/**This class allows an individual to create a request for supplies.
 * @author Daniel Grimm*/

package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;

//Firebase imports
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.ValueEventListener;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class RequestForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);
    }

    /**This method submits a request for supplies to the database.*/
    public void submitRequest(View view) {
        //Get the objects from the survey
        CheckBox food = findViewById(R.id.food_checkbox);
        CheckBox sleepingStuff = findViewById(R.id.sleeping_stuff_checkbox);
        CheckBox socks = findViewById(R.id.socks_checkbox);
        CheckBox underwear = findViewById(R.id.underwear_checkbox);
        CheckBox coat = findViewById(R.id.coat_checkbox);
        CheckBox toothbrush = findViewById(R.id.toothbrush_checkbox);
        CheckBox toothpaste = findViewById(R.id.toothpaste_checkbox);
        CheckBox soap = findViewById(R.id.soap_checkbox);
        EditText location = findViewById(R.id.location_header);

        Request request = new Request(food, sleepingStuff, socks, underwear, coat, toothbrush,
                toothpaste, soap, location);

        if (validateAmountsRequested()) {
            //Add new request to the database
            DatabaseReference mDatabase = Database.DATABASE.getReference();
            String key = mDatabase.child("request").push().getKey();
            mDatabase.child("request").child(key).setValue(request);



            //Load the request page again
            Intent newRequest = new Intent(RequestForm.this, RequestSubmitted.class);
            startActivity(newRequest);
        } else {
            //Show an error message
            startActivity(new Intent(RequestForm.this, RequestFormError.class));
        }
    }

    /**Make sure that the user isn't getting too many supplies. Return true if the user hasn't
     * requested too many supplies, else return false.*/
    private boolean validateAmountsRequested() {
        //TODO:Implement me
        /*DatabaseReference dr = Database.DATABASE.getReference("request");
        dr.orderByChild("food").equalTo(FirebaseAuth.getInstance().getCurrentUser().getEmail()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });*/

        if (SupplyRequestLimits.NUM_FOOD <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_COATS <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_SLEEPING_MATERIALS <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_SOCKS <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_UNDERWEAR <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_TOOTHBRUSH <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_TOOTHPASTE <= 0) {
            return false;
        } else if (SupplyRequestLimits.NUM_SOAP <= 0) {
            return false;
        }
        return true;
    }

}