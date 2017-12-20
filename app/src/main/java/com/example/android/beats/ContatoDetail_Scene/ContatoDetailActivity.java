package com.example.android.beats.ContatoDetail_Scene;


import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.android.beats.Entity.Contato;
import com.example.android.beats.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContatoDetailActivity extends AppCompatActivity implements ContatoDetailView {

    ContatoDetailPresenter contatoDetailPresenter;
    Contato contato;

    @BindView(R.id.editTextAddUsername)
    EditText txUsername;
    @BindView(R.id.editTextAddEmail)
    EditText txEmail;
    @BindView(R.id.editTextAddEndereco)
    EditText txEndereco;
    @BindView(R.id.editTextAddTelefone)
    EditText txTelefone;
    @BindView(R.id.img)
    ImageButton img;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.contatodetail);
        ButterKnife.bind(this);

        contatoDetailPresenter = new ContatoDetailPresenter(this);

        //insere opção Up Action na ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        contato = (Contato) getIntent().getSerializableExtra("contato");

        contatoDetailPresenter.getDetails(contato);
    }



    @Override
    public void showDetails(Contato contato) {
        Picasso.with(this)
                .load(contato.getImage())
                .centerCrop()
                .fit()
                .into(img);
        txUsername.setText(contato.getNome());
        txTelefone.setText(contato.getTelefone());
        txEmail.setText(contato.getEmail());
        txEndereco.setText(contato.getEndereco());
        setTitle(contato.getNome());
    }



}
