package com.example.android.beats.AdicionarContato_Scene;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.example.android.beats.Contatos_Scene.ContatosActivity;
import com.example.android.beats.Login_Scene.LoginActivity;
import com.example.android.beats.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdicionarContatoActivity extends AppCompatActivity implements AdicionarContatoView {
    @BindView(R.id.editTextAddEndereco) TextInputEditText editTextAddEndereco;

    AdicionarContatoPresenter adicionarContatoPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        ButterKnife.bind(this);
        adicionarContatoPresenter = new AdicionarContatoPresenter(this);
    }

    @OnClick(R.id.buttonAddFoto)
    public void addFoto(){
        adicionarContatoPresenter.addFoto();
    }


    public void adicionarFoto(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(getPackageManager()) != null) {
            startActivity(intentCamera);
        }else{
            Toast toast = Toast.makeText(AdicionarContatoActivity.this,"Impossivel abrir o recurso",Toast.LENGTH_LONG);
            toast.show();
        }

    }

    @OnClick(R.id.buttonMapa)
    public void mapa(){
        adicionarContatoPresenter.mapa();
    }

    public void abrirMapa(){
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + editTextAddEndereco));
        if(intentMapa.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMapa);
        }else {
            Toast toast = Toast.makeText(AdicionarContatoActivity.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }

    @OnClick(R.id.buttonSalvar)
    public void salvarContato(){
        adicionarContatoPresenter.salvarContato();
    }

    public void salvar() {
        //Futuramente aqui deverá salvar no banco de dados
        Intent irParaContatos = new Intent(AdicionarContatoActivity.this, ContatosActivity.class);
        startActivity(irParaContatos);
    }
}