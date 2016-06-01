package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.models.Doctor;

public class BookingsActivity extends AppCompatActivity {
    private static ArrayList<Doctor> doctor = new ArrayList<>();
    private static String   DOCTOR_SEARCH_URL = "http://openlibrary.org/search.json?title=";
    public static ArrayList<Doctor> getDoctor() {
        return doctor;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bookings);
        searchDoctors(DOCTOR_SEARCH_URL +"llosa");
    }

    public void searchDoctors(String searchTitleUrl) {
        System.out.println("URL = " + searchTitleUrl);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET, searchTitleUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // the response is already constructed as a JSONObject!
                try {
                    doctor.clear();
                    int resultsCount = response.getInt("numFound");
                    JSONArray resultsArray = response.getJSONArray("docs");

                    System.out.println("Results: " + resultsCount);

                    int limit = resultsCount > 10 ? 10 : resultsCount;

                    for (int position = 0; position<limit ; position++){
                        JSONObject result = resultsArray.getJSONObject(position);
                        String title = result.getString("title");
                        System.out.println("Title = " + title);
                        String key = result.getString("key");
                        Long coverId = result.optLong("cover_i");
                        System.out.println("cover_i = " + coverId);
                        Boolean hasFullText = result.getBoolean("has_fulltext");
                        int firstPublishYear = result.optInt("first_publish_year");
                        int editionCount = result.getInt("edition_count");

                        JSONArray authorNames = result.optJSONArray("author_name");
                        JSONArray authorKeys = result.optJSONArray("author_key");
                        int authorsCount = authorNames == null ? 0 : authorNames.length();
                        ArrayList<Doctor> doctors = new ArrayList<>();
                        for (int authorPosition = 0; authorPosition < authorsCount; authorPosition++) {
                            Doctor doctor= new Doctor(1,authorKeys.getString(authorPosition),20,1);
                            doctors.add(doctor);
                            System.out.println("Author name = " );
                        }



                        System.out.println("Book title");
                    }
                    System.out.println("searchTitles: Array Size "+ Integer.toString(doctor.size()));
                    if(doctor.size() > 0) {
                        Intent intent = new Intent(BookingsActivity.this, LoginActivity.class);
                        startActivity(intent);
                    }


                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        }
        );
        Volley.newRequestQueue(this).add(jsonRequest);

    }


}
