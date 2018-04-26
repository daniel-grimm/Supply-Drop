/*This activity lists the supplies previously requested by the user.
* @author*/

//Default package
package e.localadmin.supplydrop;

//Android imports
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

//Fire base imports
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class OutstandingRequests extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outstanding_requests);

        fillFields();
    }

    public void goToRequestForm(View view) {
        startActivity(new Intent(OutstandingRequests.this, RequestForm.class));
    }

    private void fillFields() {
        DatabaseReference dr = Database.DATABASE.getReference().child("request");
        Query query = dr.orderByKey();
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                //
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.w("", databaseError.toException());
            }
        });
    }

}
