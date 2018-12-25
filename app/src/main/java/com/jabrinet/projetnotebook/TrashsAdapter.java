package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class TrashsAdapter extends RecyclerView.Adapter<TrashsAdapter.MyViewHolder> {
    private List<Liste> listeLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.trashTitle);
        }
    }

    public TrashsAdapter(List<Liste> listeLists) {
        this.listeLists = listeLists;
    }

    @Override
    public TrashsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.trash_list_row, parent, false);

        return new TrashsAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(TrashsAdapter.MyViewHolder holder, int position) {
        Liste liste = listeLists.get(position);
        holder.title.setText(liste.title);
        holder.itemView.setOnLongClickListener(v -> {
            int id = liste.id;
            ListeDAO listeDao = NoteDataBase.getDatabase(v.getContext()).ListeDAO();
            listeDao.unDeleted(id);
            Intent intent = new Intent(v.getContext(), TrashsActivity.class);
            v.getContext().startActivity(intent);
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return listeLists.size();
    }
}
