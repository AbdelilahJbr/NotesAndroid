package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class editNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_note);

        EditText title = findViewById(R.id.title);
        EditText content = findViewById(R.id.content);
        Button button = findViewById(R.id.editButton);

        int id = getIntent().getIntExtra("id",-1);

        NoteDAO noteDao = NoteDataBase.getDatabase(this).NoteDAO();
        Note note = noteDao.selectNoteById(id);
        if (note != null){
            title.setText(note.titre);
            content.setText(note.content);
        }

        button.setOnClickListener(v -> {
            EditText newtitle = findViewById(R.id.title);
            EditText newcontent = findViewById(R.id.content);
            if (newtitle.getText().toString().equals("") || newcontent.getText().toString().equals("")){
                Toast.makeText(this, "Veuillez remplir le titre et le contenu!", Toast.LENGTH_SHORT).show();
            }
            else {
                noteDao.modifyNote(id, newtitle.getText().toString(), newcontent.getText().toString());
                Intent intent = new Intent(v.getContext(), NotesActivity.class);
                v.getContext().startActivity(intent);
            }
        });
    }
}
