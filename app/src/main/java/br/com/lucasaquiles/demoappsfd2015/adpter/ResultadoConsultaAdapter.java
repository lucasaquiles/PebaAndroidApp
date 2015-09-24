package br.com.lucasaquiles.demoappsfd2015.adpter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import br.com.lucasaquiles.demoappsfd2015.R;
import br.com.lucasaquiles.demoappsfd2015.async.DownloadImageAsynTask;
import br.com.lucasaquiles.demoappsfd2015.model.Item;

/**
 * Created by lucasaquiles on 9/16/15.
 */
public class ResultadoConsultaAdapter extends ArrayAdapter<Item> {

    private List<Item> itens = new ArrayList<Item>();

   public ResultadoConsultaAdapter(Context context, int resource, List<Item> itens){
        super(context, resource, itens);

       this.itens.addAll(itens);
    }

    static class ViewHolder{
        TextView nome;
        TextView partido;
        ImageView imagem;
        ProgressBar progressBar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        if(convertView == null){

            LayoutInflater vi = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            convertView = vi.inflate(R.layout.item_layout, null);

            holder = new ViewHolder();

            holder.nome = (TextView) convertView.findViewById(R.id.nome);
            holder.partido = ((TextView) convertView.findViewById(R.id.partido));
            holder.imagem = ((ImageView) convertView.findViewById(R.id.pic));
            holder.progressBar = (ProgressBar) convertView.findViewById(R.id.progressBar);

            convertView.setTag(holder);
        }else{

            holder = (ViewHolder) convertView.getTag();
        }

        Item item = itens.get(position);

        holder.nome.setText(item.getNome());
        holder.partido.setText(item.getPartido());
        holder.imagem.setTag(item.getNome());

        if(holder.imagem.getDrawable() == null) {

            new DownloadImageAsynTask(convertView, item, holder.progressBar, holder.imagem, this.getContext()).execute(item.getUrl_foto());
        }
       // holder.imagem.setImageBitmap(downloadImageAsynTask.getBitmap());

        return convertView;
    }

    @Override
    public Item getItem(int position) {

        return itens.get(position);
    }
    //
    @Override
    public long getItemId(int position) {
        return position;
    }
}
