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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RequestForm extends AppCompatActivity {

    private DatabaseReference mDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);
    }

    /**This method submits a request for supplies to the database.*/
    public void submitRequest(View view) {
        //Get the objects from the survey
        CheckBox food = (CheckBox) findViewById(R.id.food_checkbox);
        CheckBox sleepingStuff = (CheckBox) findViewById(R.id.sleeping_stuff_checkbox);
        CheckBox socks = (CheckBox) findViewById(R.id.socks_checkbox);
        CheckBox underwear = (CheckBox) findViewById(R.id.underwear_checkbox);
        CheckBox coat = (CheckBox) findViewById(R.id.coat_checkbox);
        CheckBox toothbrush = (CheckBox) findViewById(R.id.toothbrush_checkbox);
        CheckBox toothpaste = (CheckBox) findViewById(R.id.toothpaste_checkbox);
        CheckBox soap = (CheckBox) findViewById(R.id.soap_checkbox);
        EditText location = (EditText) findViewById(R.id.location_header);

        //Get the values entered into the survey
        boolean foods = food.isChecked();
        boolean sleepingStuffs = sleepingStuff.isChecked();
        boolean sockz = socks.isChecked();
        boolean underwears = underwear.isChecked();
        boolean coats = coat.isChecked();
        boolean toothbrushes = toothbrush.isChecked();
        boolean toothpastes = toothpaste.isChecked();
        boolean soaps = soap.isChecked();
        String locations = location.getText().toString();

        Intent newRequest = new Intent(RequestForm.this, RequestForm.class);

        mDatabase = FirebaseDatabase.getInstance().getReference();

        if (validateAmountsRequested()) {
            //Submit new request
            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();


            startActivity(newRequest);
        } else {
            //Show an error message
            startActivity(new Intent(RequestForm.this, RequestFormError.class));
        }
    }

    /**Make sure that the user isn't getting too many supplies. Return true if the user hasn't
     * requested too many supplies, else return false.*/
    private boolean validateAmountsRequested() {
        /*if (/*too much foodSupplyRequestLimits.NUM_FOOD < 0) {
            return false;
        } else if (/*too many coatsSupplyRequestLimits.NUM_COATS < 0) {
            return false;
        } else if (/*too many sleepingSupplyRequestLimits.NUM_SLEEPING_MATERIALS < 0) {
            return false;
        } else if (/*too many socksSupplyRequestLimits.NUM_SOCKS < 0) {
            return false;
        } else if (/*too many underwearSupplyRequestLimits.NUM_UNDERWEAR < 0) {
            return false;
        } else if (/*too many toothbrushSupplyRequestLimits.NUM_TOOTHBRUSH < 0) {
            return false;
        } else if (/*too many toothpasteSupplyRequestLimits.NUM_TOOTHPASTE < 0) {
            return false;
        } else if (/*too many soapSupplyRequestLimits.NUM_SOAP < 0) {
            return false;
        }*/
        return true;
    }

}