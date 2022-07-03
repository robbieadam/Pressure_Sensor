package android.example.sensorpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button changeActivityBTN = findViewById(R.id.button);
        Button changeActivityBTN2 = findViewById(R.id.button2);

        changeActivityBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity();
            }
        });

        changeActivityBTN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity2();
            }
        });

    }
    private void changeActivity() {
        Intent intent= new Intent(this, newActivity.class);
        startActivity(intent);
    }
    private void changeActivity2() {
        Intent intent= new Intent(this, newActivity2.class);
        startActivity(intent);
    }

}