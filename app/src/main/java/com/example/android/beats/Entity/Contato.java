package com.example.android.beats.Entity;

import java.io.Serializable;

public class Contato implements Serializable {

    private String nome;
    private String email;
    private String telefone;
    private String endereco;
    private String image;
    private int mData;

    private static final long serialVersionUID = 46543445;

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefone() {
        return telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public String getImage() {
        return image;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
