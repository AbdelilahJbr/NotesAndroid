package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AddListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_liste);

        EditText title = findViewById(R.id.title);
        EditText item1 =findViewById(R.id.item1);
        EditText item2 =findViewById(R.id.item2);
        EditText item3 =findViewById(R.id.item3);
        EditText item4 =findViewById(R.id.item4);
        EditText item5 =findViewById(R.id.item5);
        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(v -> {
            if (title.getText().toString().equals("")){
                Toast.makeText(this, "Veuillez remplir le titre!", Toast.LENGTH_SHORT).show();
            }
            else {
                ListeDAO listeDao = NoteDataBase.getDatabase(this).ListeDAO();
                Liste liste = new Liste();
                liste.title = title.getText().toString();
                liste.item1 = item1.getText().toString();
                liste.item2 = item2.getText().toString();
                liste.item3 = item3.getText().toString();
                liste.item4 = item4.getText().toString();
                liste.item5 = item5.getText().toString();
                listeDao.insertListe(liste);
                Intent intent = new Intent(v.getContext(), ListesActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
