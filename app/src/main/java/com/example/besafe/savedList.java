package com.example.besafe;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.Preference;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;



public class savedList {
    private static final String con = "Conatacts";
   public  static void writelist(Context context , List<String> list ){
        Gson g = new Gson();
        String jsonString = g.toJson(list);

       SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(context);
       SharedPreferences.Editor editor = s.edit();
      editor.putString(con,jsonString);
      editor.apply();
   }

   public static List<String> readList(Context context ){
       SharedPreferences s = PreferenceManager.getDefaultSharedPreferences(context);
       String jsonString = s.getString(con, " ");
      Gson gson = new Gson();
      Type type = new TypeToken<ArrayList<List>>() {}.getType();
     List<String> list = gson.fromJson(jsonString,type);
      return list;
   }


}
