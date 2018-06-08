/**This class allows an individual to create a request for supplies.
 * @author Daniel Grimm*/

package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.content.Intent;
import android.widget.CheckBox;
import android.widget.EditText;

//Firebase imports
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class RequestForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);
    }

    /*Prevent the user from using the back button*/
    @Override
    public void onBackPressed() {}

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

        if (!empty()) {
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

    /**/
    public void goToRequestHistory(View view) {
        startActivity(new Intent(RequestForm.this, RequestHistory.class));
    }

    /*If no values entered into the form then true is returned*/
    private boolean empty() {
        CheckBox food = findViewById(R.id.food_checkbox);
        CheckBox sleepingStuff = findViewById(R.id.sleeping_stuff_checkbox);
        CheckBox socks = findViewById(R.id.socks_checkbox);
        CheckBox underwear = findViewById(R.id.underwear_checkbox);
        CheckBox coat = findViewById(R.id.coat_checkbox);
        CheckBox toothbrush = findViewById(R.id.toothbrush_checkbox);
        CheckBox toothpaste = findViewById(R.id.toothpaste_checkbox);
        CheckBox soap = findViewById(R.id.soap_checkbox);
        EditText location = findViewById(R.id.location_header);

        boolean foodz = food.isChecked();
        boolean sleepingStuffz = sleepingStuff.isChecked();
        boolean sockz = socks.isChecked();
        boolean underwearz = underwear.isChecked();
        boolean coatz = underwear.isChecked();
        boolean toothbrushz = toothbrush.isChecked();
        boolean toothpastez = toothpaste.isChecked();
        boolean soapz = soap.isChecked();
        String locationz = location.getText().toString();

        if (!foodz && ! sleepingStuffz && !sockz && !underwearz && !coatz && !toothbrushz &&
                !toothpastez && !soapz && (locationz.length() == 0)) {
            return true;
        }
        return false;
    }

}