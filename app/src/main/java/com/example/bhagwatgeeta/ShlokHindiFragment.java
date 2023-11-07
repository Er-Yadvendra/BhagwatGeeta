package com.example.bhagwatgeeta;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShlokHindiFragment extends Fragment {
TextView frg_shlok_hindi,frg_shlok_Snkt;
    private String snkt_text,hindi_text;

    public ShlokHindiFragment(String snkt_text,String hindi_text) {
        this.snkt_text=snkt_text;
        this.hindi_text=hindi_text;
        // Required empty public constructor
    }


    public static ShlokHindiFragment newInstance(String snkt_text,String hindi_text) {
        ShlokHindiFragment fragment = new ShlokHindiFragment(snkt_text,hindi_text);

        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_shlok_hindi, container, false);
        frg_shlok_hindi=view.findViewById(R.id.frg_shlok_hindi);
        frg_shlok_Snkt=view.findViewById(R.id.frg_shlok_Snkt);
        frg_shlok_Snkt.setText(snkt_text);
        frg_shlok_hindi.setText(hindi_text);
        return view;
    }
}