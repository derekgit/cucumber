package Stepdefs;

/**
 * Created by elquiff on 04/01/2017.
 */
import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonReader {

    private static String readAll(Reader rd) throws IOException {
        StringBuilder sb = new StringBuilder();
        int cp;
        while ((cp = rd.read()) != -1) {
            sb.append((char) cp);
        }
        return sb.toString();
    }

    public static JSONObject readJsonFromUrl(String imdb_url) throws IOException, JSONException {
        URL url = new URL(imdb_url);
        //System.out.println(url);
        URLConnection uc = url.openConnection();
        uc.addRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.0)");
        uc.connect();
        InputStream is = uc.getInputStream();
        try {
            BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
            String jsonText = readAll(rd);
            JSONObject json = new JSONObject(jsonText); // <-- Problem here!
            //System.out.println(json);
            //JSONArray json = new JSONArray(jsonText);
            //return (JSONObject) json.get(0); //There can be more than 1 movies
            return json;
        } finally {
            is.close();
        }
    }
}
