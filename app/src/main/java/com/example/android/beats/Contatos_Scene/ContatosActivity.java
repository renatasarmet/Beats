package com.example.android.beats.Contatos_Scene;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.beats.AdicionarContato_Scene.AdicionarContatoActivity;
import com.example.android.beats.R;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContatosActivity extends AppCompatActivity implements ContatosView{

    ContatosPresenter contatosPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        ButterKnife.bind(this);
        contatosPresenter = new ContatosPresenter(this);
    }
    @OnClick(R.id.buttonAdd)
    public void adicionar(){
        contatosPresenter.adicionar();
    }

    public void addContato(){
        Intent adicionarContato = new Intent(ContatosActivity.this,AdicionarContatoActivity.class);
        startActivity(adicionarContato);

    }
}
