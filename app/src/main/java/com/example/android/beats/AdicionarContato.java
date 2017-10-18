package com.example.android.beats;

import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by leo-pc on 10/17/17.
 */

public class AdicionarContato extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addcontact);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.buttonAddFoto)
    public void adicionarFoto(){
        Intent intentCamera = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intentCamera.resolveActivity(getPackageManager()) != null) {
            startActivity(intentCamera);
        }else{
            Toast toast = Toast.makeText(AdicionarContato.this,"Impossivel abrir o recurso",Toast.LENGTH_LONG);
            toast.show();
        }

    }
}
