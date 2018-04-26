/**This activity allows a user to sign into the app
 * or register a new account.
 * @author Daniel Grimm*/

//package to be a part of the app
package e.localadmin.supplydrop;

//imports
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;                           //Inherits Android
import android.view.View;                           //Allows for buttons to work
import android.widget.CheckBox;


//Firebase imports
import com.firebase.ui.auth.AuthUI;

//Language imports
import java.util.Arrays;
import java.util.List;

/**A login screen that offers login via username/password.*/
public class SignInPage extends Activity {

    //If this is true then the user logging in is trying to log in as an organization
    private boolean isClicked = false;
    private static final int RC_SIGN_IN = 123;


    @Override
    /**Creates this app on creation*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);

        // Choose authentication providers
        List<AuthUI.IdpConfig> providers = Arrays.asList(
                new AuthUI.IdpConfig.Builder(AuthUI.EMAIL_PROVIDER).build(),
                new AuthUI.IdpConfig.Builder(AuthUI.GOOGLE_PROVIDER).build());

        // Create and launch sign-in intent
        startActivityForResult(
                AuthUI.getInstance()
                        .createSignInIntentBuilder()
                        .setAvailableProviders(providers)
                        .build(),
                RC_SIGN_IN);
    }

    /*This sends the user to a greeting message.*/
    public void greeting(View view) {
        boolean clicked = ((CheckBox) findViewById(R.id.organization)).isChecked();
        boolean firstTime = false;

        if (clicked) {
            //TODO: If the first time visiting the front page display a greeting
            if (firstTime) {
                startActivity(new Intent(SignInPage.this, OrganizationGreeting.class));
            } else {
                startActivity(new Intent(SignInPage.this, TheDashboard.class));
            }
        } else {
            //TODO: If the first time visiting te front page display a greeting
            if (firstTime) {
                startActivity(new Intent(SignInPage.this, IndividualGreeting.class));
            } else {
                startActivity(new Intent(SignInPage.this, RequestForm.class));
            }

        }
    }
}