/**This class supplies the locations of the query packages.*/

package e.localadmin.supplydrop;

public final class Queries {

    //This query returns all of the users of the system and their credentials.
    public static final String QUERY_USERS =
        "https://github.com/daniel-grimm/Supply-Drop/blob/master/PHP%20Files/findAllAccounts.php";
    //This query returns all unfulfilled requests.
    public static final String QUERY_UNFULFILLED =
        "https://github.com/daniel-grimm/Supply-Drop/blob/master/PHP%20Files/findUnfulfilledRequests.php";
    //This query returns the locations of all unfulfilled requests.
    public static final String QUERY_UNFULFILLED_LOCATIONS =
        "https://github.com/daniel-grimm/Supply-Drop/blob/master/PHP%20Files/findUnfulfilledRequestLocations.php";
    //This query returns the results for a specific user.
    public static final String QUERY_USER_REQUEST =
        "https://github.com/daniel-grimm/Supply-Drop/blob/master/PHP%20Files/getUsersRequests.php";

}
