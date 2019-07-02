package com.example.submann;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class subscriptions extends AppCompatActivity {
    Button buttonLogout;

    ListView listView;
    String mTitle[] = {"Cellular", "government utilities", "personal", "Cable"};
    String mDescription[] = { "Cellular Subscriptions", "Government Utilities", "Personal Subscriptions", "TV Subscriptions"};
    int images[] = {R.drawable.phone, R.drawable.gvt, R.drawable.home, R.drawable.tv};
    // so our images and other things are set in array


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.content_subscriptions);


            if (!SharedPrefManager.getInstance(this).isLoggedIn()) {
                finish();
                startActivity(new Intent(this, subscriptions.class));
            }

            //when the user presses logout button
            //calling the logout method
            findViewById(R.id.buttonLogout).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                    SharedPrefManager.getInstance(getApplicationContext()).logout();
                }
            });




            listView = findViewById(R.id.ItemList);

            MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
            listView.setAdapter(adapter);
            // there is my mistake...
            // now again check this..

            // now set item click on list view
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    if (position ==  0) {
                        Toast.makeText(subscriptions.this, "Cellular subscriptions", Toast.LENGTH_SHORT).show();
                    }
                    if (position ==  1) {
                        Toast.makeText(subscriptions.this, "Government Utilities", Toast.LENGTH_SHORT).show();
                    }
                    if (position ==  2) {
                        Toast.makeText(subscriptions.this, "Personal Subscriptions", Toast.LENGTH_SHORT).show();
                    }
                    if (position ==  3) {
                        Toast.makeText(subscriptions.this, "TV Subscriptions", Toast.LENGTH_SHORT).show();
                    }
                }
            });
            // so item click is done now check list view
            }

    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter(Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textview1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textview1);
            TextView myDescription = row.findViewById(R.id.textview2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);
            return row;
        }

    }




}





