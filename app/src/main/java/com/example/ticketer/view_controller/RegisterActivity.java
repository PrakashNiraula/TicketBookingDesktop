package com.example.ticketer.view_controller;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ticketer.R;
import com.example.ticketer.module.User;

public class RegisterActivity extends AppCompatActivity {

    EditText fname, lname, phone, email, username, password;
    Button btnregister;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        btnregister = findViewById(R.id.btnregister);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registeruser();
            }
        });
    }


    private void registeruser() {


        User user = new User(username.getText().toString(), password.getText().toString());
        user.setFname(fname.getText().toString());
        user.setLname(lname.getText().toString());
        user.setEmail(email.getText().toString());
        user.setPhone(phone.getText().toString());
        Bundle bundle = getIntent().getExtras();

        if (bundle.getString("type").equals("owner")) {
            user.setRole("owner");
        } else {
            user.setRole("user");
        }

       User response=user.registeruser(user);
        if(response!=null)
        {
            Toast.makeText(this,"Success",Toast.LENGTH_LONG).show();
        }





    }
}
