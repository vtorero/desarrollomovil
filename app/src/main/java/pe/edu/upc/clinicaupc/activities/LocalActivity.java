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
import pe.edu.upc.clinicaupc.adapters.RecyclerAdapterLocal;
import pe.edu.upc.clinicaupc.models.Appointment;
import pe.edu.upc.clinicaupc.models.Schedule;
import pe.edu.upc.clinicaupc.models.Local;


/**
 * Created by weval_000 on 12/06/2016.
 */
public class LocalActivity extends AppCompatActivity {

    private ArrayList<Local> localList = new ArrayList<>();
    RecyclerView rv;
    private static String   LOCAL_SEARCH_URL = "http://190.223.63.4:6002/wcfsrvcitasmedicas/SedeSrv.svc/Sedes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);
        rv = (RecyclerView) findViewById(R.id.localRecyclerView);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        searchDoctors(LOCAL_SEARCH_URL);
    }

    public void searchDoctors(String searchTitleUrl) {

        System.out.println("URL = " + searchTitleUrl);
        JsonObjectRequest jsonRequest = new JsonObjectRequest(
                Request.Method.GET, searchTitleUrl, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                // the response is already constructed as a JSONObject!
                try {

                    JSONArray resultsArray = response.getJSONArray("ObtenerSedesResult");
                    int resultsCount = resultsArray.length();
                    System.out.println("Results: " + resultsCount);
                    int limit = resultsCount > 10 ? 10 : resultsCount;

                    for (int position = 0; position<resultsCount ; position++){
                        JSONObject result = resultsArray.getJSONObject(position);

                        String de_sede = result.getString("de_sede");
                        String co_sede = result.getString("co_sede");

                        Local local = new Local(co_sede,de_sede,1 );
                        localList.add(local);
                    }
                    RecyclerAdapterLocal adapter = new RecyclerAdapterLocal();
                    adapter.setListLocal(localList);
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
