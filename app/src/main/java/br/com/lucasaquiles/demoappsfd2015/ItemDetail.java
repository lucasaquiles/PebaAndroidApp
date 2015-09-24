package br.com.lucasaquiles.demoappsfd2015;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import br.com.lucasaquiles.demoappsfd2015.async.DownloadImageAsynTask;
import br.com.lucasaquiles.demoappsfd2015.model.Item;


public class ItemDetail extends ActionBarActivity {

    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView textViewNome;
    private TextView textViewPartido;
    private TextView textViewValorTotalGastos;
    private TextView textViewUf;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        imageView = (ImageView) findViewById(R.id.image_profile);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        textViewNome = (TextView) findViewById(R.id.nome);
        textViewPartido = (TextView) findViewById(R.id.partido);
        textViewValorTotalGastos = (TextView) findViewById(R.id.val_total_gastos);
        textViewUf = (TextView) findViewById(R.id.uf);


        Intent i = getIntent();
        Item item = (Item) i.getSerializableExtra("item");

        if(item != null){


            if(item.getBitmap() == null) {
//                View view, Item item, ProgressBar progressBar, ImageView imagem, Con/**/text context
                new DownloadImageAsynTask(null, item, progressBar, imageView, this).execute(item.getUrl_foto());
            }
           // imageView.setImageBitmap(item.getBitmap());
        }else{
            Toast.makeText(this, "vish", Toast.LENGTH_LONG).show();
        }


        textViewNome.setText(item.getNome());
        textViewPartido.setText(item.getPartido());
        textViewValorTotalGastos.setText(item.getTotal_despesas());
        textViewUf.setText(item.getUf());


        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_item_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {

            Intent i = new Intent(this, ListResultActivity.class);
            startActivity(i);
        }


        return super.onOptionsItemSelected(item);
    }
}
