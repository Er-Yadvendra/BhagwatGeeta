package com.example.bhagwatgeeta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class ShlokFragment extends Fragment {

   RecyclerView recycl_shlok_list;
    ArrayList<ChaptersPojo> list;
    Context mContext;
    private String aadhay_name,aadhay_no;

    public ShlokFragment(ArrayList<ChaptersPojo> list, String aadhay_no,String aadhay_name)
    {
        this.list=list;
        this.aadhay_no =aadhay_no;
        this.aadhay_name=aadhay_name;
    }


    public static ShlokFragment newInstance(ArrayList<ChaptersPojo> text, String aadhay_no, String aadhay_name) {
        ShlokFragment fragment = new ShlokFragment(text,aadhay_no,aadhay_name);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        View view =inflater.inflate(R.layout.fragment_shlok, container, false);
        recycl_shlok_list=view.findViewById(R.id.recycl_shlok_list);
//        ((ShlokActivity) getActivity()).getSupportActionBar().setTitle(aadhay_name);
//        String temp_aadhay_name =((ShlokActivity) getActivity()).getSupportActionBar().getTitle().toString();

        ShlokListAdapter shlokListAdapter=new ShlokListAdapter(getContext(), list, new RecyclerViewOnItemClick() {
            @Override
            public void onItemClick(View view, int position)
            {
//                Toast.makeText(getContext(),"position"+position,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),ShlokHindiActivity.class);
                // list send
                // send position
                intent.putExtra("position",position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("valuesArray",list);
                intent.putExtras(bundle);
                intent.putExtra("aadhay_no",aadhay_no);
                intent.putExtra("aadhay_name",aadhay_name);
//                Log.i("TAG", "onCreate: "+aadhay_name);
                Log.i("TAG", "on click : "+((ShlokActivity) getActivity()).getSupportActionBar().getTitle());
                getContext().startActivity(intent);
            }
        });
        recycl_shlok_list.setAdapter(shlokListAdapter);
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        recycl_shlok_list.setLayoutManager(linearLayoutManager);
        return view;
    }
}