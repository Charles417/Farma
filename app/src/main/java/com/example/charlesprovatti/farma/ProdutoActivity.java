package com.example.charlesprovatti.farma;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlesprovatti.farma.Farma.Imagem;
import com.example.charlesprovatti.farma.Farma.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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
        //produto.setPreco(Double.parseDouble(this.getIntent().getStringExtra("preco")));

        imageView = findViewById(R.id.imgProduto);
        textNome = findViewById(R.id.txtNome);
        textFabricante = findViewById(R.id.txtFabricante);
        textDescricao = findViewById(R.id.txtDescricao);
        textPrecos = findViewById(R.id.txtPrecos);

        new Imagem.DownloadImageFromInternet(imageView).execute(produto.getImagem());
        textNome.setText(produto.getNome());
        textFabricante.setText(produto.getFabricante());
        textDescricao.setText(produto.getDescricao());
        //textPrecos.setText(produto.getPreco().toString());

        conectaBanco();

    }

    public void conectaBanco()
    {
        FirebaseApp.initializeApp(ProdutoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

}
