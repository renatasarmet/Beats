package com.example.android.beats.Contatos_Scene;


public class ContatosPresenter {

    ContatosView contatosView = null;

    public ContatosPresenter(ContatosView contatosView){
        this.contatosView = contatosView;
    }

    public void adicionar(){
        contatosView.addContato();
    }
}
