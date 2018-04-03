/**This activity allows a user to sign into the app
 * or register a new account.
 * @author Daniel Grimm*/

//package to be a part of the app
package e.localadmin.supplydrop;

//imports
import android.content.Intent;                      //Allows for this activity to load another
import android.support.v7.app.AppCompatActivity;    //Allows inheritance from Android
import android.os.Bundle;                           //Inherits Android
import android.view.View;                           //Allows for buttons to work

/**A login screen that offers login via username/password.*/
public class SignInPage extends AppCompatActivity {

    //If this is true then the user logging in is trying to log in as an organization
    private boolean isClicked = false;

    @Override
    /**Creates this app on creation*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
    }

    /**This method signs the user into the system. On error, an error page is displayed.*/
    public void signIn(View view) {
        //Decision tree determines if the user is valid and if the user is an organization
        if (existingUser()) {
            //Continue the sign in process
            if (!isClicked) {
                //go to the request form
                goToRequestFormActivity(view);
            } else {
                //go to the dashboard
                goToTheDashboard(view);
            }
        } else {
            //error, go to the login error activity
            Intent error = new Intent(SignInPage.this, LoginError.class);
            error.putExtra("ERROR_MESSAGE", "Invalid Credentials. Please try again.");
            startActivity(error);//switch activities
        }
    }

    /**This method registers a new user into the system. On error, an error page is displayed.*/
    public void register(View view) {

        registerUser();//Create a new user in the database

        //TODO:This decision tree should be a part of registerUser(), It is fine here for now.
        if (!validPassword()) {
            Intent error = new Intent(SignInPage.this, LoginError.class);
            error.putExtra("ERROR_MESSAGE", "Password is too short. Please try again.");
            startActivity(error);
        }

        //Decision tree determines if the user is an organization or not.
        if (!isClicked) {
            //go to the request form activity
            goToRequestFormActivity(view);
        } else {
            //go to the dashboard activity
            goToTheDashboard(view);
        }
    }

    /**This method loads a greeting message if this is the first time the user
     * is signing in. If this is not the first time signing in then the user is taken
     * to the supply request form.*/
    public void goToRequestFormActivity(View view) {
        if (!firstTimeSignIn()) {
            //This is not a first time sign in so go the the request supplies form.
            startActivity(new Intent(SignInPage.this, RequestForm.class));
        } else {
            //First time sign in so go to the greeting page first.
            startActivity(new Intent(SignInPage.this, IndividualGreeting.class));
        }
    }

    /**This method sends the user to a greeting page if this is the first time the organization
     * is signing in. If it is not the first time the organization is signing in then the
     * dashboard is loaded.*/
    public void goToTheDashboard(View view) {
        if (!firstTimeSignIn()) {
            //Not the first time signing in so go to the dashboard straight away.
            startActivity(new Intent(SignInPage.this, TheDashboard.class));
        } else {
            //First time sign in so go the greeting page first.
            startActivity(new Intent(SignInPage.this, OrganizationGreeting.class));
        }
    }

    /**This method returns true if this is the first time the user is signing into the system.*/
    private boolean firstTimeSignIn() {
        //TODO: Implement calling AWS to determine if the user already exists.
        return true;
    }

    /**This method returns true if the user is already in the system.*/
    private boolean existingUser() {
        //TODO: Implement calling to AWS to determine if the user is a valid user
        return true;
    }

    /**This method returns true if the password is valid password*/
    private boolean validPassword() {
        return false;
    }

    /**This method changes the value of this.isClicked. If isClicked is set to false it will be set
     * to true. If it is set to true it will be changed to false.*/
    public void clicked(View view) {
        if (isClicked) {
            isClicked = false;//flip the boolean value
        } else {
            isClicked = true;//flip the boolean value
        }
    }

    /**This method creates a new entry in the database for the user.*/
    private void registerUser() {
        return;
    }
}