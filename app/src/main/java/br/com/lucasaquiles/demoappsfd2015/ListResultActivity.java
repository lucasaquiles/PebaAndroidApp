package br.com.lucasaquiles.demoappsfd2015;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import br.com.lucasaquiles.demoappsfd2015.async.SearchAsyncTask;
import br.com.lucasaquiles.demoappsfd2015.model.Item;


public class ListResultActivity extends ActionBarActivity implements AdapterView.OnItemClickListener{

   private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_result);

        listView = (ListView) findViewById(R.id.list);
        listView.setBackgroundColor(Color.WHITE);
        listView.setOnItemClickListener(this);

        Intent intent = getIntent();

        String valorNome = (String) intent.getSerializableExtra("nome");

        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        new SearchAsyncTask(ListResultActivity.this).execute(valorNome);
    }




    public ListView getListView() {
        return listView;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_list_result, menu);
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

            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Item item = (Item) parent.getItemAtPosition(position);

        Intent i  = new Intent(this, ItemDetail.class);
        i.putExtra("item", item);

        startActivity(i);
    }
}
