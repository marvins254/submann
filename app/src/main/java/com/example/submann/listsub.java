package com.example.submann;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class listsub extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_listsub);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "launching ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent x= new Intent(listsub.this,savesubscriptions.class);
                startActivity(x);
                startActivity(new Intent(getApplicationContext(),savesubscriptions.class));
            }
        });
    }

}
