/**This class provides an interface for submitting requests to the database.
 * @author Daniel Grimm*/

//default package
package e.localadmin.supplydrop;

//imports
import android.util.Log;
import java.net.URI;
import java.net.URL;
import java.net.URISyntaxException;
import java.net.MalformedURLException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.impl.client.DefaultHttpClient;

public class QueryDatabase {

    URL url;

    {
        try {
            url = new URL("supply-drop.cdkcwqlnuxlm.us-west-2.rds.amazonaws.com:3306");
        } catch (MalformedURLException e) {
            Log.e("log_tag", "Error creating URL " + e.toString());
        }
    }
    HttpClient client = new DefaultHttpClient();
    HttpGet request = new HttpGet();
    URI uri;
    {
        try {
            uri = new URI("supply-drop.cdkcwqlnuxlm.us-west-2.rds.amazonaws.com:3306");
        } catch (URISyntaxException e) {
            Log.e("log_tag", "Error creating URI " + e.toString());
        }
    }
    //request.setURI(uri);


}