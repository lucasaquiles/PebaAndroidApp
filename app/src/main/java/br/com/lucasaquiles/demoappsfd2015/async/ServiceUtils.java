package br.com.lucasaquiles.demoappsfd2015.async;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.lucasaquiles.demoappsfd2015.model.Item;

/**
 * Created by lucasaquiles on 9/14/15.
 */
public class ServiceUtils {

    public static final String DEFAULT_URL = "http://peba.teresinahc.org/deputados";

    public List<Item> consultar(String nome){

        WebService webService = new WebService(DEFAULT_URL);

        Map<String, String> params = new HashMap<String, String>();


        params.put("format","json");
        params.put("q", nome);

        String response = webService.webGet("", params);

        Gson gson = new Gson();

        List<Item> publishes = gson.fromJson(response, new TypeToken<ArrayList<Item>>(){}.getType());

        return publishes;
    }
}
