package com.example.android.beats;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextUsername;
    TextInputEditText editTextPassword;
    Button buttonLogin;
    Button buttonAdd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = (TextInputEditText) findViewById(R.id.editTextUsername);
        editTextPassword = (TextInputEditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonAdd = (Button) findViewById(R.id.buttonAdd);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextUsername.toString().isEmpty() && !editTextPassword.toString().isEmpty()){
                    setContentView(R.layout.contacts);
                }
            }
        });



    }
}
