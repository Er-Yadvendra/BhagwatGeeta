package com.example.bhagwatgeeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShlokHindiActivity extends AppCompatActivity {
    ViewPager view_pager;
    TabLayout tab_layout;
    Context mContext;
    String snkt,hindi,aadhay_name,aadhay_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlok_hindi);
        view_pager = findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);
        mContext=this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        aadhay_name=getIntent().getStringExtra("aadhay_name");
        aadhay_no=getIntent().getStringExtra("aadhay_no");
        toolbar.setTitle(aadhay_no+"-"+aadhay_name);
        Log.i("TAG", "onCreate: "+aadhay_name);
        setSupportActionBar(toolbar);
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<Fragment> mFragmentList = new ArrayList<>();
        Bundle bundle = getIntent().getExtras();

        List<ChaptersPojo> list = (List<ChaptersPojo>) bundle.getSerializable("valuesArray");
        int position=getIntent().getIntExtra("position", 0);
//
        for(int i=0;i<list.size();i++)
        {
//            Log.i("TAG", "onCreate: "+list.get(i).getSlockNo());
            tab_layout.addTab(tab_layout.newTab().setText(list.get(i).getSlockNo()));
            snkt=list.get(i).getSlockSanskrit();
            hindi=list.get(i).getSlockHindi();
            ShlokHindiFragment shlokHindiFragment =ShlokHindiFragment.newInstance(snkt,hindi);
            mFragmentList.add(shlokHindiFragment);
        }
        // list ke size par loop chalaoge
        // list me se slockno nikalna hai or tab layout me add krna hai
        // Fragment me ek 2 text view or list me se sanshindi
        // tab layout ke sath fregment me add kr dena







        BhagbatGeetaAdapter bhagbatGeetaAdapter = new BhagbatGeetaAdapter(getSupportFragmentManager(), mFragmentList);

        tab_layout.setTabGravity(tab_layout.GRAVITY_FILL);
//        tab_layout.setTabGravity(tab_layout.GRAVITY_CENTER);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);

        view_pager.setAdapter(bhagbatGeetaAdapter);
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));

        view_pager.setCurrentItem(position);
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                view_pager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }

}

