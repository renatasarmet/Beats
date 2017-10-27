package com.example.android.beats.AdicionarContato_Scene;

public class AdicionarContatoPresenter {

    AdicionarContatoView adicionarContatoView = null;

    public AdicionarContatoPresenter(AdicionarContatoView adicionarContatoView){
        this.adicionarContatoView = adicionarContatoView;
    }

    public void addFoto(){
        adicionarContatoView.adicionarFoto();
    }

    public void mapa(){
        adicionarContatoView.abrirMapa();
    }

    public void salvarContato(){
        adicionarContatoView.salvar();
    }
}

