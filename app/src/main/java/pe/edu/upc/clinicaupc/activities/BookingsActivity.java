package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterDoctor;
import pe.edu.upc.clinicaupc.models.Doctor;

public class BookingsActivity extends AppCompatActivity {

    private ArrayList<Doctor> doctorList = new ArrayList<>();
    private static String   DOCTOR_SEARCH_URL = "http://tjvsac.com/api/api.php?name=borda";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

         searchDoctors(DOCTOR_SEARCH_URL);
        List<Doctor> listaju = Arrays.asList(
                new  Doctor("1","nombre","1",1),
                   new  Doctor("2","nombre","1",1),
                new  Doctor("3","nombre","1",1)
        );




        /*RecyclerAdapterDoctor adapter = new RecyclerAdapterDoctor();
        adapter.setListaDoctor(doctorList);
        rv.setAdapter(adapter);*/

  }

    public void searchDoctors(String searchTitleUrl) {
        setContentView(R.layout.activity_bookings);
        final RecyclerView rv = (RecyclerView) findViewById(R.id.recycler);
        LinearLayoutManager  llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        System.out.println("URL = " + searchTitleUrl);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET, searchTitleUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // the response is already constructed as a JSONObject!
                try {

                    JSONArray resultsArray = response.getJSONArray("data");
                    int resultsCount = response.length();
                    System.out.println("Results: " + resultsCount);

                    int limit = resultsCount > 10 ? 10 : resultsCount;

                    ArrayList<Doctor> authors = new ArrayList<>();
                    for (int position = 0; position<limit ; position++){
                        JSONObject result = resultsArray.getJSONObject(position);
                        String nombre = result.getString("name");
                        System.out.println("Title = " + nombre);

                        Doctor doctor = new  Doctor("0",nombre,"1",1);
                        doctorList.add(doctor);

                    }
                    RecyclerAdapterDoctor adapter = new RecyclerAdapterDoctor();
                    adapter.setListaDoctor(doctorList);
                    rv.setAdapter(adapter);
                             /*if(Doctor.size() > 0) {
                        Intent intent = new Intent(MainActivity.this, BookCatalogActivity.class);
                        startActivity(intent);
                    }*/


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