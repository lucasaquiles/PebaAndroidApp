package br.com.lucasaquiles.demoappsfd2015;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.lucasaquiles.demoappsfd2015.adpter.AppUtils;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    private Button button;
    private EditText textText;

    static boolean isNetworkOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.button);
        textText = (EditText) findViewById(R.id.editTextNome);

        button.setOnClickListener(this);
    }

    @Override
    protected void onStart() {

        super.onStart();

        isNetworkOn = AppUtils.isOnline(this);

        if(!isNetworkOn){

            createNetworkDialog();
        }


    }

    private void createNetworkDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("você precisa de internet para continuar cavando").setTitle("Sorry!");
        AlertDialog dialog = builder.create();
        dialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {

                MainActivity.this.finish();

            }
        });
        dialog.show();
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
