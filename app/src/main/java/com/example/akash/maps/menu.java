package com.example.akash.maps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class menu extends AppCompatActivity {
    private Button bu1;
    private Button bu2;
    private Button bu3;
    private Button bu4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        bu1=(Button)findViewById(R.id.bu1);
        bu2=(Button)findViewById(R.id.bu2);

        bu4=(Button)findViewById(R.id.bu4);
        bu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(menu.this,gmaps.class);
                startActivity(intent);
            }
        });
        bu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent =new Intent(menu.this,Alternatives.class);
                startActivity(intent);
            }
        });

        };

    }




