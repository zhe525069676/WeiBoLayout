package com.zheblog.weibogridview.model;

/**
 * feed img model
 * Created by liuz on 16/6/3.
 */
public class FeedPhotoModel {

    private int id;
    private String thumbnailUrl;
    private String originalurl;
    private int localRes;

    public FeedPhotoModel(int localRes) {
        this.localRes = localRes;
    }

    public FeedPhotoModel(String thumbnailUrl, String originalurl) {
        this.thumbnailUrl = thumbnailUrl;
        this.originalurl = originalurl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    public String getOriginalurl() {
        return originalurl;
    }

    public void setOriginalurl(String originalurl) {
        this.originalurl = originalurl;
    }

    public int getLocalRes() {
        return localRes;
    }

    public void setLocalRes(int localRes) {
        this.localRes = localRes;
    }

    @Override
    public String toString() {
        return "FeedPhotoModel{" +
                "id=" + id +
                ", thumbnailUrl='" + thumbnailUrl + '\'' +
                ", originalurl='" + originalurl + '\'' +
                ", localRes=" + localRes +
                '}';
    }
}
