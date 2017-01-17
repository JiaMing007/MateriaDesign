package com.itxiaoming.materialdesign;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.itxiaoming.materialdesign.Adapter.ImageAdapter;
import com.itxiaoming.materialdesign.utils.IamgeLoad;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private DrawerLayout mDrawLayout;
    private NavigationView navigationView;
    private FloatingActionButton fabButton;
    private SwipeRefreshLayout swipeRefreshLayout;

    private IamgeLoad[] images = {
      new IamgeLoad("image",R.drawable.image1),new IamgeLoad("image",R.drawable.image2),
      new IamgeLoad("image",R.drawable.image18),new IamgeLoad("image",R.drawable.image3),
      new IamgeLoad("image",R.drawable.image17),new IamgeLoad("image",R.drawable.image4),
      new IamgeLoad("image",R.drawable.image16),new IamgeLoad("image",R.drawable.image5),
      new IamgeLoad("image",R.drawable.image15),new IamgeLoad("image",R.drawable.image6),
      new IamgeLoad("image",R.drawable.image14),new IamgeLoad("image",R.drawable.image7),
      new IamgeLoad("image",R.drawable.image13),new IamgeLoad("image",R.drawable.image8),
      new IamgeLoad("image",R.drawable.image12),new IamgeLoad("image",R.drawable.image9),
      new IamgeLoad("image",R.drawable.image11),new IamgeLoad("image",R.drawable.image10)};
    private List<IamgeLoad> mLists = new ArrayList<>();
    private ImageAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initIamge();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        mAdapter = new ImageAdapter(mLists);
        recyclerView.setAdapter(mAdapter);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        mDrawLayout = (DrawerLayout) findViewById(R.id.drawLayout);
        navigationView = (NavigationView) findViewById(R.id.nav_view);
        fabButton = (FloatingActionButton) findViewById(R.id.fabButton);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.mipmap.ic_top_bar_category);
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //下拉刷新
                refreshIamge();
            }
        });
        fabButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view,"Data Delete",Snackbar.LENGTH_SHORT)
                        .setAction("Undo", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(MainActivity.this,"i am clicked",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .show();
            }
        });
        navigationView.setCheckedItem(R.id.nav_call);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                mDrawLayout.closeDrawers();
                return true;
            }
        });

    }

    //下拉刷新
    private void refreshIamge() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        initIamge();
                        mAdapter.notifyDataSetChanged();
                        swipeRefreshLayout.setRefreshing(false);
                    }
                });
            }
        }).start();
    }

    //初始化数据
    private void initIamge() {
        mLists.clear();
        for(int i=0;i<50;i++){
            Random random = new Random();
            int index = random.nextInt(images.length);
            mLists.add(images[index]);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case android.R.id.home:
                mDrawLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.backup:
                Toast.makeText(MainActivity.this,"you clicked Backup",Toast.LENGTH_SHORT).show();
                break;
            case R.id.delete:
                Toast.makeText(MainActivity.this,"you clicked Delete",Toast.LENGTH_SHORT).show();
                break;
            case R.id.settingss:
                Toast.makeText(MainActivity.this,"you clicked Settings",Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
