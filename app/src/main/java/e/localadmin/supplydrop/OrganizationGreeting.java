//default package for SupplyDrop
package e.localadmin.supplydrop;

//imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class OrganizationGreeting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organization_greeting);
    }

    /**This method changes activities to the dashboard page.*/
    public void goToTheDashboard(View view) {
        startActivity(new Intent(OrganizationGreeting.this, TheDashboard.class));
    }
}