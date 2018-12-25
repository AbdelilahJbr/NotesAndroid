package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

public class NotesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);

        mRecyclerView = (RecyclerView) findViewById(R.id.notes_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        NoteDAO noteDao = NoteDataBase.getDatabase(this).NoteDAO();
        List<Note> notesDataset = noteDao.listNotes();

        mAdapter = new NotesAdapter(notesDataset);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.addNote);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(this,AddNoteActivity.class));
        });
    }
}
