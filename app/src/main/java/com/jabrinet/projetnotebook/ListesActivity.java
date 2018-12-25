package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ListesActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lists);

        mRecyclerView = (RecyclerView) findViewById(R.id.listes_recycler_view);

        mRecyclerView.setHasFixedSize(true);

        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ListeDAO listeDao = NoteDataBase.getDatabase(this).ListeDAO();
        List<Liste> listesDataset = listeDao.listListes();

        mAdapter = new ListesAdapter(listesDataset);
        mRecyclerView.setAdapter(mAdapter);

        FloatingActionButton fab = findViewById(R.id.addListe);
        fab.setOnClickListener(v -> {
            startActivity(new Intent(this,AddListeActivity.class));
        });
    }
}
