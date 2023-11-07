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

public class AdhayayListAdapter extends RecyclerView.Adapter<AdhayayListAdapter.ViewHolder>
{
    ArrayList<ChaptersPojo> list;
    Context context;
    RecyclerViewOnItemClick mRecyclerViewOnIt;
    public AdhayayListAdapter(Context context, ArrayList<ChaptersPojo> list, RecyclerViewOnItemClick mRecyclerViewOnIt) {
        this.context = context;
        this.list=list;
        this.mRecyclerViewOnIt = mRecyclerViewOnIt;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.adhayay_list,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        ChaptersPojo chaptersPojo =list.get(position);
//        Log.i("TAG", "onBindViewHolder: "+position+","+ chaptersPojo.getChapterNo());
        holder.adhayay_txt.setText(chaptersPojo.getChapterNo());
        holder.adhayay_txt_list.setText(chaptersPojo.getChapterName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        TextView adhayay_txt,adhayay_txt_list;
        LinearLayout list_layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            adhayay_txt=itemView.findViewById(R.id.adhayay_txt);
            adhayay_txt_list=itemView.findViewById(R.id.adhayay_txt_list);
            list_layout=itemView.findViewById(R.id.list_layout);
            list_layout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mRecyclerViewOnIt.onItemClick(v,getAdapterPosition());

        }
    }
}
