
package com.example.bhagwatgeeta;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;

public class AdhyayFragment extends Fragment {


    private String  text;
//    TextView textView;

    ArrayList<ChaptersPojo> list;
    RecyclerView adhyay_recy_view;

    public AdhyayFragment(ArrayList<ChaptersPojo> list) {
        this.list=list;
//        this.mContext=mContext;
        // Required empty public constructor
    }
    public static AdhyayFragment newInstance(ArrayList<ChaptersPojo> text) {
        AdhyayFragment fragment = new AdhyayFragment(text);
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
        View view= inflater.inflate(R.layout.fragment_adhyay, container, false);
        adhyay_recy_view=view.findViewById(R.id.adhyay_recy_view);

//        textView.setText((CharSequence) textView);


        AdhayayListAdapter adhayayListAdapter=new AdhayayListAdapter(getActivity(),list, new RecyclerViewOnItemClick() {
            @Override
            public void onItemClick(View view, int position)
            {
                // position =  recy view pos
                Toast.makeText(getContext(),"position"+position,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getContext(),ShlokActivity.class);
                intent.putExtra("Adhayaylist",list.get(position).getChapterName());
                // click position
                intent.putExtra("position",position);
                Bundle bundle = new Bundle();
                bundle.putSerializable("valuesArray",list);
                intent.putExtras(bundle);
                getContext().startActivity(intent);
                // open activity using intent
                // set data list.get(position);
                //
            }
        });
        adhyay_recy_view.setAdapter(adhayayListAdapter);
//        Log.i("TAG,", "onCreateView: "+list);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getActivity());
        adhyay_recy_view.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}