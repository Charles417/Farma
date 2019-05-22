package com.example.joaopbsousa.cadastro1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.joaopbsousa.cadastro1.Modelo.Farmacia;
import com.example.joaopbsousa.cadastro1.Modelo.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.UUID;

public class ProdutoActivity extends AppCompatActivity {

    EditText editTextNome;
    EditText editTextDescricao;
    EditText editTextFabricante;
    EditText editTextImagem;
    private Produto produto;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

       editTextNome = findViewById(R.id.txtNomeProduto);
       editTextDescricao = findViewById(R.id.txtDescricao);
       editTextFabricante = findViewById(R.id.txtFabricante);
       editTextImagem = findViewById(R.id.txtImagem);
       conectarBanco();
    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(ProdutoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }


    public void Cadastrar(View view)
    {
        Produto produto = new Produto();
        produto.setUidproduto(UUID.randomUUID().toString());
        produto.setNome(editTextNome.getText().toString());
        produto.setDescricao(editTextDescricao.getText().toString());
        produto.setFabricante(editTextFabricante.getText().toString());
        produto.setImagem(editTextImagem.getText().toString());
        databaseReference.child("produto").child(produto.getUidproduto()).setValue(produto);
        finish();
    }


}
