package com.example.bhagwatgeeta;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class MoreAppFragment extends Fragment {
    private RecyclerView reclr_more_app;
    ArrayList<MoreAppPojo> list;
    public MoreAppFragment(ArrayList<MoreAppPojo> list) {
        this.list=list;
        // Required empty public constructor
    }
    public static MoreAppFragment newInstance(ArrayList<MoreAppPojo> text) {
        MoreAppFragment fragment = new MoreAppFragment(text);
        //
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
        return fragment;
    }





    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view =inflater.inflate(R.layout.fragment_more_app, container, false);
        reclr_more_app=view.findViewById(R.id.reclr_more_app);
        MoreAppAdapter adapter=new MoreAppAdapter(getContext(),list, new RecyclerViewOnItemClick()
        {
            @Override
            public void onItemClick(View view, int position)
            {switch(view.getId())
            {
                case R.id.card_layout:
                case R.id.btn_signin:
                    openApp(list.get(position).getOnly_id(),list.get(position).getFull_link());
                    break;
            }

            }
        });
        reclr_more_app.setAdapter(adapter);
        GridLayoutManager gridLayoutManager=new GridLayoutManager(getActivity(),2);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        reclr_more_app.setLayoutManager(gridLayoutManager);
        reclr_more_app.setItemAnimator(new DefaultItemAnimator());
        return view;
    }

    private void openApp(String appid, String applink)
    {
        Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" +appid);
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | Intent.FLAG_ACTIVITY_NEW_DOCUMENT | Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try
        {
            startActivity(goToMarket);

        } catch (ActivityNotFoundException e)
        {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(applink)));
        }
    }

}