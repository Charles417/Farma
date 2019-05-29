package com.example.charlesprovatti.farma;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.charlesprovatti.farma.Farma.FarmaProduto;
import com.example.charlesprovatti.farma.Farma.Imagem;
import com.example.charlesprovatti.farma.Farma.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class ProdutoActivity extends AppCompatActivity {

    public  ArrayList<FarmaProduto> listaPrecos = new ArrayList<FarmaProduto>();
    LinearLayout layoutLinear;

    ImageView imageView;
    TextView textNome;
    TextView textFabricante;
    TextView textDescricao;
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
        produto.setUidproduto(this.getIntent().getStringExtra("uidproduto"));

        imageView = findViewById(R.id.imgProduto);
        textNome = findViewById(R.id.txtNome);
        textFabricante = findViewById(R.id.txtFabricante);
        textDescricao = findViewById(R.id.txtDescricao);


        new Imagem.DownloadImageFromInternet(imageView).execute(produto.getImagem());
        textNome.setText(produto.getNome());
        textFabricante.setText(produto.getFabricante());
        textDescricao.setText(produto.getDescricao());

        conectaBanco();
        pesquisaPreco();
        listaFarmaPreco(listaPrecos);

    }

    public void conectaBanco()
    {
        FirebaseApp.initializeApp(ProdutoActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    public void pesquisaPreco()
    {
        databaseReference.child("farmaproduto").orderByChild("uidproduto").equalTo(produto.getUidproduto()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPrecos.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    FarmaProduto farmaProduto = snapshot.getValue(FarmaProduto.class);
                    listaPrecos.add(farmaProduto);
                }
                listaFarmaPreco(listaPrecos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void listaFarmaPreco(ArrayList<FarmaProduto> lista)
    {
        layoutLinear = findViewById(R.id.lVertical);
        for (int i = 0; i < lista.size(); i++)
        {
            TextView textViewFarma = new TextView(this);
            TextView textViewPreco = new TextView(this);

            textViewFarma.setText(lista.get(i).getFarmacia());
            textViewFarma.setTypeface(textViewFarma.getTypeface().DEFAULT_BOLD);
            textViewFarma.setTextSize(16);
            textViewFarma.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
            textViewPreco.setText(lista.get(i).getPreco().toString());
            textViewPreco.setTextSize(16);

            layoutLinear.addView(textViewFarma);
            layoutLinear.addView(textViewPreco);
        }
    }
}
