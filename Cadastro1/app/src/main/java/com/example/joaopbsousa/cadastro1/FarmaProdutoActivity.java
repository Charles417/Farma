package com.example.joaopbsousa.cadastro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.joaopbsousa.cadastro1.Modelo.FarmaProduto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class FarmaProdutoActivity extends AppCompatActivity {

    EditText editTextuidfarmacia;
    EditText editTextuidproduto;
    EditText editTextprecofp;
    private FarmaProduto farmaProduto;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farma_produto);

        editTextuidfarmacia = findViewById(R.id.txtUidFarmacia);
        editTextuidproduto = findViewById(R.id.txtUidProduto);
        editTextprecofp = findViewById(R.id.txtPrecoFP);
        conectarBanco();

    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(FarmaProdutoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void Cadastrar(View view)
    {
        FarmaProduto farmaProduto = new FarmaProduto();
        farmaProduto.setUidfarmacia(editTextuidfarmacia.getText().toString());
        farmaProduto.setUidproduto(editTextuidproduto.getText().toString());
        farmaProduto.setPreco(Double.parseDouble(editTextprecofp.getText().toString()));
        databaseReference.child("farmaproduto").child(farmaProduto.getUidfarmacia()+farmaProduto.getUidproduto()).setValue(farmaProduto);
        finish();
    }
}
