package com.example.android.beats;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContatoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.buttonAdd)
    public void addContato(){
        Intent adicionarContato = new Intent(ContatoActivity.this,AdicionarContato.class);
        startActivity(adicionarContato);

    }
}
