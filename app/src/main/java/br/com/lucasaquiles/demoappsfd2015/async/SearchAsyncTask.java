package br.com.lucasaquiles.demoappsfd2015.async;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasaquiles.demoappsfd2015.ListResultActivity;
import br.com.lucasaquiles.demoappsfd2015.R;
import br.com.lucasaquiles.demoappsfd2015.adpter.ResultadoConsultaAdapter;
import br.com.lucasaquiles.demoappsfd2015.model.Item;

/**
 * Created by lucasaquiles on 9/14/15.
 */
public class SearchAsyncTask extends AsyncTask<String, Void, List<Item>>{

    private Context context;
    private ProgressDialog progressDialog;

    public SearchAsyncTask(Context context){
        this.context= context;
    }

    @Override
    protected List<Item> doInBackground(String... params) {

        List<Item> consultar = new ServiceUtils().consultar(params[0]);

        return consultar;
    }

    @Override
    protected void onPostExecute(List<Item> itens) {

        Log.i("info","buscano ... ");

        if(itens.size() > 0){

//            ArrayAdapter<Item> adp = new ArrayAdapter<Item>(context, android.R.layout.simple_list_item_1, itens);

            ResultadoConsultaAdapter adp = new ResultadoConsultaAdapter(context, R.layout.item_layout, itens);

            ((ListResultActivity) context).getListView().setAdapter(adp);
        }else{

            ArrayAdapter itemAdapter = new ArrayAdapter(context, android.R.layout.simple_list_item_1, new ArrayList<Item>() );

            ((ListResultActivity) context).getListView().setAdapter(itemAdapter);
        }

        progressDialog.dismiss();
        progressDialog = null;
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPreExecute() {

        if(progressDialog != null){

            progressDialog.dismiss();
        }

        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("buscando...");
        progressDialog.show();
    }
}
