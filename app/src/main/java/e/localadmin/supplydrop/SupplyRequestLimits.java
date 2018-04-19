/**This class determines the limits of supplies that can be ordered
 * in a week time frame for an individual.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

public final class SupplyRequestLimits {

    //Food request limits
    public static final int NUM_FOOD = 3;

    //Apparel request limits
    public static final int NUM_COATS = 1;
    public static final int NUM_SLEEPING_MATERIALS = 1;
    public static final int NUM_SOCKS = 2;
    public static final int NUM_UNDERWEAR = 2;

    //Hygiene products request limits
    public static final int NUM_TOOTHBRUSH = 2;
    public static final int NUM_TOOTHPASTE = 3;
    public static final int NUM_SOAP = 2;

    public static final int[] SUPPLY_LIMITS = {NUM_FOOD, NUM_COATS, NUM_SLEEPING_MATERIALS, NUM_SOCKS,
        NUM_UNDERWEAR, NUM_TOOTHBRUSH, NUM_TOOTHPASTE, NUM_SOAP};
}