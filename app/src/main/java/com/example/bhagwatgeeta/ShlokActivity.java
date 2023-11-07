package com.example.bhagwatgeeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.app.ActionBar;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.tabs.TabLayout;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class ShlokActivity extends AppCompatActivity {
    ViewPager view_pager;
    TabLayout tab_layout;
    Context mContext;
    String aadhay_name;

//    private static final String TAG = "ShlokActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shlok);
        view_pager = findViewById(R.id.view_pager);
        tab_layout = findViewById(R.id.tab_layout);
        mContext=this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("Adhayaylist"));
        setSupportActionBar(toolbar);
        ActionBar actionBar=getActionBar();
//        aadhay_name=
        Bundle bundle = getIntent().getExtras();

        List<ChaptersPojo> list = (List<ChaptersPojo>) bundle.getSerializable("valuesArray");
        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        List<Fragment> mFragmentList = new ArrayList<>();
        int position=getIntent().getIntExtra("position", 0);
        // position nikalo
        // tab selected position set kar do


//            aadhay_name = list.get(j).getChapterName();
        
        for (int i = 1; i <= 18; i++)
        {

            String aadhay_no = "अध्याय" + " " + i;
            tab_layout.addTab(tab_layout.newTab().setText(aadhay_no));
            ArrayList<ChaptersPojo> slocksList = new ArrayList<>();

            try
            {
                Gson gson = new Gson();
                String jsonOutput = readJSONFromAsset(i);
                Type listType = new TypeToken<List<ChaptersPojo>>(){}.getType();
                slocksList = gson.fromJson(jsonOutput, listType);
//                Log.i(TAG, "onCreate: "+slocksList.size());

            } catch (Exception e)
            {
                e.printStackTrace();
            }

            ShlokFragment shlokFragment = ShlokFragment.newInstance(slocksList,aadhay_no, list.get(i-1).getChapterName());
            mFragmentList.add(shlokFragment);
        }
        BhagbatGeetaAdapter bhagbatGeetaAdapter = new BhagbatGeetaAdapter(getSupportFragmentManager(), mFragmentList);

        tab_layout.setTabGravity(tab_layout.GRAVITY_FILL);
//        tab_layout.setTabGravity(tab_layout.GRAVITY_CENTER);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        view_pager.setAdapter(bhagbatGeetaAdapter);
        view_pager.setCurrentItem(position);
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
        tab_layout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {
                int position1 = tab.getPosition();
                toolbar.setTitle(list.get(position1).getChapterName());
                view_pager.setCurrentItem(position1);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

    }

    public String readJSONFromAsset(int i)
    {
        String json = null;
            try
            {
                InputStream is = mContext.getAssets().open("chapter_" + i + ".json");
                int size = is.available();
                byte[] buffer = new byte[size];
                is.read(buffer);
                is.close();
                json = new String(buffer, "UTF-8");
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return json;

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        if(item.getItemId() == android.R.id.home)
            finish();
        return super.onOptionsItemSelected(item);
    }
}
