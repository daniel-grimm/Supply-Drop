/**This class defines a new request.
 * @author Daniel Grimm*/

package e.localadmin.supplydrop;

import android.widget.CheckBox;
import android.widget.EditText;

//Firebase
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

//language imports
import java.util.ArrayList;
import java.util.Date;

public class Request {

    //Elements of the request.
    private boolean food = false;
    private boolean sleepingStuff = false;
    private boolean socks = false;
    private boolean underwear = false;
    private boolean coat = false;
    private boolean toothbrush = false;
    private boolean toothpaste = false;
    private boolean soap = false;
    private String location = null;

    private String date;
    private String user;

    //Creates a new request object that is initialized with the objects
    public Request(CheckBox foods, CheckBox sleepingStuffs, CheckBox sock, CheckBox underwears,
                   CheckBox coats, CheckBox toothbrushs, CheckBox toothpastes, CheckBox soaps,
                   EditText locations) {

        food = foods.isChecked();
        sleepingStuff = sleepingStuffs.isChecked();
        socks = sock.isChecked();
        underwear = underwears.isChecked();
        coat =coats.isChecked();
        toothbrush = toothbrushs.isChecked();
        toothpaste = toothpastes.isChecked();
        soap = soaps.isChecked();
        location = locations.getText().toString();
        user = FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        date = new Date().toString();
    }

    //Get the flags of all of the values.
    public boolean getFood() {
        return food;
    }

    public boolean getSleepingStuff() {
        return sleepingStuff;
    }

    public boolean getSocks() {
        return socks;
    }

    public boolean getUnderwear() {
        return underwear;
    }

    public boolean getCoat() {
        return coat;
    }

    public boolean getToothbrush() {
        return toothbrush;
    }

    public boolean getToothpaste() {
        return toothpaste;
    }

    public boolean getSoap() {
        return soap;
    }

    public String getLocation() {
        return location;
    }

    //Set the flags for all of the changeable fields
    //Date and User are not changeable fields
    public void setFood(boolean foods) {
        food = foods;
    }

    public void setSleepingStuff(boolean sleepingStuffs) {
        sleepingStuff = sleepingStuffs;
    }

    public void setSocks(boolean sock) {
        socks = sock;
    }

    public void setUnderwear(boolean underwears) {
        underwear = underwears;
    }

    public void setCoat(boolean coats) {
        coat = coats;
    }

    public void setToothbrush(boolean toothbrushs) {
        toothbrush = toothbrushs;
    }

    public void setToothpaste(boolean toothpastes) {
        toothpaste = toothpastes;
    }

    public void setSoap(boolean soaps) {
        soap = soaps;
    }

}
