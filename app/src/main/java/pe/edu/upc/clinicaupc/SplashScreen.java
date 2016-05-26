package pe.edu.upc.clinicaupc;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ProgressBar;

public class SplashScreen extends AppCompatActivity {
    public static final int segundos = 8;
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
                Intent nuevoFrom = new Intent(SplashScreen.this,Login.class);
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
