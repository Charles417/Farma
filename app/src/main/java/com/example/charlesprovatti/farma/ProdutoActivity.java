package com.example.charlesprovatti.farma;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlesprovatti.farma.Farma.Imagem;
import com.example.charlesprovatti.farma.Farma.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ProdutoActivity extends AppCompatActivity {

    ImageView imageView;
    TextView textNome;
    TextView textFabricante;
    TextView textDescricao;
    TextView textPrecos;
    private Produto produto;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_produto);

        produto = new Produto();
        produto.setImagem(this.getIntent().getStringExtra("imagem"));
        produto.setNome(this.getIntent().getStringExtra("nome"));
        produto.setFabricante(this.getIntent().getStringExtra("fabricante"));
        produto.setDescricao(this.getIntent().getStringExtra("descricao"));
        produto.setUidproduto((this.getIntent().getStringExtra("uidproduto")));

        imageView = findViewById(R.id.imgProduto);
        textNome = findViewById(R.id.txtNome);
        textFabricante = findViewById(R.id.txtFabricante);
        textDescricao = findViewById(R.id.txtDescricao);
        textPrecos = findViewById(R.id.txtPrecos);

        new Imagem.DownloadImageFromInternet(imageView).execute(produto.getImagem());
        textNome.setText(produto.getNome());
        textFabricante.setText(produto.getFabricante());
        textDescricao.setText(produto.getDescricao());
        textPrecos.setText(produto.getUidproduto());

        conectaBanco();

    }

    public void conectaBanco()
    {
        FirebaseApp.initializeApp(ProdutoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void pesquisaPreco(View view)
    {
        databaseReference.child("farmaproduto").orderByChild("uidproduto").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

}
