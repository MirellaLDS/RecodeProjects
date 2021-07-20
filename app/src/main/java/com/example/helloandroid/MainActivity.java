package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showToastMessage(View view) {
        Toast.makeText(this, "Hello Toast", Toast.LENGTH_LONG).show();
    }

    public void goAcount(View view) {
        contador += 1;

        TextView campoDeTexto = findViewById(R.id.tvContador);
        campoDeTexto.setText(Integer.toString(contador));
    }
}