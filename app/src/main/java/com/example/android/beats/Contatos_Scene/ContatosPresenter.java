package com.example.android.beats.Contatos_Scene;


import com.example.android.beats.Entity.Contato;

import java.util.List;

public class ContatosPresenter {

    ContatosView contatosView = null;

    public ContatosPresenter(ContatosView contatosView){
        this.contatosView = contatosView;
    }

    public void adicionar(){
        contatosView.addContato();
    }
    protected void updateList(List<Contato> listContact) {
        contatosView.updateList(listContact);


    }
}
