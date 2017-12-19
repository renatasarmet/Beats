package com.example.android.beats.AdicionarContato_Scene;

import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.example.android.beats.Contatos_Scene.ContatosActivity;
import com.example.android.beats.Entity.Contato;
import com.example.android.beats.Login_Scene.LoginActivity;
import com.example.android.beats.R;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.Serializable;
import java.net.URI;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AdicionarContatoActivity extends AppCompatActivity implements AdicionarContatoView {

    @BindView(R.id.editTextAddUsername)
    EditText txUsername;
    @BindView(R.id.editTextAddEmail)
    EditText txEmail;
    @BindView(R.id.editTextAddEndereco)
    EditText txEndereco;
    @BindView(R.id.editTextAddTelefone)
    EditText txTelefone;
    @BindView(R.id.buttonAddFoto)
    ImageButton imgBtn;

    private static final int CODIGO_CAMERA = 123;
    public String caminhoFoto;
    AdicionarContatoPresenter adicionarContatoPresenter;
    Contato c = new Contato();
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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_salvar, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void adicionarFoto(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        caminhoFoto = getExternalFilesDir(null) + "/" + System.currentTimeMillis() + ".jpg";
        File arquivoFoto = new File(caminhoFoto);
        Uri fileUri = FileProvider.getUriForFile(this, "com.example.Beats.fileprovider", arquivoFoto);
        intentCamera.putExtra(MediaStore.EXTRA_OUTPUT,fileUri);
        startActivityForResult(intentCamera, CODIGO_CAMERA);

    }

    @OnClick(R.id.buttonMapa)
    public void mapa(){
        adicionarContatoPresenter.mapa();
    }

    public void abrirMapa(){
        Intent intentMapa = new Intent(Intent.ACTION_VIEW);
        intentMapa.setData(Uri.parse("geo:0,0?q=" + txEndereco));
        if(intentMapa.resolveActivity(getPackageManager()) != null) {
            startActivity(intentMapa);
        }else {
            Toast toast = Toast.makeText(AdicionarContatoActivity.this, "Impossível abrir o recurso", Toast.LENGTH_LONG);
            toast.show();
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODIGO_CAMERA && resultCode == Activity.RESULT_OK) {
            Glide.with(imgBtn.getContext())
                    .load(caminhoFoto)
                    .transform(new CenterCrop(imgBtn.getContext()))
                    .override(40,40)
                    .into(imgBtn);
            c.setImage(caminhoFoto);
        }
    }


    public void salvar() {
        //Futuramente aqui deverá salvar no banco de dados
        Intent irParaContatos = new Intent(AdicionarContatoActivity.this, ContatosActivity.class);
        c.setNome(txUsername.getText().toString());
        c.setEmail(txEmail.getText().toString());
        c.setTelefone(txTelefone.getText().toString());
        c.setEndereco(txEndereco.getText().toString());
        irParaContatos.putExtra("contato",c);
        startActivity(irParaContatos);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_salvar:
                adicionarContatoPresenter.salvarContato();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }



}