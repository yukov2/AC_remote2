package com.example.acremote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity  {

    TextView tvTemp;
    int temp;
    Button pButton;
    Button mButton;
    Button onButton;
    Button offButton;
    boolean on = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvTemp = findViewById(R.id.tvTemp);
        temp = 16;
        pButton = findViewById(R.id.btnPbutton);
        mButton = findViewById(R.id.btnMButton);
        onButton = findViewById(R.id.btnOnButton);
        offButton = findViewById(R.id.btnOffbutton);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on = true;

            }
        });



    }

}