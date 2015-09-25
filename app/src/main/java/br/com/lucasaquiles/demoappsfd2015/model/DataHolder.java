package br.com.lucasaquiles.demoappsfd2015.model;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by lucasaquiles on 9/25/15.
 */
public class DataHolder {

    Map<String, WeakReference<Object>> data = new HashMap<String, WeakReference<Object>>();

    void put(String id, Object object){
        data.put(id, new WeakReference<Object>(object));
    }

    Object get(String id){

        WeakReference<Object> reference = data.get(id);
        return reference.get();
    }
}
