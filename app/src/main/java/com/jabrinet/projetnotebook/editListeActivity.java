package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editListeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_liste);

        EditText title = findViewById(R.id.title);
        EditText item1 =findViewById(R.id.item1);
        EditText item2 =findViewById(R.id.item2);
        EditText item3 =findViewById(R.id.item3);
        EditText item4 =findViewById(R.id.item4);
        EditText item5 =findViewById(R.id.item5);
        Button button = findViewById(R.id.editButton);

        int id = getIntent().getIntExtra("id",-1);

        ListeDAO listeDao = NoteDataBase.getDatabase(this).ListeDAO();
        Liste liste = listeDao.selectListeById(id);
        if (liste != null){
            title.setText(liste.title);
            item1.setText(liste.item1);
            item2.setText(liste.item2);
            item3.setText(liste.item3);
            item4.setText(liste.item4);
            item5.setText(liste.item5);
        }

        button.setOnClickListener(v -> {
            EditText newtitle = findViewById(R.id.title);
            EditText newitem1 =findViewById(R.id.item1);
            EditText newitem2 =findViewById(R.id.item2);
            EditText newitem3 =findViewById(R.id.item3);
            EditText newitem4 =findViewById(R.id.item4);
            EditText newitem5 =findViewById(R.id.item5);
            if (newtitle.getText().toString().equals("")){
                Toast.makeText(this, "Veuillez remplir le titre!", Toast.LENGTH_SHORT).show();
            }
            else {
                listeDao.modifyListe(id, title.getText().toString(), newitem1.getText().toString(), newitem2.getText().toString(), newitem3.getText().toString(), newitem4.getText().toString(), newitem5.getText().toString());
                Intent intent = new Intent(v.getContext(), ListesActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
