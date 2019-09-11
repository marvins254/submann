package com.example.submann;

import android.accounts.Account;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;

import java.util.HashMap;

public class savesubscriptions extends AppCompatActivity {

    Button buttonSave, buttonCancel;
    TextView textViewSave;
    EditText editTextAccount,editTextAmount,editTextCycle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savesubscriptions);
        buttonSave=findViewById(R.id.buttonsave);
        buttonCancel=findViewById(R.id.buttonCancel);
        editTextAccount=findViewById(R.id.editTextAccount);
        editTextAmount = findViewById(R.id.editTextAmount);
        editTextCycle= findViewById(R.id.editTextCycle);
        final String account= editTextAmount.getText().toString();
        final String amount= editTextAccount.getText().toString();
        final String cycle=editTextCycle.getText().toString();

        //toolbar title
        setTitle("Save Subscriptions");
        //call toolbar
        Toolbar toolbar=findViewById(R.id.toolbar2);
        setActionBar(toolbar);


        findViewById(R.id.buttonsave).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Saving ", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                Intent myint = new Intent(savesubscriptions.this, listsub.class);
                myint.putExtra("account",account);
                myint.putExtra("amount",amount);
                myint.putExtra("cycle",cycle);
                startActivity(myint);
//            String myText=editTextAccount.getText().toString();
//            textViewSave.setText(myText);
                SaveSub();


            }
        });
        findViewById(R.id.buttonCancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(savesubscriptions.this, listsub.class);
                startActivity(b);
                startActivity(new Intent(getApplicationContext(), listsub.class));

            }
        });
    }


    private void SaveSub() {
        final String account = editTextAccount.getText().toString().trim();
        final String amount = editTextAmount.getText().toString().trim();
        final String cycle = editTextCycle.getText().toString().trim();

        //first we will do the validations

        if (TextUtils.isEmpty(account)) {
            editTextAccount.setError("Please enter an account");
//            editTextAccount.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(amount)) {
            editTextAmount.setError("Please enter an amount");
//            editTextAmount.requestFocus();
            return;
        }

        if (TextUtils.isEmpty(cycle)) {
            editTextCycle.setError("Please enter a payment cycle");
//            editTextCycle.requestFocus();
            return;
        }

        //if it passes all the validations

        class Save extends AsyncTask<Void, Void, String> {

            //private ProgressBar progressBar;

            @Override
            protected String doInBackground(Void... voids) {
                //creating request handler object
                RequestHandler requestHandler = new RequestHandler();

                //creating request parameters
                HashMap<String, String> params = new HashMap<>();
                params.put("account", account);
                params.put("amount", amount);
                params.put("Cycle", cycle);


                //returing the response
                return requestHandler.sendPostRequest(urls.URL_SAVE, params);
            }
//
            //         ProgressBar progressBar;
//            @Override
//            protected void onPreExecute() {
////
//                super.onPreExecute();
            //displaying the progress bar while user registers on the server
//                progressBar = findViewById(R.id.progressBar);
//                progressBar.setVisibility(View.VISIBLE);
////            }
////
//            @Override
//            protected void onPostExecute(String s); {
//                super.onPostExecute(s);
            //hiding the progressbar after completion
            //       progressBar.setVisibility(View.GONE);
////
        }
        //try {
//                    //converting response to json object
//                    //conversion on login and registration.java error
        //        Log.e("Test",s);
//
//
        //          JSONObject jsonObject = new JSONObject(s);
//                    //String obj = s.toJson(s);
        //            JSONArray jsonArray= new JSONArray(s);
//
////                    //if no error in response
        //                if (!jsonObject.getBoolean("error")) {
        //                  Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
////
////                        //getting the user from the response
//                        JSONObject usersJson = jsonObject.getJSONObject(s);
////
////                        //creating a new user object
//                        user user = new user(
//                                usersJson.getInt("id"),
//                                usersJson.getString("username"),
//                                usersJson.getString("email")
//
//                        );
////
//                        //storing the user in shared preferences
//                        SharedPrefManager.getInstance(getApplicationContext()).userLogin(user);
//
//                        //starting the profile activity
//                        finish();
//                        startActivity(new Intent(getApplicationContext(), subscriptions.class));
//                    } else {
//                        Toast.makeText(getApplicationContext(), "Some error occurred", Toast.LENGTH_SHORT).show();
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
//
//        //executing the async task
//        RegisterUser ru = new RegisterUser();
//        ru.execute();
    }

}
