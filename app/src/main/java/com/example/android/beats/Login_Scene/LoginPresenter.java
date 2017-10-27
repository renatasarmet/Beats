package com.example.android.beats.Login_Scene;

public class LoginPresenter {

    LoginView loginView = null;

    public LoginPresenter(LoginView loginView){
        this.loginView = loginView;
    }


    public void login(String username, String password){
        if(username.toString().isEmpty()){
            loginView.setErrorUsername();
        }
        else if(password.toString().isEmpty()){
            loginView.setErrorPassword();
        }
        else{
            loginView.efetuaLogin();
        }
    }
}
