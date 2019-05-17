package com.example.charlesprovatti.farma;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.charlesprovatti.farma.Adapter.Adapter;
import com.example.charlesprovatti.farma.Farma.Produto;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Produto produto;
    TextView textView;
    ImageView imageView;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    private ListView listView;
    private List<Produto> listaProduto = new ArrayList<Produto>();
    private ArrayAdapter<Produto> arrayAdapterProduto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listView = findViewById(R.id.listProduto);
        conectarBanco();
        eventoBanco();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_config)
        {
            Intent intent = new Intent(this, ConfiguracoesActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.menu_ajuda)
        {
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("tipo","Fale conosco: farmaconsulta@gmail.com");
            startActivity(intent);
        }
        else if (id == R.id.menu_sobre)
        {
            Intent intent = new Intent(this, MenuActivity.class);
            intent.putExtra("tipo","Aplicativo em desenvolvimento.");
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }


    public void pesquisaProduto (View view)
    {
        produto = new Produto();

        imageView = findViewById(R.id.imageProduto);
        imageView.setImageURI(Uri.parse(produto.getImagem()));
        textView = findViewById(R.id.tvNome);
        textView.setText(produto.getNome());
        textView = findViewById(R.id.tvFabricante);
        textView.setText(produto.getFabricante());



    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void eventoBanco()
    {
        databaseReference.child("produto").addValueEventListener(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot)
            {
                listaProduto.clear();
                for (DataSnapshot snapshot:dataSnapshot.getChildren())
                {
                    Produto produto = snapshot.getValue(Produto.class);
                    listaProduto.add(produto);
                }

                arrayAdapterProduto = new Adapter(MainActivity.this, (ArrayList<Produto>)listaProduto);
                listView.setAdapter(arrayAdapterProduto);

                listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     Produto produtoSelecionado = (Produto)parent.getItemAtPosition(position);
                     Intent intent = new Intent(MainActivity.this, ProdutoActivity.class);
                     intent.putExtra("imagem", produtoSelecionado.getImagem());
                     intent.putExtra("nome", produtoSelecionado.getNome());
                     intent.putExtra("fabricante", produtoSelecionado.getFabricante());
                     intent.putExtra("descricao", produtoSelecionado.getDescricao());
                     intent.putExtra("preco", produtoSelecionado.getPreco());
                     startActivity(intent);
                    }
                });

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

}
