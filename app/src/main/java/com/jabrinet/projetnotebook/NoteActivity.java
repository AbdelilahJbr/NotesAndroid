package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        TextView title =findViewById(R.id.title);
        TextView content =findViewById(R.id.content);
        Button editButton = findViewById(R.id.editButton);
        Button deleteButton = findViewById(R.id.deleteButton);

        int id = getIntent().getIntExtra("id",-1);

        NoteDAO noteDao = NoteDataBase.getDatabase(this).NoteDAO();
        Note note = noteDao.selectNoteById(id);
        if (note != null){
            title.setText(note.titre);
            content.setText(note.content);
        }
        else{
            Toast.makeText(this, "Note not found", Toast.LENGTH_SHORT).show();
        }

        editButton.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), editNoteActivity.class);
            intent.putExtra("id",note.id);
            v.getContext().startActivity(intent);
        });

        deleteButton.setOnClickListener(v -> {
            noteDao.deleteNote(id);
            startActivity(new Intent(this,NotesActivity.class));
        });

    }
}
