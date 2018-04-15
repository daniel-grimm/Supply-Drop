package e.localadmin.supplydrop;

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
