package com.example.acremote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

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
    Button coldButon;
    boolean on = false;
    boolean cold = true;

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
        coldButon = findViewById(R.id.btnColdButton);

        onButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on = true;
                tvTemp.setText(""+temp);
                Toast.makeText(MainActivity.this, "ON", Toast.LENGTH_SHORT).show();

            }
        });

        offButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on = false;
                tvTemp.setText("--");
                Toast.makeText(MainActivity.this,"OFF",Toast.LENGTH_SHORT).show();
            }
        });

        pButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (on) {
                    if (cold) {
                        if (temp<27) {
                            temp++;
                            tvTemp.setText(""+temp);
                        }
                    }
                    else {
                        temp++;
                        tvTemp.setText(""+temp);
                    }
                }
            }
        });

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (on&&temp>0) {
                    if (!cold) {
                        if (temp>18){
                            temp--;
                            tvTemp.setText(""+temp);
                        }
                    }
                    else {
                        temp--;
                        tvTemp.setText(""+temp);
                    }
                }
            }
        });

        coldButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cold) {
                    if (temp>17) {
                        cold = false;
                        coldButon.setText("HEAT");

                    }
                }
                else if (temp<28){
                    cold = true;
                    coldButon.setText("COOL");
                }

            }
        });





    }

}