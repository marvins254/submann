package com.example.submann;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

public class listsub extends AppCompatActivity {
 ListView listView;
 TextView textView;
 String[] listItem;
    Intent myint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listsub);

        setTitle("Subscriptions");
        listView= findViewById(R.id.listSubscription);
        textView=findViewById(R.id.textView);

         myint=getIntent();
        String account=myint.getStringExtra("account");
        textView.setText(account);
        String amount=myint.getStringExtra("amount");
        textView.setText(amount);
        String cycle=myint.getStringExtra("cycle");
        textView.setText(cycle);

        Toolbar toolbar=findViewById(R.id.toolbar);
        setActionBar(toolbar);

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
