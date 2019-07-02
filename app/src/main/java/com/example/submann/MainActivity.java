package com.example.submann;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button login, register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login= (Button)findViewById(R.id.login);
        register=(Button)findViewById(R.id.register);





        register.setOnClickListener(new View.OnClickListener() {
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
