package com.example.helloandroid.ListView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.R;
import com.example.helloandroid.Utilitaria;

public class ListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        ListView listView = findViewById(R.id.lvListagem);

        // ADAPTER SIMPLES
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, Utilitaria.getListShortName());

        // ADAPTER PERSONALIZADO
//        ArrayAdapter<String> test = new ListagemAdapter(this, R.layout.item_listagem, getListShortName());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            String itemValue = (String) listView.getItemAtPosition(position);

            String fullName = Utilitaria.mapOfState().get(itemValue);

            Toast.makeText(getApplicationContext(), fullName, Toast.LENGTH_SHORT).show();
        });
    }

}