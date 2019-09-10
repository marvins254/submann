package com.example.submann;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button login, register1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login= findViewById(R.id.login);
        register1= findViewById(R.id.register1);


        register1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent o= new Intent(MainActivity.this,Register.class);
                startActivity(o);
                startActivity(new Intent(getApplicationContext(),Register.class));
            }

        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent u= new Intent(MainActivity.this,Login.class);
                startActivity(u);
                startActivity(new Intent(getApplicationContext(),Login.class));


            }
        });


    }
}
