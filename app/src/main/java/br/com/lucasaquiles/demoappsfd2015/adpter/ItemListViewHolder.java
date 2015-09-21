package br.com.lucasaquiles.demoappsfd2015.adpter;

import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lucasaquiles on 9/17/15.
 */
public class ItemListViewHolder {

   private TextView nome;
    private TextView partido;
   private ImageView image;

    public TextView getNome() {
        return nome;
    }

    public void setNome(TextView nome) {
        this.nome = nome;
    }

    public TextView getPartido() {
        return partido;
    }

    public void setPartido(TextView partido) {
        this.partido = partido;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}
