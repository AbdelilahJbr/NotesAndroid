package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button notebutton = findViewById(R.id.noteButton);
        Button listbutton = findViewById(R.id.listButton);
        Button corbeillebutton = findViewById(R.id.corbeilleButton);
        /*Button searchbutton = findViewById(R.id.searchButton);*/

        notebutton.setOnClickListener(v -> {
            startActivity(new Intent(this,NotesActivity.class));
        });

        listbutton.setOnClickListener(v -> {
            startActivity(new Intent(this,ListesActivity.class));
        });

        corbeillebutton.setOnClickListener(v -> {
            startActivity(new Intent(this,TrashsActivity.class));
        });

        /*searchbutton.setOnClickListener(v -> {
            startActivity(new Intent(this,SearchActivity.class));
        });*/
    }
}
