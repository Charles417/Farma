package com.example.charlesprovatti.farma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        String tipo = intent.getStringExtra("tipo");
        TextView textViewMenu = findViewById(R.id.txtMenu);
        textViewMenu.setText(tipo);
        textViewMenu.setTextSize(24);

    }
}
