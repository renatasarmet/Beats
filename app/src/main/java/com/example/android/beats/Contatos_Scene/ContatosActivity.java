package com.example.android.beats.Contatos_Scene;

import android.content.Intent;
import android.os.Parcelable;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.android.beats.AdicionarContato_Scene.AdicionarContatoActivity;
import com.example.android.beats.ContatoDetail_Scene.ContatoDetailActivity;
import com.example.android.beats.Entity.Contato;
import com.example.android.beats.Entity.ContatoList;
import com.example.android.beats.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class ContatosActivity extends AppCompatActivity implements ContatosView{

    ContatosPresenter contatosPresenter;
    @BindView(R.id.rv_contatos)
    RecyclerView rvContato;

    ContatoList listContatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contacts);
        ButterKnife.bind(this);
        contatosPresenter = new ContatosPresenter(this);

        //insere opção Up Action na ActionBar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        if( this.getIntent().getExtras() != null){
            listContatos = (ContatoList) this.getIntent().getSerializableExtra("Contatos");
            Log.e("Tamanho",""+listContatos.getContatos().get(0).getNome());
        }
        if(listContatos!= null)
            contatosPresenter.updateList(listContatos.getContatos());
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_cadastrar:
                contatosPresenter.adicionar();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

//    @OnClick(R.id.buttonAdd)
//    public void adicionar(){
//        contatosPresenter.adicionar();
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_cadastrar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public void addContato(){
        Intent adicionarContato = new Intent(ContatosActivity.this,AdicionarContatoActivity.class);
        adicionarContato.putExtra("Contatos",(Serializable) listContatos);
        startActivity(adicionarContato);
    }



    @Override
    public void updateList(final List<Contato> contatosList) {
            if(contatosList.size() > 0)
                Log.e("TAMANHOCA",""+contatosList.get(0).getNome());
            ContatosAdapter actionsAdapter = new ContatosAdapter(contatosList, this);
            actionsAdapter.setOnRecyclerViewSelected(new OnRecyclerViewSelected() {
                @Override
                public void onClick(View view, int position) {
                    Intent openDetailActivity = new Intent(ContatosActivity.this, ContatoDetailActivity.class);
                    openDetailActivity.putExtra("contato", (Serializable) contatosList.get(position));
                    startActivity(openDetailActivity);

                }
            });

            rvContato.setAdapter(actionsAdapter);
            LinearLayoutManager layoutManager = new LinearLayoutManager(this);
            rvContato.setLayoutManager(layoutManager);


        }

}
