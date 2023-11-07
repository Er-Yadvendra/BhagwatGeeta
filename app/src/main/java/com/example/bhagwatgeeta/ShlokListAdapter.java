package com.example.bhagwatgeeta;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ShlokListAdapter extends RecyclerView.Adapter<ShlokListAdapter.ViewHolder> {
    ArrayList<ChaptersPojo> list;
    Context context;
    RecyclerViewOnItemClick mRecyclerViewOnIt;

    public ShlokListAdapter(Context context, ArrayList<ChaptersPojo> list,RecyclerViewOnItemClick mRecyclerViewOnIt) {
        this.list = list;
        this.context=context;
        this.mRecyclerViewOnIt = mRecyclerViewOnIt;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.shlok_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ChaptersPojo chaptersPojo =list.get(position);
        holder.shlok_txt.setText(chaptersPojo.getSlockNo());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView shlok_txt;
        LinearLayout shlok_list_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            shlok_txt=itemView.findViewById(R.id.shlok_txt);
            shlok_list_layout=itemView.findViewById(R.id.shlok_list_layout);
            shlok_list_layout.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mRecyclerViewOnIt.onItemClick(v,getAdapterPosition());
        }
    }
}
