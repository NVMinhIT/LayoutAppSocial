package com.example.firstproject.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.example.firstproject.R;
import com.example.firstproject.model.FeedPage;

import java.util.List;

public class TimeLineAdapter extends RecyclerView.Adapter<TimeLineAdapter.MyViewHolder> {
    RequestManager glide;
    RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();
    private Context mContext;
    private List<FeedPage> pageList;

    public TimeLineAdapter(Context mContext, List<FeedPage> pageList) {
        this.mContext = mContext;
        this.pageList = pageList;
        glide = Glide.with(mContext);

    }

    @NonNull
    @Override
    public TimeLineAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recycleview, parent, false);
        return new MyViewHolder(view);
    }

    @SuppressLint({"ResourceAsColor", "ResourceType"})
    @Override
    public void onBindViewHolder(@NonNull TimeLineAdapter.MyViewHolder holder, int position) {
        final FeedPage feedPage = pageList.get(position);
        holder.tvName.setText(feedPage.getName());
        holder.tvTime.setText(feedPage.getTime());
        holder.tvLike.setText(String.valueOf(feedPage.getLike()));
        holder.tvComment.setText(String.valueOf(feedPage.getComment()));
        holder.tvContentStatus.setText(feedPage.getPostcontent());
        glide.load(feedPage.getPostava()).into(holder.imagePostAva);
        LinearLayoutManager layoutManager = new LinearLayoutManager(
                holder.supRecyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL, false
        );
        layoutManager.setInitialPrefetchItemCount(feedPage.getSubPageImageList().size());
        SubPageImageAdapter subPageImageAdapter = new SubPageImageAdapter(mContext, feedPage.getSubPageImageList());
        holder.supRecyclerView.setLayoutManager(layoutManager);
        holder.supRecyclerView.setAdapter(subPageImageAdapter);
        holder.supRecyclerView.setRecycledViewPool(viewPool);
        if (feedPage.getPostpic() == 0) {
            holder.imagePostPic.setVisibility(View.GONE);
            holder.imageButtonPost.setVisibility(View.GONE);
            holder.tvContentStatus.setVisibility(View.VISIBLE);
            holder.supRecyclerView.setVisibility(View.GONE);

        } else if (feedPage.getPostpic() == 1) {
            holder.imagePostPic.setVisibility(View.GONE);
            holder.imageButtonPost.setVisibility(View.GONE);
            holder.tvContentStatus.setVisibility(View.VISIBLE);
            holder.supRecyclerView.setVisibility(View.VISIBLE);
            holder.tvLike.setVisibility(View.GONE);
            holder.tvComment.setVisibility(View.GONE);
            holder.imageLike.setVisibility(View.GONE);
            holder.imageComment.setVisibility(View.GONE);

        } else {
            holder.imagePostPic.setVisibility(View.VISIBLE);
            holder.imageButtonPost.setVisibility(View.VISIBLE);
            holder.tvContentStatus.setVisibility(View.GONE);
            holder.supRecyclerView.setVisibility(View.GONE);
            glide.load(feedPage.getPostpic()).into(holder.imagePostPic);
        }
        if (position == 0) {
            holder.viewBeforeDot.setVisibility(View.GONE);

        } else {
            holder.viewBeforeDot.setBackgroundColor(ContextCompat.getColor(mContext, pageList.get(position - 1).getColordot()));
            holder.viewBeforeDot.setVisibility(View.GONE);

        }
        holder.viewAfterBot.setBackgroundColor(ContextCompat.getColor(mContext, pageList.get(position).getColordot()));
        Drawable drawable = mContext.getResources().getDrawable(R.drawable.bg_dot);
        drawable.setColorFilter(ContextCompat.getColor(mContext, pageList.get(position).getColordot()), PorterDuff.Mode.SRC);
        holder.viewDot.setBackground(drawable);
    }

    @Override
    public int getItemCount() {
        return pageList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName, tvTime, tvLike, tvComment, tvContentStatus;
        ImageView imagePostAva, imagePostPic, imageLike, imageComment;
        ImageButton imageButtonPost;
        RecyclerView supRecyclerView;
        View viewBeforeDot, viewAfterBot, viewDot;
        LinearLayout linearLayout;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.txt_name);
            tvTime = itemView.findViewById(R.id.txt_time);
            tvLike = itemView.findViewById(R.id.txt_like);
            tvComment = itemView.findViewById(R.id.txt_comment);
            imageLike = itemView.findViewById(R.id.img_like);
            imageComment = itemView.findViewById(R.id.img_comment);
            tvContentStatus = itemView.findViewById(R.id.txt_content_status);
            imagePostAva = itemView.findViewById(R.id.img_postava);
            imagePostPic = itemView.findViewById(R.id.img_postpic);
            imageButtonPost = itemView.findViewById(R.id.imgbt_post);
            supRecyclerView = itemView.findViewById(R.id.rv_sub_recycleview);
            viewBeforeDot = itemView.findViewById(R.id.before_dot);
            viewAfterBot = itemView.findViewById(R.id.after_dot);
            viewDot = itemView.findViewById(R.id.dot);
            linearLayout = itemView.findViewById(R.id.content_like_comment);

        }
    }
}
