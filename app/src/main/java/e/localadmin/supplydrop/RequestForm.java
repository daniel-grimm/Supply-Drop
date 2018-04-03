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
        if (/*too much food*/SupplyRequestLimits.NUM_FOOD < 0) {
            return false;
        } else if (/*too many coats*/SupplyRequestLimits.NUM_COATS < 0) {
            return false;
        } else if (/*too many sleeping*/SupplyRequestLimits.NUM_SLEEPING_MATERIALS < 0) {
            return false;
        } else if (/*too many socks*/SupplyRequestLimits.NUM_SOCKS < 0) {
            return false;
        } else if (/*too many underwear*/SupplyRequestLimits.NUM_UNDERWEAR < 0) {
            return false;
        } else if (/*too many toothbrush*/SupplyRequestLimits.NUM_TOOTHBRUSH < 0) {
            return false;
        } else if (/*too many toothpaste*/SupplyRequestLimits.NUM_TOOTHPASTE < 0) {
            return false;
        } else if (/*too many soap*/SupplyRequestLimits.NUM_SOAP < 0) {
            return false;
        }
        return true;
    }

    /**This method writes the request to the database*/
    public void write() {
        //
    }
}
