package com.example.helloandroid.ListView;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.helloandroid.R;

import java.util.ArrayList;


public class ListagemAdapter extends ArrayAdapter<String> {

    private Context context;
    private int resource;
    private ArrayList<String> lista;

    public ListagemAdapter(@NonNull Context context, int resource, @NonNull ArrayList<String> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.lista = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View itemView = convertView;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        TextView textView = itemView.findViewById(R.id.tvItem);
        textView.setText(lista.get(position));

        return itemView;
    }

    @Override
    public int getCount() {
        return lista.size();
    }
}
