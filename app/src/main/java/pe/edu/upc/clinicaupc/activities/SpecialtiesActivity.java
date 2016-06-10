package pe.edu.upc.clinicaupc.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

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
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterDoctor;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterSpecialty;
import pe.edu.upc.clinicaupc.models.Doctor;
import pe.edu.upc.clinicaupc.models.Specialty;

public class SpecialtiesActivity extends AppCompatActivity {
    private ArrayList<Specialty> specialties  = new ArrayList<>();
    RecyclerView rv;
    private static String   SPECIALTY_SEARCH_URL = "http://tjvsac.com/api/api.php?especialidades=true";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specialties);
        rv = (RecyclerView) findViewById(R.id.SpeciaRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        searchSpecialties(SPECIALTY_SEARCH_URL);

    }

    public void searchSpecialties(String searchTitleUrl) {

        System.out.println("URL = " + searchTitleUrl);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET, searchTitleUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // the response is already constructed as a JSONObject!
                try {

                    JSONArray resultsArray = response.getJSONArray("data");
                    int resultsCount = resultsArray.length();
                    System.out.println("Results: " + resultsCount);
                    int limit = resultsCount > 10 ? 10 : resultsCount;

                    for (int position = 0; position<resultsCount ; position++){
                        JSONObject result = resultsArray.getJSONObject(position);
                        String code = result.getString("co_especialidad");
                        String especialty = result.getString("de_especialidad");
                        System.out.println("nombre = " + especialty);

                        Specialty specialty= new Specialty(code ,especialty,"1");
                        specialties.add(specialty);

                    }
                    RecyclerAdapterSpecialty adapter = new RecyclerAdapterSpecialty();
                    adapter.setListSpecialty(specialties);
                    rv.setAdapter(adapter);
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
