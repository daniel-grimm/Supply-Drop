/**This class displays error messages when a user attempts to submit a supply request.
 * @author Daniel Grimm*/
package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class RequestFormError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request_form_error);
    }

    @Override
    public void onBackPressed() {}

    /**This method returns the user to the supply request form*/
    public void goToRequestForm(View view) {
        startActivity(new Intent(RequestFormError.this, RequestForm.class));
    }
}