package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

import java.lang.annotation.Target;

public class HomePage extends AppCompatActivity {

    private TabLayout tablayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        tablayout = findViewById(R.id.tablayout);
        viewPager = findViewById(R.id.viewpager);

        tablayout.setupWithViewPager(viewPager);

        VPAdapter vpAdapter = new VPAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        vpAdapter.addFragments(new PushFragment(),"PUSH");
        vpAdapter.addFragments(new PullFragment(),"PULL");
        vpAdapter.addFragments(new LegFragment(),"LEGS");
        vpAdapter.addFragments(new PlaylistFragment(),"PLAYLIST");
        viewPager.setAdapter(vpAdapter);

    }
}