package com.example.android.beats.AdicionarContato_Scene;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.FileProvider;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.android.beats.Contatos_Scene.ContatosActivity;
import com.example.android.beats.Entity.Contato;
import com.example.android.beats.Entity.ContatoList;
import com.example.android.beats.R;

import java.io.File;
import java.io.Serializable;
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
    String cImg;
    ContatoList listcont;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        ButterKnife.bind(this);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        listcont = (ContatoList) this.getIntent().getSerializableExtra("Contatos");
        adicionarContatoPresenter = new AdicionarContatoPresenter(this);
        setTitle("Adicionar Contato");
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
        intentMapa.setData(Uri.parse("geo:0,0?q=" + txEndereco.getText()));
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
                    .asBitmap().centerCrop()
                    .into(new BitmapImageViewTarget(imgBtn){
                        @Override
                        protected  void  setResource(Bitmap resource){
                            RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(imgBtn.getContext().getResources(),resource);
                            circularBitmapDrawable.setCircular(true);
                            imgBtn.setImageDrawable(circularBitmapDrawable);
                        }
                    }); //imgBtn);
            cImg= caminhoFoto;
        }
    }


    public void salvar() {
        //Futuramente aqui deverá salvar no banco de dados
        Intent irParaContatos = new Intent(AdicionarContatoActivity.this, ContatosActivity.class);
        Contato c = new Contato();
        c.setNome(txUsername.getText().toString());
        c.setEmail(txEmail.getText().toString());
        c.setTelefone(txTelefone.getText().toString());
        c.setEndereco(txEndereco.getText().toString());
        c.setImage(cImg);
        if(listcont == null)
                listcont = new ContatoList();
        listcont.addContatos(c);
        irParaContatos.putExtra("Contatos",(Serializable)  listcont);
        startActivity(irParaContatos);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_salvar:
                adicionarContatoPresenter.salvarContato();
                return true;
            case android.R.id.home:
                onBackPressed();
                return true;


            default:
                return super.onOptionsItemSelected(item);
        }

    }

}