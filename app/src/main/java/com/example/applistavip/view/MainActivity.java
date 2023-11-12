package com.example.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.applistavip.R;
import com.example.applistavip.controller.PessoaController;
import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final String NOME_PREFERENCES = "pref_listavip";

        SharedPreferences sharedPreferences = getSharedPreferences(NOME_PREFERENCES, 0);

        SharedPreferences.Editor listavip = sharedPreferences.edit();

        PessoaController pessoaController = new PessoaController();
        Pessoa pessoa = new Pessoa();

        EditText edtTxtNome = findViewById(R.id.edtTxtNome);
        EditText edtTxtSobrenome = findViewById(R.id.edtTxtSobrenome);
        EditText edtTxtCurso = findViewById(R.id.edtTxtCurso);
        EditText edtTxtTelefone = findViewById(R.id.edtTxtTelefone);

        Button btnLimpar = findViewById(R.id.btnLimpar);
        Button btnSalvar = findViewById(R.id.btnSalvar);
        Button btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTxtNome.setText("");
                edtTxtSobrenome.setText("");
                edtTxtCurso.setText("");
                edtTxtTelefone.setText("");
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(edtTxtNome.getText().toString());
                pessoa.setSobrenome(edtTxtSobrenome.getText().toString());
                pessoa.setCursoDesejado(edtTxtCurso.getText().toString());
                pessoa.setTelefoneContato(edtTxtTelefone.getText().toString());


                pessoaController.salvar(pessoa);

                listavip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listavip.putString("sobrenome", pessoa.getSobrenome());
                listavip.putString("curso", pessoa.getCursoDesejado());
                listavip.putString("numero", pessoa.getTelefoneContato());listavip.apply();

                Toast.makeText(MainActivity.this, "Salvo!", Toast.LENGTH_SHORT).show();

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Finalizado!", Toast.LENGTH_LONG).show();
                finish();
            }
        });
    }
}