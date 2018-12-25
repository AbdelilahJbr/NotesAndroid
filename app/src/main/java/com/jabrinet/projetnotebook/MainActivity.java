package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);
        Button button = findViewById(R.id.loginButton);
        
        button.setOnClickListener(v -> {
            if(name.getText().toString().toLowerCase().equals("mouad") && password.getText().toString().equals("admin"))
                startActivity(new Intent(this,MenuActivity.class));
            else
                Toast.makeText(this, "Error login", Toast.LENGTH_SHORT).show();
        });
    }
}
