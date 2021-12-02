package com.example.ticketer_wear;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText uname,pass;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        uname=findViewById(R.id.uname);
        pass=findViewById(R.id.pass);
        login=findViewById(R.id.btnloginwear);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(uname.getText().toString().equals("admin") && pass.getText().toString().equals("admin")){
                    startActivity(new Intent(MainActivity.this,Dashboard.class));
                }

            }
        });
    }
}