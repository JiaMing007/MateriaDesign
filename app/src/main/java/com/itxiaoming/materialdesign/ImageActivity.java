package com.itxiaoming.materialdesign;

import android.content.Intent;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class ImageActivity extends AppCompatActivity {

    public static final String IMAGE_NAME = "image_name";
    public static final String IMAGE_ID = "image_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image);
        Intent intent = getIntent();
        String imageName = intent.getStringExtra(IMAGE_NAME);
        int imageId = intent.getIntExtra(IMAGE_ID, 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout)
                                    findViewById(R.id.collToolLayout);
        ImageView mImageView = (ImageView) findViewById(R.id.image_view);
        TextView mImageContent = (TextView) findViewById(R.id.imageContent);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDefaultDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(imageName);
        Glide.with(this).load(imageId).into(mImageView);
        String imageContent = generateImageContent(imageName);
        mImageContent.setText(imageContent);
    }
    //根据图片名称来获取图片的详情展示页
    private String generateImageContent(String imageName) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<500;i++){
            sb.append(imageName);
        }
        return sb.toString();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
