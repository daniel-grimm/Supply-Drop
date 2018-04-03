/**This method displays a greeting the first time a user signs into the system.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

//imports
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class IndividualGreeting extends AppCompatActivity {

    @Override
    /**Creates a new greeting page.*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
    }

    /**This method is called when the get started button is clicked.
     * This activity exits and then loads up the request form.*/
    public void goToRequestForm(View view) {
        //switch activity to the supply request form
        startActivity(new Intent(IndividualGreeting.this, RequestForm.class));
    }
}
