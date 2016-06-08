package pe.edu.upc.clinicaupc.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterDoctor;
import pe.edu.upc.clinicaupc.models.Doctor;


import java.util.ArrayList;

public class AppointmentActivity extends AppCompatActivity {
  private ArrayList<Doctor> doctorList = new ArrayList<>();
  private static String   DOCTOR_SEARCH_URL = "http://tjvsac.com/api/api.php?name=borda";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    searchDoctors(DOCTOR_SEARCH_URL);

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

          }
          RecyclerAdapterDoctor adapter = new RecyclerAdapterDoctor();
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
