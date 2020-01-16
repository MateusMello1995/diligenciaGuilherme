package com.example.mockup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        }
    public void proximaTela(View view){

        Intent intent = new Intent(this, telaSobre.class);
        startActivity(intent);
    }

    public void proximaTela1(View view){

        Intent intent = new Intent(this, cadastro.class);
        startActivity(intent);
    }
    public void proximaTela2(View view){

        Intent intent = new Intent(this, telabranco.class);
        startActivity(intent);
    }
        }



