package com.example.charlesprovatti.farma;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.menu_ajuda)
        {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }
        else if (id == R.id.menu_sobre)
        {
            Intent intent = new Intent(this, MenuActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);

    }

    public void conectarBanco()
    {
        FirebaseApp.initializeApp(MainActivity.this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    private void eventoBanco()
    {
        databaseReference.child("Produto").addValueEventListener(new ValueEventListener()
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

                arrayAdapterProduto = new ArrayAdapter<Produto>(MainActivity.this, R.layout.layout_lista, R.id.tvLista, listaProduto);
                listView.setAdapter(arrayAdapterProduto);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError)
            {

            }
        });
    }

}
