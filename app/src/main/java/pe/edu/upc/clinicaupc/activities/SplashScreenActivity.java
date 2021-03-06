package pe.edu.upc.clinicaupc.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

import pe.edu.upc.clinicaupc.R;

public class SplashScreenActivity extends AppCompatActivity {

    public static final int segundos = 3;
    public static final int milisegundos = segundos * 1000;
    public static final int delay = 2;
    private ProgressBar progreso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        progreso = (ProgressBar) findViewById(R.id.progressBar);
        progreso.setMax(maximo_progreso());
        empezaranimacion();
    }
    public void empezaranimacion() {
        new CountDownTimer(milisegundos, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                progreso.setProgress(establecer_progreso(millisUntilFinished));
            }

            @Override
            public void onFinish() {
                Intent nuevoFrom = new Intent(SplashScreenActivity.this,LoginActivity.class);
                startActivity(nuevoFrom);
                finish();
            }
        }.start();

    }

    public int establecer_progreso(long miliseconds) {
        return (int) ((milisegundos - miliseconds) / 1000);
    }
    public int maximo_progreso(){
        return segundos-delay;
    }
}
