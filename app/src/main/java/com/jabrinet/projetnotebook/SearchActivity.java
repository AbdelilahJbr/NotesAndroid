package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.List;

public class SearchActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        Button searshbutton = findViewById(R.id.searchButton);
        RadioButton notes = findViewById(R.id.notes);
        RadioButton listes = findViewById(R.id.listes);


        searshbutton.setOnClickListener(v -> {
            EditText editKey = findViewById(R.id.key);
            String key = editKey.getText().toString();
            if (key.equals("")){
                Toast.makeText(this, "Veuillez écrire la phrase a chercher!", Toast.LENGTH_SHORT).show();
            }
            else {
                String likeKey = "%"+key+"%";
                Intent intent = new Intent(v.getContext(), ResultActivity.class);
                intent.putExtra("key",likeKey);
                if (notes.isChecked()){
                    intent.putExtra("where","notes");
                    v.getContext().startActivity(intent);
                }
                else if (listes.isChecked()){
                    intent.putExtra("where","listes");
                    v.getContext().startActivity(intent);
                }
                else {
                    Toast.makeText(this, "Erreur!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }
}
