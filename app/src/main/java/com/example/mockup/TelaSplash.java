package com.example.mockup;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class TelaSplash extends AppCompatActivity {
@Override
    protected void onCreate(Bundle savedInstanceState){
    super.onCreate(savedInstanceState);
    setContentView(R.layout.telasplash);

    new Handler().postDelayed(new Runnable() {
        @Override
        public void run() {
            startActivity(new Intent(getBaseContext(), MainActivity.class));
            finish();
        }
    }, 3000);


}
}
