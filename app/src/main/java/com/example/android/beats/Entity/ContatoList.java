package com.example.android.beats.Entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by renatasarmet on 19/12/2017.
 */

public class ContatoList  implements Serializable {
    private List<Contato> contatos = new ArrayList<Contato>();
    private static final long serialVersionUID = 46543445;

    public List<Contato> getContatos(){
        return contatos;
    }
    public void setContatos(List<Contato> c){
        contatos = c;
    }
    public void addContatos(Contato c){
        contatos.add(c);
    }
}
