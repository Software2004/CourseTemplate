package com.example.coursetemplate.Model;

import java.util.List;

public class CourseDetail {
    private String title;
    private boolean isRecyclerViewVisible;
    private List<CourseInnerDetail> detailList;

    public CourseDetail(String title, List<CourseInnerDetail> detailList) {
        this.title = title;
        this.detailList = detailList;
        this.isRecyclerViewVisible = false;
    }

    public CourseDetail(String title, boolean isRecyclerViewVisible, List<CourseInnerDetail> detailList) {
        this.title = title;
        this.isRecyclerViewVisible = isRecyclerViewVisible;
        this.detailList = detailList;
    }

    public boolean getRecyclerViewVisible() {
        return isRecyclerViewVisible;
    }

    public void setRecyclerViewVisible(boolean recyclerViewVisible) {
        isRecyclerViewVisible = recyclerViewVisible;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<CourseInnerDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<CourseInnerDetail> detailList) {
        this.detailList = detailList;
    }


}
