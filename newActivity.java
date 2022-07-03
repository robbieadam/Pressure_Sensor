package android.example.sensorpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class newActivity extends AppCompatActivity implements SensorEventListener {
    private TextView textview;
    private SensorManager sensorManager;
    private Sensor pressureSensor;
    private Boolean isPressureSensorAvailable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);

        textview = findViewById(R.id.data);
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);

        if(sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE)!=null)
        {
            pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
            isPressureSensorAvailable = true;
        }else {
            textview.setText("Pressure Sensor is not Available");
            isPressureSensorAvailable = false;
        }



        Button changeActivityBTN3 = findViewById(R.id.button3);
        Button changeActivityBTN2 = findViewById(R.id.button2);

        changeActivityBTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity3();
            }
        });

        changeActivityBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity2();
            }
        });

    }
    private void changeActivity3() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void changeActivity2() {
        Intent intent= new Intent(this, newActivity2.class);
        startActivity(intent);
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        textview.setText(sensorEvent.values[0] +"hPa");
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (isPressureSensorAvailable)
        {
            sensorManager.registerListener(this, pressureSensor, SensorManager.SENSOR_DELAY_NORMAL);
        }
    }
    @Override
    protected void onPause(){
        super.onPause();

        if (isPressureSensorAvailable)
        {
            sensorManager.unregisterListener(this);
        }
    }

}

