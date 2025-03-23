package online.mrgutter.week10.util;

import android.content.Context;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import online.mrgutter.week10.model.Movie;

public class JSONUtility {

    private static  final String TAG="JsonUtil";

    public static MovieData loadMovieData(Context context,int resourceId) throws IOException, JSONException{
        MovieData movieData=new MovieData();

        List<Movie> movielist=new ArrayList<>();
        try{
        String jsonContent=readJsonFile(context,resourceId);


        //no neeed to crete json object it is just an array
        JSONArray jsonArray = new JSONArray(jsonContent);



        for (int j = 0; j < jsonArray.length(); j++) {
            //creaTE json object here
            JSONObject obj = jsonArray.getJSONObject(j);

            // Skip empty objects
            if (obj.length() == 0) {
                //System.out.println("skip");
                continue;

            }

            else {
                String title = obj.optString("title", "Unknown");

                // Get titleif missing or null set it to Unknoww
                if(title==null||title==""||title=="null") {
                    title = "Unknown";
                }

                // Get yeardeal invalid values
                int year = 0;
                if (obj.has("year")) {
                    try {
                        String yearstring=obj.get("year").toString();

                        //check for decimal
                        if (yearstring.contains(".")){
                            String[] arr =yearstring.split("\\.");
                            System.out.println(arr[0]);
                            yearstring=arr[0];
                        }

                        year = Integer.parseInt(yearstring); // Convert to integer if it is given as string
                        if (year < 1800) { // Ignore invalid years
                            year = 0;
                        }
                    } catch (Exception e) {
                        year = 0; // Handle non-integer years
                        Log.w(TAG, "Errorwith yera");
                        System.out.println(e.getMessage());
                    }
                }


                String genre = obj.optString("genre", "Unknown");


                String poster = obj.optString("poster", "placeholder_image");


                // Add to movie list if title is valid

                movielist.add(new Movie(title, year, genre, poster));

            }
        }
            } catch (IOException e) {

            Log.w(TAG, "Error reading JSON file");
            System.out.println( e.getMessage());
        } catch (JSONException e) {

                Log.w(TAG, "Error parsing JSON");
                System.out.println( e.getMessage());
            }catch (Exception e) {

            Log.w(TAG, "somthing else");
            System.out.println( e.getMessage());
        }






        movieData.setMovies(movielist);

        return movieData;
    }






    //from techers code
    private static String readJsonFile(Context context, int resourceId) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        try (InputStream inputStream = context.getResources().openRawResource(resourceId);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {

            String line;
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file", e);
            throw e;
        }
        return stringBuilder.toString();
    }
}
