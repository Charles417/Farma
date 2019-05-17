package com.example.joaopbsousa.cadastro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.joaopbsousa.cadastro1.Modelo.Farmacia;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FarmaciaActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextTelefone;
    EditText editTextCnpj;
    EditText editTextEndereco;
    EditText editTextCep;
    private Farmacia farmacia;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmacia);

        editTextNome = findViewById(R.id.txtNomeFarmacia);
        editTextTelefone = findViewById(R.id.txtTelefone);
        editTextEndereco = findViewById(R.id.txtEndereco);
        editTextCnpj = findViewById(R.id.txtCpnj);
        editTextCep = findViewById(R.id.txtCep);
        conectarBanco();

    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(FarmaciaActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Cadastrar(View view)
    {
        Farmacia farmacia = new Farmacia();
        farmacia.setUidfarmacia(UUID.randomUUID().toString());
        farmacia.setNome(editTextNome.getText().toString());
        farmacia.setEndereco(editTextEndereco.getText().toString());
        farmacia.setTelefone(Double.parseDouble(editTextTelefone.getText().toString()));
        farmacia.setCnpj(Double.parseDouble(editTextCnpj.getText().toString()));
        farmacia.setCep(Double.parseDouble(editTextCep.getText().toString()));
        databaseReference.child("farmacia").child(farmacia.getUidfarmacia()).setValue(farmacia);
        finish();
    }
}
