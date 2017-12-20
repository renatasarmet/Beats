package com.example.android.beats.Contatos_Scene;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.android.beats.Entity.Contato;
import com.example.android.beats.R;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by renatasarmet on 18/12/2017.
 */

public class ContatosAdapter extends RecyclerView.Adapter<ContatosAdapter.ViewHolder> {
    private List<Contato> contatoList;
    OnRecyclerViewSelected onRecyclerViewSelected;
    private Context context;

    //Construtor que recebe a lista
    ContatosAdapter(List<Contato> contatoList, Context context) {
        this.contatoList = contatoList;
        this.context = context;
    }

    //infla o componente view
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.contato_item_list, parent, false);
        return new ViewHolder(v);
    }

    //seta os dados nas views
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Contato contato = contatoList.get(position);
        holder.txnome.setText(contato.getNome());
        holder.txtelefone.setText(contato.getTelefone());
        final Context context = holder.imgBackgroud.getContext();
        final ImageView img = holder.imgBackgroud;
        Glide.with(context)
                .load(contato.getImage())
                .asBitmap().centerCrop()
                .into(new BitmapImageViewTarget(holder.imgBackgroud){
                    @Override
                    protected  void  setResource(Bitmap resource){
                        RoundedBitmapDrawable circularBitmapDrawable = RoundedBitmapDrawableFactory.create(context.getResources(),resource);
                        circularBitmapDrawable.setCircular(true);
                        img.setImageDrawable(circularBitmapDrawable);
                    }
                });
    }

    //retorna o tamanho da lista
    @Override
    public int getItemCount() {
        return contatoList.size();
    }

    //mapeamento dos componentes da view
    public class ViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tx_nome)
        TextView txnome;

        @BindView(R.id.tx_telefone)
        TextView txtelefone;

        @BindView(R.id.image_view_background)
        ImageView imgBackgroud;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        //seta o clique rápido
        @OnClick(R.id.container)
        void onItemClick(View view){
            if(onRecyclerViewSelected != null)
                onRecyclerViewSelected.onClick(view, getAdapterPosition());

        }
    }

    public void setOnRecyclerViewSelected(OnRecyclerViewSelected onRecyclerViewSelected){
        this.onRecyclerViewSelected = onRecyclerViewSelected;
    }
}
