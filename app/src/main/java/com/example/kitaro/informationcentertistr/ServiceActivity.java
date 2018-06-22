package com.example.kitaro.informationcentertistr;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.Nullable;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.kitaro.informationcentertistr.fragment.AgFragment;
import com.example.kitaro.informationcentertistr.fragment.EnFragment;
import com.example.kitaro.informationcentertistr.fragment.FoodFragment;
import com.example.kitaro.informationcentertistr.fragment.HerbFragment;
import com.example.kitaro.informationcentertistr.fragment.MatFragment;
import com.example.kitaro.informationcentertistr.fragment.RobotFragment;
import com.example.kitaro.informationcentertistr.utility.DrawerListViewAdapter;
import com.example.kitaro.informationcentertistr.utility.MyConstant;

public class ServiceActivity extends AppCompatActivity {

    private int indexAnInt;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private MyConstant myConstant;
    private String[] titleStrings, subTitleStrings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

//        Receive Value From Main
        receiveValue();

//        Create Toolbar
        createToolbar();

//        Create DrawerMenu
        createDrawerMenu();

//        Add Fragment to Activity
        addFragment(savedInstanceState);


    }   // Main Method

    private void addFragment(Bundle savedInstanceState) {

        if (savedInstanceState == null) {
            switch (indexAnInt) {
                case 2:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new FoodFragment())
                            .commit();
                    break;
                case 4:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new MatFragment())
                            .commit();
                    break;
                case 1:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new EnFragment())
                            .commit();
                    break;
                case 5:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new RobotFragment())
                            .commit();
                    break;
                case 3:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new HerbFragment())
                            .commit();
                    break;
                case 0:
                    getSupportFragmentManager()
                            .beginTransaction()
                            .add(R.id.contentServiceFragment, new AgFragment())
                            .commit();
                    break;
            }
        }

    }

    private void createDrawerMenu() {
        ListView listView = findViewById(R.id.listViewDrawer);
        final String[] titleStrings = myConstant.getTitleDrawerStrings();
        int[] iconInts = myConstant.getIconInts();
        DrawerListViewAdapter drawerListViewAdapter = new DrawerListViewAdapter(
                ServiceActivity.this, titleStrings, iconInts);
        listView.setAdapter(drawerListViewAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (position == (titleStrings.length - 1)) {
                    //startActivity(new Intent(ServiceActivity.this, MainActivity.class));
                    finish();
                }

                drawerLayout.closeDrawers();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        actionBarDrawerToggle.onConfigurationChanged(newConfig);

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        actionBarDrawerToggle.syncState();

    }

    private void receiveValue() {
        indexAnInt = getIntent().getIntExtra("Index", 0);
        Log.d("21JuneV1", "Index ==> " + indexAnInt);
        myConstant = new MyConstant();
        titleStrings = myConstant.getTitleStrings();
        subTitleStrings = myConstant.getSubTitleStrings();
    }

    private void createToolbar() {

        Toolbar toolbar = findViewById(R.id.toolbarService);
        setSupportActionBar(toolbar);

//        Setup Title and SubTitle
        getSupportActionBar().setTitle(titleStrings[indexAnInt]);
        getSupportActionBar().setSubtitle(subTitleStrings[indexAnInt]);

//        Show Navigation Bar
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

//        Setup Toggle and Drawer
        drawerLayout = findViewById(R.id.layoutDrawer);
        actionBarDrawerToggle = new ActionBarDrawerToggle(
                ServiceActivity.this,
                drawerLayout,
                R.string.open,
                R.string.close
        );

    }
}
