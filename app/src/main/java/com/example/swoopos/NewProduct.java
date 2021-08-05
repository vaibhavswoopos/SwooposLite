package com.example.swoopos;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.example.loginapp.R;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.io.FileNotFoundException;
import java.io.IOException;

public class NewProduct extends AppCompatActivity {

    private static final String TAG ="Ftab1";

    TabLayout tabLayout;
    TabItem tabItem1, tabItem2;
    ViewPager viewPager;
    TextView textView;
    PageAdapter pageAdapter;
    RadioGroup radioGroup;
    RadioButton radioButton;
    int SELECT_PHOTO = 1;
    Integer REQUEST_CAMERA = 1, SELECT_FILE = 0;
    Uri uri;
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);
        Ftab1 ftab1 = new Ftab1();
        FragmentManager fm = getSupportFragmentManager();
        fm.beginTransaction().add(R.id.mainLayout,ftab1,"Ftab1").commit();



        tabLayout = (TabLayout) findViewById(R.id.tablayout1);
        tabItem1 = (TabItem) findViewById(R.id.tab1);
        tabItem2 = (TabItem) findViewById(R.id.tab2);
        viewPager = (ViewPager) findViewById(R.id.vpager);
        textView = findViewById(R.id.textView7);
        imageView = findViewById(R.id.image);

        pageAdapter = new PageAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(pageAdapter);

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());

                if (tab.getPosition()==0 || tab.getPosition()==1 ||tab.getPosition()==2)
                    pageAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));


    }
}










