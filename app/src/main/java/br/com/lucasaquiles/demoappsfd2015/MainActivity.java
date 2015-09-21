package br.com.lucasaquiles.demoappsfd2015;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button button;
    EditText textText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textText = (EditText) findViewById(R.id.editTextNome);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == button.getId()){
            Intent i = new Intent(getApplicationContext(), ListResultActivity.class);
            i.putExtra("nome", textText.getText().toString());
            startActivity(i);
        }
    }
}
