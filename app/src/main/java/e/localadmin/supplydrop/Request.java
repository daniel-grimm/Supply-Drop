/**This class defines a new request.
 * @author Daniel Grimm*/

package e.localadmin.supplydrop;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import java.util.ArrayList;

public class Request {

    private boolean food = false;
    private boolean sleepingStuff = false;
    private boolean socks = false;
    private boolean underwear = false;
    private boolean coat = false;
    private boolean toothbrush = false;
    private boolean toothpaste = false;
    private boolean soap = false;
    private String location = null;

    //Creates a new request object that is initialized with the flags directly.
    public Request(boolean foods, boolean sleepingstuffs, boolean sock, boolean underwears,
                   boolean coats, boolean toothbrushs, boolean toothpastes, boolean soaps,
                   String locations) {

        food = foods;
        sleepingStuff = sleepingstuffs;
        socks = sock;
        underwear = underwears;
        coat = coats;
        toothbrush = toothbrushs;
        toothpaste = toothpastes;
        soap = soaps;
        location = locations;

    }

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
    }

    public ArrayList<Object> getAll() {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(food);
        list.add(sleepingStuff);
        list.add(socks);
        list.add(underwear);
        list.add(coat);
        list.add(toothbrush);
        list.add(toothpaste);
        list.add(soap);
        list.add(location);
        return list;
    }

    //Gets the flags of all of the values.
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

}
