package com.example.helloandroid.ListView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.helloandroid.R;

import java.util.ArrayList;
import java.util.HashMap;

public class ListagemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listagem);

        ListView listView = findViewById(R.id.lvListagem);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, getListShortName());

        ArrayAdapter<String> test = new ListagemAdapter(this, R.layout.item_listagem, getListShortName());

        listView.setAdapter(adapter);

        listView.setOnItemClickListener((adapterView, view, position, id) -> {

            String itemValue = (String) listView.getItemAtPosition(position);

            String fullName = mapOfState().get(itemValue);

            Toast.makeText(getApplicationContext(), fullName, Toast.LENGTH_SHORT).show();
        });
    }


    private ArrayList<String> getListFullName() {
        return new ArrayList<>(mapOfState().values());
    }

    private ArrayList<String> getListShortName() {
        return new ArrayList<>(mapOfState().keySet());
    }

    private HashMap<String, String> mapOfState() {
        HashMap<String, String> estados = new HashMap<>();
        estados.put("AC", "Acre");
        estados.put("AL", "Alagoas");
        estados.put("AP", "Amapá");
        estados.put("AM", "Amazonas");
        estados.put("BA", "Bahia");
        estados.put("CE", "Ceará");
        estados.put("DF", "Distrito Federal");
        estados.put("ES", "Espírito Santo");
        estados.put("GO", "Goiás");
        estados.put("MA", "Maranhão");
        estados.put("MT", "Mato Grosso");
        estados.put("MS", "Mato Grosso do Sul");
        estados.put("MG", "Minas Gerais");
        estados.put("PA", "Pará");
        estados.put("PB", "Paraíba");
        estados.put("PR", "Paraná");
        estados.put("PE", "Pernambuco");
        estados.put("PI", "Piauí");
        estados.put("RJ", "Rio de Janeiro");
        estados.put("RN", "Rio Grande do Norte");
        estados.put("RS", "Rio Grande do Sul");
        estados.put("RO", "Rondônia");
        estados.put("RR", "Roraima");
        estados.put("SC", "Santa Catarina");
        estados.put("SP", "São Paulo");
        estados.put("SE", "Sergipe");
        estados.put("TO", "Tocantins");
        return estados;
    }

}