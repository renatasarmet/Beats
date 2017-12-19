package com.example.android.beats.ContatoDetail_Scene;

import com.example.android.beats.Entity.Contato;

public class ContatoDetailPresenter {

    ContatoDetailView contatoDetailView;

    public ContatoDetailPresenter(ContatoDetailView contatoDetailView) {
        this.contatoDetailView = contatoDetailView;
    }

    public void getDetails(Contato contato) {
        contatoDetailView.showDetails(contato);
    }
}
