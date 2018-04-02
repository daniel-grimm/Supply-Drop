package e.localadmin.supplydrop;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class LoginError extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_error);
    }

    public void goToSignInPage(View view) {
        startActivity(new Intent(LoginError.this, SignInPage.class));
    }
}
