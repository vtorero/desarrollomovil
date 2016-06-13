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

import java.util.ArrayList;

import pe.edu.upc.clinicaupc.R;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterAppointment;
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterDate;
import pe.edu.upc.clinicaupc.models.Appointment;
import pe.edu.upc.clinicaupc.models.Schedule;

/**
 * Created by weval_000 on 12/06/2016.
 */
public class DateActivity extends AppCompatActivity {

    private ArrayList<Schedule> dateScheduleList = new ArrayList<>();
    RecyclerView rv;
    private static String   SCHEDULE_SEARCH_URL = "http://tjvsac.com/api/api.php?reservas=1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dates);
        rv = (RecyclerView) findViewById(R.id.dateRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);

        searchDoctors(SCHEDULE_SEARCH_URL);

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

                        String fe_atencion = result.getString("fe_reserva").substring(0,11);

                        Schedule schedule = new Schedule(0,0,0,fe_atencion,"",1 );
                        dateScheduleList.add(schedule);

                    }
                    RecyclerAdapterDate adapter = new RecyclerAdapterDate();
                    adapter.setListDatesSchedule(dateScheduleList);
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
