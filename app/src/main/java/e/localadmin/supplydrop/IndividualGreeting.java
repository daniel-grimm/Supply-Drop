package e.localadmin.supplydrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.content.Intent;

public class IndividualGreeting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);
    }

    /**This method is called when the get started button is clicked.
     * This activity exits and then loads up the request form.*/
    public void goToRequestForm(View view) {
        Intent requestFormPage = new Intent(this, RequestForm.class);
        startActivity(requestFormPage);
    }
}
