package android.example.sensorpressure;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class newActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new2);


        Button changeActivityBTN3 = findViewById(R.id.button3);
        Button changeActivityBTN = findViewById(R.id.button);

        changeActivityBTN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity3();
            }
        });

        changeActivityBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changeActivity();
            }
        });

    }
    private void changeActivity3() {
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    private void changeActivity() {
        Intent intent= new Intent(this, newActivity.class);
        startActivity(intent);
    }

}