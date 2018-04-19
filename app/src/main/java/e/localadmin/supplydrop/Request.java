/**This class defines a new request.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

import android.widget.CheckBox;
import android.widget.EditText;

//Firebase
import com.google.firebase.auth.FirebaseAuth;

//language imports
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Request {

    private Map<String, Object> map;//A map of the values of each request

    //Creates a new request object that is initialized with the objects
    public Request(CheckBox food, CheckBox sleepingStuff, CheckBox socks, CheckBox underwear,
                   CheckBox coat, CheckBox toothbrush, CheckBox toothpaste, CheckBox soap,
                   EditText location) {

        //initialize the map structure
        map = new HashMap<>();

        //put all of the values into the map
        map.put("food", food.isChecked());
        map.put("sleepingStuff", sleepingStuff.isChecked());
        map.put("socks", socks.isChecked());
        map.put("underwear", underwear.isChecked());
        map.put("coat", coat.isChecked());
        map.put("toothbrush", toothbrush.isChecked());
        map.put("toothpaste", toothpaste.isChecked());
        map.put("soap", soap.isChecked());
        map.put("location", location.getText().toString());
        map.put("user", FirebaseAuth.getInstance().getCurrentUser().getEmail());
        map.put("timestamp", new Date().toString());
    }

    public Map<String, Object> getMap() {
        return map;
    }

    //Set the flags for all of the changeable fields
    //Date and User are not changeable fields
    public void setFood(boolean food) {
        map.remove("food");
        map.put("food", food);
    }

    public void setSleepingStuff(boolean sleepingStuff) {
        map.remove("sleepingStuff");
        map.put("sleepingStuff", sleepingStuff);
    }

    public void setSocks(boolean sock) {
        map.remove("sock");
        map.put("sock", sock);
    }

    public void setUnderwear(boolean underwear) {
        map.remove("underwear");
        map.put("underwear", underwear);
    }

    public void setCoat(boolean coat) {
        map.remove("coat");
        map.put("coat", coat);
    }

    public void setToothbrush(boolean toothbrush) {
        map.remove("toothbrush");
        map.put("toothbrush", toothbrush);
    }

    public void setToothpaste(boolean toothpaste) {
        map.remove("toothpaste");
        map.put("toothpaste", toothpaste);
    }

    public void setSoap(boolean soap) {
        map.remove("soap");
        map.put("soap", soap);
    }

}