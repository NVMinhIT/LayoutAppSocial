package com.example.firstproject.ui;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.firstproject.R;
import com.example.firstproject.adapter.TimeLineAdapter;
import com.example.firstproject.model.FeedPage;
import com.example.firstproject.model.SubPageImage;

import java.util.ArrayList;
import java.util.List;

public class TimeLineActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<FeedPage> feedPageArrayList;
    TimeLineAdapter timeLineAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_line);
        init();
        popularRecycleView();
    }

    private void init() {
        recyclerView = findViewById(R.id.recycleview_page);
        feedPageArrayList = new ArrayList<>();
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        timeLineAdapter = new TimeLineAdapter(this, feedPageArrayList);
        recyclerView.setAdapter(timeLineAdapter);

    }

    public void popularRecycleView() {

        FeedPage fp = new FeedPage(1, 123, 987, R.drawable.victoria, R.drawable.beckham, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorBackground, "Minh",
                "1m ago", "Xin chào", null);
        ArrayList<SubPageImage> lsSub = new ArrayList<>();
        lsSub.add(new SubPageImage(1, R.drawable.victoria));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);

        fp = new FeedPage(2, 442, 88, R.drawable.victoria1, 0, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorAccent, "Linh",
                "1d ago", "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc fringilla cursus sodales. Proin hendrerit tempor purus eu posuere.", null);
        lsSub.add(new SubPageImage(2, R.drawable.victoria));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);
        fp = new FeedPage(3, 3, 6, R.drawable.victoria, 1, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorBorder, "Tú",
                "5m ago", "Have 5 new connection", null);
        lsSub.add(new SubPageImage(3, R.drawable.victoria1));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);

        fp = new FeedPage(4, 442, 88, R.drawable.victoria1, R.drawable.victoria, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorPrimaryDark, "Linh",
                "2d ago", "Xin chào", null);
        lsSub.add(new SubPageImage(4, R.drawable.victoria));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);
        fp = new FeedPage(5, 35, 6, R.drawable.victoria, 0, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorBackground, "Anh Tú",
                "2m ago", "Chào Anh Tú", null);
        lsSub.add(new SubPageImage(5, R.drawable.victoria));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);

        fp = new FeedPage(6, 442, 88, R.drawable.victoria1, R.drawable.victoria1, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorBackground, "Linh",
                "9d ago", "Have a 5 connection", null);
        lsSub.add(new SubPageImage(6, 0));
        fp.setSubPageImageList(lsSub);

        feedPageArrayList.add(fp);
        fp = new FeedPage(7, 33, 6, R.drawable.victoria, 0, R.drawable.ic_post_picture, R.drawable.ic_heart, R.drawable.ic_comment, R.color.colorPrimary, "Tú",
                "4m ago", "Chào buổi sáng", null);
        lsSub.add(new SubPageImage(7, 0));
        fp.setSubPageImageList(lsSub);
        feedPageArrayList.add(fp);
    }
}
