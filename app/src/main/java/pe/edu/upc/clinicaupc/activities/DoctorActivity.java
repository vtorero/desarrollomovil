package pe.edu.upc.clinicaupc.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

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
import pe.edu.upc.clinicaupc.models.Doctor;

public class DoctorActivity extends AppCompatActivity {
    RecyclerView rv;
    TextView tittle;
    private String titleSpecia;
    private ArrayList<Doctor> doctorList = new ArrayList<>();
    private static String   DOCTOR_SEARCH_URL = "http://tjvsac.com/api/api.php?medicoEspecialidad=";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctors);
        rv = (RecyclerView) findViewById(R.id.recycler);
        tittle =(TextView) findViewById(R.id.SpecialtyTittle);
        LinearLayoutManager  llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        Bundle bundle = getIntent().getExtras();
        String criterio = bundle.getString("coEspecialidad");
        searchDoctors(DOCTOR_SEARCH_URL+criterio);

  }

    public void searchDoctors(String searchTitleUrl) {

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
                        String nombre = result.getString("name");
                        String especialidad = result.getString("especialidad");
                        String codigo = result.getString("codigo");
                        System.out.println("nombre = " + nombre);

                        Doctor doctor = new  Doctor(codigo ,nombre,especialidad,1);
                        doctorList.add(doctor);
                        titleSpecia=especialidad;

                    }

                    RecyclerAdapterDoctor adapter = new RecyclerAdapterDoctor();
                    tittle.setText(titleSpecia);
                    adapter.setListaDoctor(doctorList);
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