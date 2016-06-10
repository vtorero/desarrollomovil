package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import pe.edu.upc.clinicaupc.R;


/**
 * Created by vjimenez on 21/05/2016.
 */
public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser;
    EditText txtPassword;

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
                    if ("victor".equals(txtUser.getText().toString()) && "123".equals(txtPassword.getText().toString())) {
                        Intent NuevoFrom = new Intent(LoginActivity.this, SpecialtiesActivity.class);
                        startActivity(NuevoFrom);
                    } else {
                        Toast.makeText(getApplicationContext(), "Usuario y/o contraseña incorrectos", Toast.LENGTH_LONG).show();
                    }

                }else{
                    Toast.makeText(getApplicationContext(), "ingrese ususario y contraseña", Toast.LENGTH_LONG).show();
                }
            }

        });

    }


}
