package com.example.firstproject.model;

import java.util.List;

public class FeedPage {
    private List<SubPageImage> subPageImageList;
    private int id, like, comment, postava, postpic, postimage, imglike, imgcomment, colordot;
    private String name, time, postcontent;
    public FeedPage() {

    }
    public FeedPage(int id, int like, int comment, int postava, int postpic, int postimage, int imglike, int imgcomment, int colordot, String name, String time, String postcontent, List<SubPageImage> subPageImageList) {
        this.id = id;
        this.like = like;
        this.comment = comment;
        this.postava = postava;
        this.postpic = postpic;
        this.postimage = postimage;
        this.imglike = imglike;
        this.imgcomment = imgcomment;
        this.colordot = colordot;
        this.name = name;
        this.time = time;
        this.postcontent = postcontent;
        this.subPageImageList = subPageImageList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public int getComment() {
        return comment;
    }

    public void setComment(int comment) {
        this.comment = comment;
    }

    public int getPostava() {
        return postava;
    }

    public void setPostava(int postava) {
        this.postava = postava;
    }

    public int getPostpic() {
        return postpic;
    }

    public void setPostpic(int postpic) {
        this.postpic = postpic;
    }

    public int getPostimage() {
        return postimage;
    }

    public void setPostimage(int postimage) {
        this.postimage = postimage;
    }

    public int getImglike() {
        return imglike;
    }

    public void setImglike(int imglike) {
        this.imglike = imglike;
    }

    public int getImgcomment() {
        return imgcomment;
    }

    public void setImgcomment(int imgcomment) {
        this.imgcomment = imgcomment;
    }

    public int getColordot() {
        return colordot;
    }

    public void setColordot(int colordot) {
        this.colordot = colordot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getPostcontent() {
        return postcontent;
    }

    public void setPostcontent(String postcontent) {
        this.postcontent = postcontent;
    }

    public List<SubPageImage> getSubPageImageList() {
        return subPageImageList;
    }

    public void setSubPageImageList(List<SubPageImage> subPageImageList) {
        this.subPageImageList = subPageImageList;
    }
}
