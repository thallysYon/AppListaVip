package com.example.applistavip.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.applistavip.R;
import com.example.applistavip.model.Pessoa;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtTxtNome = findViewById(R.id.edtTxtNome);
        EditText edtTxtSobrenome = findViewById(R.id.edtTxtSobrenome);
        EditText edtTxtCurso = findViewById(R.id.edtTxtCurso);
        EditText edtTxtTelefone = findViewById(R.id.edtTxtTelefone);

        Button  btnLimpar = findViewById(R.id.btnLimpar);
        Button  btnSalvar = findViewById(R.id.btnSalvar);
        Button  btnFinalizar = findViewById(R.id.btnFinalizar);

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtTxtNome.setText("");
                edtTxtSobrenome.setText("");
                edtTxtCurso.setText("");
                edtTxtTelefone.setText("");
            }
        });
    }
}