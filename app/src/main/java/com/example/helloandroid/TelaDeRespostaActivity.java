package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TelaDeRespostaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_de_resposta);

        String mensagem = getIntent().getStringExtra("IDENTIFICADOR_MENSAGEM");

        TextView txtMensagemRecebida = findViewById(R.id.tvResposta);
        txtMensagemRecebida.setText(mensagem);

    }

    public void abrirTelaMensagem(View view) {

        TextView textView = findViewById(R.id.edResposta);

        Intent mensageiro2 = new Intent();
        String mensagem = textView.getText().toString();
        mensageiro2.putExtra("TELA_DE_RESPOSTA", mensagem);

        setResult(RESULT_OK, mensageiro2);
        finish();

    }
}