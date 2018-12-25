package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import static android.support.v4.content.ContextCompat.startActivity;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.MyViewHolder> {
    private List<Note> noteLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.noteTitle);
        }
    }

    public NotesAdapter(List<Note> noteLists) {
        this.noteLists = noteLists;
    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.note_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Note note = noteLists.get(position);
        holder.title.setText(note.titre);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), NoteActivity.class);
            intent.putExtra("id",note.id);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return noteLists.size();
    }
}
