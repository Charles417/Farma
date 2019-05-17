package com.example.joaopbsousa.cadastro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.joaopbsousa.cadastro1.Modelo.Produto;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    public void produto (View view){
        Intent intent = new Intent(this, ProdutoActivity.class);
        startActivity(intent);
    }

    public void farmacia (View view){
        Intent intent = new Intent(this, FarmaciaActivity.class);
        startActivity(intent);
    }



}




