package com.example.android.beats;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    TextInputEditText editTextUsername;
    TextInputEditText editTextPassword;
    Button buttonLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextUsername = (TextInputEditText) findViewById(R.id.editTextUsername);
        editTextPassword = (TextInputEditText) findViewById(R.id.editTextPassword);
        buttonLogin = (Button) findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!editTextUsername.toString().isEmpty() && !editTextPassword.toString().isEmpty()){
                    setContentView(R.layout.contatos);
                }
            }
        });



    }
}
