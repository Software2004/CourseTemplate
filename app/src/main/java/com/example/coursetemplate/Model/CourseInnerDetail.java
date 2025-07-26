package com.example.coursetemplate.Model;
public class CourseInnerDetail{
    private String videoName;
    private int noVideos;

    public CourseInnerDetail(String videoName, int noVideos) {
        this.videoName = videoName;
        this.noVideos = noVideos;
    }

    public String getVideoName() {
        return videoName;
    }

    public void setVideoName(String videoName) {
        this.videoName = videoName;
    }

    public int getNoVideos() {
        return noVideos;
    }

    public void setNoVideos(int noVideos) {
        this.noVideos = noVideos;
    }
}
