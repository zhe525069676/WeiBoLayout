package com.zheblog.weibogridview.model;

import java.util.List;

/**
 * feed model
 * Created by liuz on 16/6/3.
 */
public class FeedModel {

    private String content;
    private List<FeedPhotoModel> photoModels;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<FeedPhotoModel> getPhotoModels() {
        return photoModels;
    }

    public void setPhotoModels(List<FeedPhotoModel> photoModels) {
        this.photoModels = photoModels;
    }

    @Override
    public String toString() {
        return "FeedModel{" +
                "content='" + content + '\'' +
                ", photoModels=" + photoModels +
                '}';
    }
}
