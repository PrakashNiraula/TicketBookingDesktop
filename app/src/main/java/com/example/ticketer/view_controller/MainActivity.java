package com.example.ticketer.view_controller;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ticketer.R;
import com.example.ticketer.module.User;
import com.example.ticketer.module.decoder;
import com.example.ticketer.module.mapper;
import java.io.IOException;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText username, password;
    Button login;

    TextView registeruser,registerowner;
  SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        login = findViewById(R.id.btnlogin);
        registeruser=findViewById(R.id.registeruser);
        registerowner=findViewById(R.id.registerowner);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();

        StrictMode.setThreadPolicy(policy);



        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkcredentials();
            }
        });

        registeruser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class).putExtra("type","user"));
            }
        });
        registerowner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,RegisterActivity.class).putExtra("type","owner"));
            }
        });

    }

private void checkcredentials(){
    Map<String, String> map = null;
    User user = new User(username.getText().toString(), password.getText().toString());
    try {
        user.makelogin(this,user);
    } catch (IOException e) {
        e.printStackTrace();
    }
    SharedPreferences sharedPreferences=getSharedPreferences("com.example.ticketer_preferences",MODE_PRIVATE);
String token=sharedPreferences.getString("token","");
if(token.equals("")){
    Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_LONG).show();
}else{
    try {
        String decoded= decoder.decoded(token);
       map=mapper.stringmapper(decoded);
                String role=map.get("role");
        if(role.equals("admin")){
            Toast.makeText(this, "Logging in admin", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this, Routes.class).putExtra("token",token));
        }else if(role.equals("owner")){
            Toast.makeText(this, "Logging in owner", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,Routes.class).putExtra("token",token));
        }else{
            Toast.makeText(this, "Logging in user", Toast.LENGTH_LONG).show();
            startActivity(new Intent(MainActivity.this,VeiwBuses.class).putExtra("token",token));
        }
       // Toast.makeText(this, decoded, Toast.LENGTH_LONG).show();
    } catch (Exception e) {
        e.printStackTrace();
    }
}

}

}
