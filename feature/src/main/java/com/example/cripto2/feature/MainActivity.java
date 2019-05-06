package com.example.cripto2.feature;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cripto2.feature.criptografia.Criptografia;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickCripto(View v){
        EditText editMensagem = findViewById(R.id.editMensagem);
        EditText editMensagemCripto = findViewById(R.id.editMensagemcripto);
        String mensagem =  editMensagem.getText().toString().toUpperCase();

        Criptografia criptografia = new Criptografia();
        criptografia.converterMsgEmMatriz(mensagem);
        criptografia.criptografar();
        editMensagemCripto.setText(criptografia.toString());
        Toast.makeText(getApplicationContext(), "Criptografia realizada com sucesso!!!", Toast.LENGTH_LONG).show();
    }

}
