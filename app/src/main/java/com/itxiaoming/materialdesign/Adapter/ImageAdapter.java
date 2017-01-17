package com.itxiaoming.materialdesign.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.itxiaoming.materialdesign.ImageActivity;
import com.itxiaoming.materialdesign.R;
import com.itxiaoming.materialdesign.utils.IamgeLoad;

import java.util.List;

/**
 * 作者:xjm.
 * 邮箱:xiaojiaming@infosec.com.cn
 * 公司:Infosec Technology
 * 创建时间:Created on 2017/1/13 10:17.
 * 该类的作用:
 * 版本号:
 */

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
    private Context context;
    private List<IamgeLoad> mLists;
    public ImageAdapter(List<IamgeLoad> mLists){
        this.mLists = mLists;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(context==null){
            context = parent.getContext();
        }
        View view = LayoutInflater.from(context).inflate(R.layout.image_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int adapterPosition = holder.getAdapterPosition();
                    IamgeLoad iamgeLoad = mLists.get(adapterPosition);
                    Intent intent = new Intent(context, ImageActivity.class);
                    intent.putExtra(ImageActivity.IMAGE_NAME,iamgeLoad.getName());
                    intent.putExtra(ImageActivity.IMAGE_ID,iamgeLoad.getImageId());
                    context.startActivity(intent);

            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
            IamgeLoad iamgeLoad = mLists.get(position);
            holder.imageName.setText(iamgeLoad.getName());
        //利用Glide将我们的图片进行加载
        Glide.with(context).load(iamgeLoad.getImageId()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return mLists.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView imageView;
        private TextView imageName;
        private CardView cardView;
        public ViewHolder(View view) {
            super(view);
            cardView = (CardView)view;
            imageView = (ImageView) view.findViewById(R.id.imageView);
            imageName = (TextView) view.findViewById(R.id.imageName);
        }


    }
}
