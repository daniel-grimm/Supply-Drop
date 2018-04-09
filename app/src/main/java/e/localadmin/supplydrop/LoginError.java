/**This file displays an error message about logging on to the user.
* @author Daniel Grimm*/

package e.localadmin.supplydrop;

//imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_error);

        //TODO: get the personalized error message and display it to the user.
    }

    //Go back to the sign in page to allow the person to try again.
    public void goToSignInPage(View view) {
        startActivity(new Intent(LoginError.this, SignInPage.class));
    }
}
