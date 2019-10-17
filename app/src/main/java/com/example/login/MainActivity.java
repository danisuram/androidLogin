package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Preferences.setContext(MainActivity.this);
        String email = Preferences.getEmail();
        String password = Preferences.getPassword();
        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(password)){
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }else{
            Toast.makeText(this,"Selamat Datang" + email, Toast.LENGTH_SHORT).show();
        }

        btnLogout = findViewById(R.id.btnLogout);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Preferences.setContext(MainActivity.this);
                Preferences.actionLogout();
                startActivity((new Intent(MainActivity.this, LoginActivity.class)));
                finish();

            }
        });
    }
}
