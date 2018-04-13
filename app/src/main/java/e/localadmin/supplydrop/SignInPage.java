/**This activity allows a user to sign into the app
 * or register a new account.
 * @author Daniel Grimm*/

//package to be a part of the app
package e.localadmin.supplydrop;

//imports
import android.app.Activity;
import android.content.Intent;                      //Allows for this activity to load another
import android.os.Bundle;                           //Inherits Android
import android.support.annotation.NonNull;
import android.view.View;                           //Allows for buttons to work
import android.widget.Toast;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;

import static android.content.ContentValues.TAG;

/**A login screen that offers login via username/password.*/
public class SignInPage extends Activity {

    //If this is true then the user logging in is trying to log in as an organization
    private boolean isClicked = false;
    private FirebaseAuth mAuth;
    private FirebaseDatabase data;

    @Override
    /**Creates this app on creation*/
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sign_in_page);
        mAuth.getInstance();
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    /**This updates the UI so with the user information.*/
    private void updateUI(FirebaseUser user) {
        //
    }

    /**
     * This method changes the value of this.isClicked. If isClicked is set to false it will be set
     * to true. If it is set to true it will be changed to false.
     */
    public void clicked(View view) {
        if (isClicked) {
            isClicked = false;//flip the boolean value
        } else {
            isClicked = true;//flip the boolean value
        }
    }

    /**This method registers a user.*/
    public void register(View view, String email, String password) {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignInPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });
    }

    /**This method signs in a user.*/
    public void signIn(View view, String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(SignInPage.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                        // ...
                    }
                });

    }
}