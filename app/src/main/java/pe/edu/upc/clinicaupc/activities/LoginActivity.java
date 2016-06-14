package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
import pe.edu.upc.clinicaupc.models.Appointment;
import pe.edu.upc.clinicaupc.models.Patient;


/**
 * Created by vjimenez on 21/05/2016.
 */
public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser;
    EditText txtPassword;
    private String userName;
    private ArrayList<Patient> patientList = new ArrayList<>();
    //private static String   DOCTOR_SEARCH_URL = "http://tjvsac.com/api/api.php?medicoEspecialidad=";
    private static String   PATIENT_SEARCH_URL = "http://tjvsac.com/api/api.php?login=true&";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.button);
        txtUser = (EditText) findViewById(R.id.nameEditText);
        txtPassword= (EditText) findViewById(R.id.passwordEditText);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (!txtUser.getText().toString().isEmpty() && !txtPassword.getText().toString().isEmpty()) {

                       searchPatient(PATIENT_SEARCH_URL+"dni="+txtUser.getText().toString()+"&pass="+txtPassword.getText().toString());



                }else{
                    Toast.makeText(getApplicationContext(), "Ingrese ususario y contraseña", Toast.LENGTH_LONG).show();
                }
            }

        });

    }

    public void searchPatient(String searchTitleUrl) {

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
                        String codigo = result.getString("co_paciente");
                        String nombre = result.getString("de_nombreCompleto");
                        String dni = result.getString("nu_dni");
                        String clave = result.getString("de_clave");
                        String estado = result.getString("in_estado");
                        System.out.println("nombre = " + nombre);
                        Patient patient = new  Patient(codigo ,nombre,dni,clave,estado);
                        patientList.add(patient);
                        userName=nombre;

                        System.out.println("ddd"+ userName);
                        Intent itemIntent = new Intent(LoginActivity.this, AppointmentActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("nombrePaciente",userName);
                        itemIntent.putExtras(bundle);
                        startActivity(itemIntent);


                    }

                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(getApplicationContext(), "Usuario y/o contreseña incorrecta", Toast.LENGTH_LONG).show();
                }
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
                Toast.makeText(getApplicationContext(), "Usuario incorrecto", Toast.LENGTH_LONG).show();
            }
        }
        );
        Volley.newRequestQueue(this).add(jsonRequest);

    }


}