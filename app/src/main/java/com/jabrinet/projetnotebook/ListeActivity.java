package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liste);

        TextView title =findViewById(R.id.title);
        TextView item1 =findViewById(R.id.item1);
        TextView item2 =findViewById(R.id.item2);
        TextView item3 =findViewById(R.id.item3);
        TextView item4 =findViewById(R.id.item4);
        TextView item5 =findViewById(R.id.item5);
        Button editButton = findViewById(R.id.editButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        int id = getIntent().getIntExtra("id",-1);

        ListeDAO listeDao = NoteDataBase.getDatabase(this).ListeDAO();
        Liste liste = listeDao.selectListeById(id);
        if (liste != null){
            title.setText(liste.title);
            item1.setText(liste.item1);
            item1.setText(liste.item2);
            item1.setText(liste.item3);
            item1.setText(liste.item4);
            item1.setText(liste.item5);
        }
        else{
            Toast.makeText(this, "Liste not found", Toast.LENGTH_SHORT).show();
        }

        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), editListeActivity.class);
            intent.putExtra("id",liste.id);
            v.getContext().startActivity(intent);
        });

        deleteButton.setOnClickListener(v -> {
            listeDao.deleteListe(id);
            startActivity(new Intent(this,ListesActivity.class));
        });
    }
}
