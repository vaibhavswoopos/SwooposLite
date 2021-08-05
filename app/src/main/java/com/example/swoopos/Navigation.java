package com.example.swoopos;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.loginapp.R;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class Navigation extends AppCompatActivity {

    NavigationView nav;
    ActionBarDrawerToggle toggle;
    DrawerLayout drawerLayout;
    RecyclerView recyclerView;

    String s1[], s2[];
    int images[] ={R.drawable.beans,R.drawable.blackbeans,R.drawable.boost,R.drawable.chillibeans,
            R.drawable.coke,R.drawable.fanta,R.drawable.drpepper,R.drawable.liq};

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);


            nav = (NavigationView) findViewById(R.id.navmenu);
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
            recyclerView = findViewById(R.id.recyclerView);




            toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close);
            drawerLayout.addDrawerListener(toggle);
            toggle.syncState();
            nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                    switch (menuItem.getItemId()) {
                        case R.id.menu_checkout:
                            Toast.makeText(getApplicationContext(), " Checkout is Open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.menu_product:
                            Toast.makeText(getApplicationContext(), "Product is Open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.menu_previous_order:
                            Toast.makeText(getApplicationContext(), "Previous Order is Open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;

                        case R.id.menu_customers:
                            Toast.makeText(getApplicationContext(), "Customers is Open", Toast.LENGTH_LONG).show();
                            drawerLayout.closeDrawer(GravityCompat.START);
                            break;
                    }

                    return true;
                }
            });
            s1 = getResources().getStringArray(R.array.products);
            s2 = getResources().getStringArray(R.array.description);

            MyAdapter myAdapter = new MyAdapter(this,s1,s2,images);
            int numberOfColumns =3;
            recyclerView.setAdapter(myAdapter);
            recyclerView.setLayoutManager(new GridLayoutManager(this,numberOfColumns));

        }
    }
}









