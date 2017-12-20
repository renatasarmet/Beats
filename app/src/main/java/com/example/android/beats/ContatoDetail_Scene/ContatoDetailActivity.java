package com.example.android.beats.ContatoDetail_Scene;


import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.android.beats.Entity.Contato;
import com.example.android.beats.R;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ContatoDetailActivity extends AppCompatActivity implements ContatoDetailView {

    ContatoDetailPresenter contatoDetailPresenter;
    Contato contato;

    @BindView(R.id.tx_nome)
    TextView txUsername;
    @BindView(R.id.tx_email)
    TextView txEmail;
    @BindView(R.id.tx_endereco)
    TextView txEndereco;
    @BindView(R.id.tx_telefone)
    TextView txTelefone;
    @BindView(R.id.img)
    ImageView img;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.contatodetail);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        contatoDetailPresenter = new ContatoDetailPresenter(this);
        contato = (Contato) getIntent().getSerializableExtra("contato");

        contatoDetailPresenter.getDetails(contato);
    }



    @Override
    public void showDetails(Contato contato) {

        final Context context = img.getContext();
        final ImageView imgm = img;
        Glide.with(context)
                .load(contato.getImage())
                .asBitmap().centerCrop()
                .into(new BitmapImageViewTarget(img){
                    @Override
                    protected  void  setResource(Bitmap resource){
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                        circularBitmapDrawable.setCircular(true);
                        imgm.setImageDrawable(circularBitmapDrawable);
                    }
                });
//        txUsername.setText("Nome: " + contato.getNome());
//        txTelefone.setText("Telefone: " + contato.getTelefone());
//        txEmail.setText("Email: " + contato.getEmail());
//        txEndereco.setText("Endereço: " + contato.getEndereco());
        txUsername.setText(contato.getNome());
        txTelefone.setText(contato.getTelefone());
        txEmail.setText( contato.getEmail());
        txEndereco.setText(contato.getEndereco());
        setTitle(contato.getNome());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}
