/**This class allows an individual to create a request for supplies.
 * @author Daniel Grimm*/

package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class RequestForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);
    }

    /***/
    public void submitRequest(View view) {
        Intent newRequest = new Intent(RequestForm.this, RequestForm.class);

        if (validateAmountsRequested()) {
            //Submit new request
            write();
        } else {
            //Show an error message
            startActivity(new Intent(RequestForm.this, RequestFormError.class));
        }

        startActivity(newRequest);
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

    /**This method writes the request to the database*/
    public void write() {
        //
    }
}
