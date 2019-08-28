package com.example.firstproject.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.firstproject.R;
import com.example.firstproject.model.SubPageImage;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubPageImageAdapter extends RecyclerView.Adapter<SubPageImageAdapter.MyViewHolder> {
    RequestManager glide;
    private Context mContext;
    private List<SubPageImage> subPageImageList;

    public SubPageImageAdapter(Context context, List<SubPageImage> subPageImageAdapters) {
        this.mContext = context;
        this.subPageImageList = subPageImageAdapters;
        glide = Glide.with(mContext);
    }

    public void setSubPageImageList(List<SubPageImage> imageList) {
        subPageImageList = imageList;
        notifyDataSetChanged();
    }

    public void addData(List<SubPageImage> listData) {
        if (subPageImageList == null) {
            subPageImageList = listData;
        } else {
            subPageImageList.addAll(listData);
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubPageImageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sub_recycleview, parent, false);
        return new SubPageImageAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SubPageImageAdapter.MyViewHolder holder, int position) {
        final SubPageImage subPageImage = subPageImageList.get(position);
        glide.load(subPageImage.getIdImg()).into(holder.circleImageView);

    }

    @Override
    public int getItemCount() {
        return subPageImageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        CircleImageView circleImageView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            circleImageView = itemView.findViewById(R.id.img_avartar_user);
        }
    }
}
