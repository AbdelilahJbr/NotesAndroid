package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        EditText title = findViewById(R.id.title);
        EditText content = findViewById(R.id.content);
        Button button = findViewById(R.id.addButton);

        button.setOnClickListener(v -> {
            if (title.getText().toString().equals("") || content.getText().toString().equals("")){
                Toast.makeText(this, "Veuillez remplir le titre et le contenu!", Toast.LENGTH_SHORT).show();
            }
            else {
                NoteDAO noteDao = NoteDataBase.getDatabase(this).NoteDAO();
                Note note = new Note();
                note.titre = title.getText().toString();
                note.content = content.getText().toString();
                noteDao.insertNote(note);
                Intent intent = new Intent(v.getContext(), NotesActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
