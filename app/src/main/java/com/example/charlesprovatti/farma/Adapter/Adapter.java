package com.example.charlesprovatti.farma.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.charlesprovatti.farma.Farma.Imagem;
import com.example.charlesprovatti.farma.Farma.Produto;
import com.example.charlesprovatti.farma.R;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<Produto>
{
    private Context mContext;
    private List<Produto> produtoLista = new ArrayList<>();

    public Adapter(@NonNull Context context,@SuppressLint("SupportAnnotationUsage") @LayoutRes ArrayList<Produto> list)
    {
        super (context, 0, list);
        mContext = context;
        produtoLista = list;
    }

    @NonNull
    @Override
    public View getView (int position, @NonNull View convertView, @NonNull ViewGroup parent)
    {
        View listItem = convertView;
        if (listItem == null)
        {
            listItem = LayoutInflater.from(mContext).inflate(R.layout.layout_lista, parent, false);
        }

        Produto produtoAtual = produtoLista.get(position);

        new Imagem.DownloadImageFromInternet((ImageView) listItem.findViewById(R.id.imageProduto)).execute(produtoAtual.getImagem());
        TextView nome = listItem.findViewById(R.id.tvNome);
        nome.setText(produtoAtual.getNome());

        TextView fabricante = listItem.findViewById(R.id.tvFabricante);
        fabricante.setText(produtoAtual.getFabricante());
        return listItem;

    }
}
