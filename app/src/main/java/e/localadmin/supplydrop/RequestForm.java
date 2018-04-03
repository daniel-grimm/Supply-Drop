package e.localadmin.supplydrop;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

public class RequestForm extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user__home__page);
    }

    public void submitRequest(View view) {
        Intent newRequest = new Intent(RequestForm.this, RequestForm.class);




        startActivity(newRequest);
    }

    private boolean validateAmountsRequested() {
        return false;
    }
}
