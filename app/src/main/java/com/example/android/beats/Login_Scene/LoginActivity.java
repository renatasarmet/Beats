package com.example.android.beats.Login_Scene;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.android.beats.Contatos_Scene.ContatosActivity;
import com.example.android.beats.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.editTextUsername) TextInputEditText editTextUsername;
    @BindView(R.id.editTextPassword) TextInputEditText editTextPassword;
    @BindView(R.id.text_input_layout_username) TextInputLayout text_input_layout_username;
    @BindView(R.id.text_input_layout_password) TextInputLayout text_input_layout_password;

    LoginPresenter loginPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnTextChanged(R.id.editTextUsername)
    public void checaUsuario(){
        text_input_layout_username.setErrorEnabled(false);
        text_input_layout_username.setError("");
    }

    @OnTextChanged(R.id.editTextPassword)
    public void checaSenha(){
        text_input_layout_password.setErrorEnabled(false);
        text_input_layout_password.setError("");
    }

    @Override
    public void setErrorUsername() {
        text_input_layout_username.setErrorEnabled(true);
        text_input_layout_username.setError(getString(R.string.invalidUsername));
    }

    @Override
    public void setErrorPassword() {
        text_input_layout_password.setErrorEnabled(true);
        text_input_layout_password.setError(getString(R.string.invalidPassword));
    }

    @OnClick(R.id.buttonLogin)
    public void login(){
       loginPresenter.login(editTextUsername.getText().toString(), editTextPassword.getText().toString());
    }

    @Override
    public void efetuaLogin() {
        Intent abrirContatos = new Intent(LoginActivity.this,ContatosActivity.class);
        startActivity(abrirContatos);
    }

}
