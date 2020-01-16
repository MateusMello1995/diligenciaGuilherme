package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class telaAssinatura extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_assinatura);
    }
    public void proximaTela(View view){

        Intent intent = new Intent(this, telabranco.class);
        startActivity(intent);
    }
}
