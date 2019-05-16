package com.example.joaopbsousa.cadastro1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.joaopbsousa.cadastro1.Modelo.Farmacia;
import com.example.joaopbsousa.cadastro1.Modelo.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
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