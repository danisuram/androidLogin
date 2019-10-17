package com.example.login;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;
    private static String KEY_EMAIL = "EMAIL";
    private static String KEY_PASS = "PASSWORD";

    static void setContext(Context context){
        sharedPreferences = context.getSharedPreferences("LOGIN", Context.MODE_PRIVATE);
    }

    public static void actionLogin(String email, String password){

        editor = sharedPreferences.edit();
        editor.putString(KEY_EMAIL, email);
        editor.putString(KEY_PASS, password);
        editor.apply();
    }

    public static void actionLogout(){
        editor = sharedPreferences.edit();
        editor.clear().apply();
    }

    public static String getEmail(){
        return sharedPreferences.getString(KEY_EMAIL, null);
    }

    public static String getPassword(){
        return sharedPreferences.getString(KEY_PASS, null);
    }

}