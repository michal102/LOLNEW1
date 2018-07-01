package com.example.admin.lolnew1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class minigry extends AppCompatActivity {

    ImageButton rexio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minigry);

        rexio=(ImageButton) findViewById(R.id.m_rex);

        rexio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), REX_io.class);
                startActivityForResult(intent,0);
            }
        });
    }
}
