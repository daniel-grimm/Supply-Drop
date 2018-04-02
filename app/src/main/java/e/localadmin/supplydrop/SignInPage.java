package e.localadmin.supplydrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

/**A login screen that offers login via username/password.*/
public class SignInPage extends AppCompatActivity {

    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in_page);
    }

    //This method signs in the user
    public void signIn(View view) {
        if (validUser() && validPassword()) {
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
            startActivity(new Intent(SignInPage.this, LoginError.class));
        }
    }

    public void register(View view) {
        registerUser();
        if (!isClicked) {
            //go to the request form activity
            goToRequestFormActivity(view);
        } else {
            //go to the dashboard activity
            goToTheDashboard(view);
        }
    }

    /**If the user is an individual, go to the request form.*/
    public void goToRequestFormActivity(View view) {
        if (!firstTimeSignIn()) {
            //This is not a first time sign in so go the the request supplies form.
            startActivity(new Intent(SignInPage.this, RequestForm.class));
        } else {
            //First time sign in so go to the greeting page first.
            startActivity(new Intent(SignInPage.this, IndividualGreeting.class));
        }
    }

    /**If the user is part of an organization then go to the dashboard.*/
    public void goToTheDashboard(View view) {
        if (!firstTimeSignIn()) {
            //Not the first time signing in so go to the dashboard straight away.
            startActivity(new Intent(SignInPage.this, TheDashboard.class));
        } else {
            //First time sign in so go the greeting page first.
            startActivity(new Intent(SignInPage.this, OrganizationGreeting.class));
        }
    }

    private boolean firstTimeSignIn() {
        //TODO: Implement calling AWS to determine if the user already exists.
        return true;
    }

    private boolean validUser() {
        //TODO: Implement calling to AWS to determine if the user is a valid user
        return true;
    }

    //If the checkbox is checked, set to true else set to false
    public void clicked(View view) {
        if (isClicked) {
            isClicked = false;
        } else {
            isClicked = true;
        }
    }

    private void registerUser() {
        return;
    }

    private boolean validPassword() {
        return false;
    }
}