package com.example.android.beats;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.editTextUsername) TextInputEditText editTextUsername;
    @BindView(R.id.editTextPassword) TextInputEditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.buttonLogin)
    public void login(){
        if(!editTextUsername.toString().isEmpty() && !editTextPassword.toString().isEmpty()){
            Intent abrirContatos = new Intent(MainActivity.this,ContatoActivity.class);
            startActivity(abrirContatos);
        }
    }


}
