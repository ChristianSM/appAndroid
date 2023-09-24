package com.example.appprueba;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appprueba.databinding.ActivityNavigationBinding;

import java.util.HashMap;
import java.util.Map;

public class NavigationActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityNavigationBinding binding;

    private NavController navController;
    private Map<String, String> fragmentLeido = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        darValorMap();
        binding = ActivityNavigationBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarNavigation.toolbar);
        binding.appBarNavigation.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow, R.id.item)
                .setOpenableLayout(drawer)
                .build();
        navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);


        // **********************************************************

        //Controla los eventos del group
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navigation, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_navigation);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            if (fragmentLeido.get("Fragment1").equals("0")){
                fragmentLeido.put("Fragment1", "1");
            }
            Toast.makeText(NavigationActivity.this, "Has pulsado el primer fragment", Toast.LENGTH_SHORT).show();
            NavigationUI.onNavDestinationSelected(item, navController);
        }else if(id == R.id.nav_gallery){
            if(fragmentLeido.get("Fragment1").equals("0")){
                Toast.makeText(NavigationActivity.this, "Debe leer primero el primer fragment", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(NavigationActivity.this, "Has pulsado el segundo fragment", Toast.LENGTH_SHORT).show();
                fragmentLeido.put("Fragment2", "1");
                NavigationUI.onNavDestinationSelected(item, navController);
            }

        }else if(id == R.id.nav_slideshow){
            if(fragmentLeido.get("Fragment2").equals("0")){
                Toast.makeText(NavigationActivity.this, "Debe leer primero el segundo fragment", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(NavigationActivity.this, "Has pulsado el tercer fragment", Toast.LENGTH_SHORT).show();
                fragmentLeido.put("Fragment3", "1");
                NavigationUI.onNavDestinationSelected(item, navController);
            }

        }else if(id == R.id.item){
            Toast.makeText(NavigationActivity.this, "Has pulsado ITEM", Toast.LENGTH_SHORT).show();
            NavigationUI.onNavDestinationSelected(item, navController);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void darValorMap(){
        fragmentLeido.put("Fragment1", "0");
        fragmentLeido.put("Fragment2", "0");
        fragmentLeido.put("Fragment3", "0");
        fragmentLeido.put("Fragment4", "0");
        fragmentLeido.put("Fragment5", "0");
    }

}