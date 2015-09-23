package br.com.lucasaquiles.demoappsfd2015.adpter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

/**
 * Created by lucasaquiles on 9/23/15.
 */
public class AppUtils {


    public static boolean isOnline(Context context) {

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();

        boolean b = false; //netInfo != null && netInfo.isConnected();


//        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
//
        for (NetworkInfo ni : netInfo) {
            if ((ni.getTypeName().equalsIgnoreCase("WIFI")
                    || ni.getTypeName().equalsIgnoreCase("MOBILE"))
                    && ni.isConnected() && ni.isAvailable()) {

                Log.i("appUtils", "verificando conexão");

                b = true;

                Log.i("appUtils", ni.getTypeName()+" status  "+Boolean.valueOf(b));
            }

        }

//
//        if(b) {
//
//            try {
//                Process p1 = java.lang.Runtime.getRuntime().exec("ping -c 1 http://ismycomputeronfire.com/");
//
//                Log.i("appUtils","verificando conexão");
//                int returnVal = p1.waitFor();
//                boolean reachable = (returnVal == 0);
//
//                Log.i("appUtils","status: "+returnVal);
//                return reachable;
//
//            } catch (Exception e) {
//                Log.i("appUtils", e.getMessage());
//                e.printStackTrace();
//            }
//
//            Log.i("appUtils","status: sem conexão");
//            return false;
//
//
//        }
        return b;
    }
}
