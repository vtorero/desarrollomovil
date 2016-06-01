package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import pe.edu.upc.clinicaupc.R;


/**
 * Created by vjimenez on 21/05/2016.
 */
public class LoginActivity extends AppCompatActivity {

    Button btnLogin;
    EditText txtUser;

    @Override
     protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        btnLogin = (Button) findViewById(R.id.button);
        txtUser = (EditText) findViewById(R.id.nameEditText);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if("victor".equals(txtUser.getText().toString()))
                {
                    Intent NuevoFrom = new Intent(LoginActivity.this,BookingsActivity.class);
                    startActivity(NuevoFrom);
                }
                else
                {

                    System.out.println("Results"+txtUser.getText().toString());
                }

            }
        });

    }


}
