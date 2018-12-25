package com.jabrinet.projetnotebook;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ListesAdapter extends RecyclerView.Adapter<ListesAdapter.MyViewHolder> {
    private List<Liste> listeLists;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView title;

        public MyViewHolder(View view) {
            super(view);
            title = (TextView) view.findViewById(R.id.listeTitle);
        }
    }

    public ListesAdapter(List<Liste> listeLists) {
        this.listeLists = listeLists;
    }

    @Override
    public ListesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.liste_list_row, parent, false);

        return new ListesAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ListesAdapter.MyViewHolder holder, int position) {
        Liste liste = listeLists.get(position);
        holder.title.setText(liste.title);
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), ListeActivity.class);
            intent.putExtra("id",liste.id);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return listeLists.size();
    }
}
