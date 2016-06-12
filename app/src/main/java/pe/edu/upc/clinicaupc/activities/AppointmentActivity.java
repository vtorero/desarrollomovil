package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterAppointment;
import pe.edu.upc.clinicaupc.models.Appointment;


import java.util.ArrayList;

public class AppointmentActivity extends AppCompatActivity {

  private ArrayList<Appointment> appointmentList = new ArrayList<>();
  RecyclerView rv;

  private static String   APPOINTMENT_SEARCH_URL = "http://tjvsac.com/api/api.php?reservas=1";
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    rv = (RecyclerView) findViewById(R.id.appointmentRecycler);
    LinearLayoutManager  llm = new LinearLayoutManager(this);
    rv.setLayoutManager(llm);

    searchDoctors(APPOINTMENT_SEARCH_URL);

    FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.newFab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        startActivity(new Intent(getApplicationContext(), SpecialtiesActivity.class));
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show();
      }
    });

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
            String co_reserva = result.getString("co_reserva");
            String de_especialidad = result.getString("de_especialidad");
            String de_nombreCompleto = result.getString("de_nombreCompleto");
            String fe_reserva = result.getString("fe_reserva").substring(0,11);
            String ho_atencion = result.getString("ho_atencion");
            String de_sede = result.getString("de_sede");

            //System.out.println("co_reserva = " + co_reserva);

            Appointment appointment = new Appointment(co_reserva,de_especialidad,de_nombreCompleto, fe_reserva,ho_atencion,de_sede);
            appointmentList.add(appointment);

          }
          RecyclerAdapterAppointment adapter = new RecyclerAdapterAppointment();
          adapter.setListAppointment(appointmentList);
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
