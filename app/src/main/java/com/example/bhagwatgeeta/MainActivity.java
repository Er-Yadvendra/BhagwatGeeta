package com.example.bhagwatgeeta;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager view_pager;
    TabLayout tab_layout;
    Context context;
    RecyclerView adhyay_recy_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context=this;
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("भगवत गीता");
        setSupportActionBar(toolbar);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        view_pager=findViewById(R.id.view_pager);
        tab_layout=findViewById(R.id.tab_layout);
        List<Fragment> mFragmentList = new ArrayList<>();
        tab_layout.addTab(tab_layout.newTab().setText("अध्याय"));
        tab_layout.addTab(tab_layout.newTab().setText("अन्य ऐप्स "));
        ArrayList<MoreAppPojo> applist=new ArrayList<>();
        applist.add(new MoreAppPojo(R.drawable.app0,getResources().getString(R.string.app0),getResources().getString(R.string.link0),getResources().getString(R.string.id0), 4.5f));
        applist.add(new MoreAppPojo(R.drawable.app2,getResources().getString(R.string.app2),getResources().getString(R.string.link2),getResources().getString(R.string.id2),5));
        applist.add(new MoreAppPojo(R.drawable.app3,getResources().getString(R.string.app3),getResources().getString(R.string.link3),getResources().getString(R.string.id3),5));



        // List
        ArrayList<ChaptersPojo> list=new ArrayList<>();
        list.add(new ChaptersPojo("अध्याय 1"," कुरुक्षेत्र के युद्धस्थल में सैन्य  निरीक्षण","","" ));
        list.add(new ChaptersPojo("अध्याय 2","गीता का सार ","",""));
        list.add(new ChaptersPojo("अध्याय 3","कर्मयोग ","",""));
        list.add(new ChaptersPojo("अध्याय 4" ,"दिव्या ज्ञान ","",""));
        list.add(new ChaptersPojo("अध्याय 5","कर्मयोग-कृष्णभावनाभावित कर्म","",""));
        list.add(new ChaptersPojo("अध्याय 6","ध्यानयोग ","",""));
        list.add(new ChaptersPojo("अध्याय 7"," भगवद्ज्ञान","",""));
        list.add(new ChaptersPojo("अध्याय 8","भगवत्प्राप्ति","",""));
        list.add(new ChaptersPojo("अध्याय 9","परम गुह्य ज्ञान","",""));
        list.add(new ChaptersPojo("अध्याय 10","श्री भगवान का ऐश्वर्य ","",""));
        list.add(new ChaptersPojo("अध्याय 11"," विराट रूप ","",""));
        list.add(new ChaptersPojo("अध्याय 12"," भक्ति योग  ","",""));
        list.add(new ChaptersPojo("अध्याय 13"," प्रकृति,पुरुष तथा चेतना","",""));
        list.add(new ChaptersPojo("अध्याय 14"," प्रकृति के तीन गुण","",""));
        list.add(new ChaptersPojo("अध्याय 15"," पुरुषोतम योग","",""));
        list.add(new ChaptersPojo("अध्याय 16"," देवी तथा आसुरी स्वभाव","",""));
        list.add(new ChaptersPojo("अध्याय 17","श्रद्धा के विभाग ","",""));
        list.add(new ChaptersPojo("अध्याय 18","उपसंहार-सन्यास की सिद्धि ","",""));
        // add.(aadhaya1 - "name");
        AdhyayFragment fragment = AdhyayFragment.newInstance(list);
        mFragmentList.add(fragment);
        MoreAppFragment fragment1 = MoreAppFragment.newInstance(applist);
        mFragmentList.add(fragment1);

        BhagbatGeetaAdapter bhagbatGeetaAdapter=new BhagbatGeetaAdapter(getSupportFragmentManager(),mFragmentList);

        tab_layout.setTabGravity(tab_layout.GRAVITY_FILL);
//        tab_layout.setTabGravity(tab_layout.GRAVITY_CENTER);
        tab_layout.setTabMode(TabLayout.MODE_SCROLLABLE);
        view_pager.setAdapter(bhagbatGeetaAdapter);
        view_pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tab_layout));
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
//        adhyay_recy_view=findViewById(R.id.adhyay_recy_view);
////        textView.setText((CharSequence) textView);
//
//
//        AdhayayListAdapter adhayayListAdapter=new AdhayayListAdapter(context,list, new RecyclerViewOnItemClick() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//            }
//        });
//        adhyay_recy_view.setAdapter(adhayayListAdapter);
//        Log.i("TAG", "onCreateView: "+list);
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(context);
//        adhyay_recy_view.setLayoutManager(linearLayoutManager);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
//                Log.i("TAG", "onNavigationItemSelected: ");
                if (id == R.id.nav_home)
                {

                }

//
                else if (id == R.id.nav_rating)
                {
                rateMe();
                } else if (id == R.id.nav_share)
                {
                    Intent shareIntent = new Intent();
                    shareIntent.setAction(Intent.ACTION_SEND);
                    shareIntent.putExtra(Intent.EXTRA_TEXT,"https://play.google.com/store/details?id_h1");
                    shareIntent.setType("text/plain");
                    startActivity(Intent.createChooser(shareIntent,"share via"));
                } else if (id == R.id.nav_privacy)
                {
                Intent intent=new Intent(MainActivity.this,PrivacyPolicyActivity.class);
                startActivity(intent);
                }
                else if (id == R.id.nav_exit)
                {
                    finish();
                }
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }
    public void rateMe()
    {
        String url="com.quotesinhindi.motivationalquotesinhindi";
        try {

            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id="+url+ getPackageName())));
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id="+url + getPackageName())));
        }
    }

}