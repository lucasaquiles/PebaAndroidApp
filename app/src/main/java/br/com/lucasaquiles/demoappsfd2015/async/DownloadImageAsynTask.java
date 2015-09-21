package br.com.lucasaquiles.demoappsfd2015.async;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;
import java.io.InputStream;

import br.com.lucasaquiles.demoappsfd2015.model.Item;

/**
 * Created by lucasaquiles on 9/17/15.
 */
public class DownloadImageAsynTask extends AsyncTask<String, Void, Bitmap>{


    private Item item;
    private ImageView imagem;
    private ProgressBar progressBar;
    private Bitmap bitmap;
    private View view;

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }

    public DownloadImageAsynTask(View view, Item item, ProgressBar progressBar, ImageView imagem, Context context) {
        this.item = item;
        this.imagem = imagem;
        this.progressBar = progressBar;
    }

    @Override
    protected void onPreExecute() {

        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected Bitmap doInBackground(String... params) {

        Log.i("buscando", item.getNome() );

        Bitmap bitmap = null;
        try {
            InputStream input = new java.net.URL(params[0]).openStream();
            bitmap = BitmapFactory.decodeStream(input);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return bitmap;
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {


        if(this.item.getBitmap() == null  && this.imagem.getTag().equals(item.getNome())) {

            Log.i("buscando", "baixou a imagem" );
            this.imagem.setImageBitmap(bitmap);
       }else{
           Log.i("buscando","ja tem bit map "+item.getNome());
       }

       progressBar.setVisibility(View.GONE);
    }
}
