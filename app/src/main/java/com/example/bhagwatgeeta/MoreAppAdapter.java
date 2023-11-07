package com.example.bhagwatgeeta;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MoreAppAdapter extends RecyclerView.Adapter<MoreAppAdapter.ViewHolder> {

    ArrayList<MoreAppPojo> list;
    Context mContext;
    RecyclerViewOnItemClick mRecyclerViewOnItemClick;


    public MoreAppAdapter(Context mContext, ArrayList<MoreAppPojo> list, RecyclerViewOnItemClick mRecyclerViewOnItemClick)
    {
        this.list = list;
        this.mContext = mContext;
        this.mRecyclerViewOnItemClick = mRecyclerViewOnItemClick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {

        View view= LayoutInflater.from(mContext).inflate(R.layout.more_app_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        MoreAppPojo moreAppPojo=list.get(position);

        holder.card_img.setImageResource(moreAppPojo.getPic());
        holder.card_text.setText(moreAppPojo.getText());
        holder.rating_bar.setRating((float) moreAppPojo.getRating());
//        Picasso.get().load(Newspojo.).fit().centerInside().into(holder.img_view);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView card_text;
        ImageView card_img;
        RatingBar rating_bar;
        Button btn_signin;
        LinearLayout card_layout;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            card_text=itemView.findViewById(R.id.card_text);
            card_img=itemView.findViewById(R.id.card_img);
            card_layout=itemView.findViewById(R.id.card_layout);
            rating_bar=itemView.findViewById(R.id.rating_bar);
            btn_signin=itemView.findViewById(R.id.btn_signin);
            card_layout.setOnClickListener(this);
            btn_signin.setOnClickListener(this);

        }

        @Override
        public void onClick(View v)
        {
            mRecyclerViewOnItemClick.onItemClick(v,getAdapterPosition());
        }
    }
}
