package com.zheblog.weibogridview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zheblog.weibogridview.R;
import com.zheblog.weibogridview.model.FeedPhotoModel;
import com.zheblog.weibogridview.viewholder.ViewHolder;

import java.util.List;

/**
 * Created by liuz on 16/6/3.
 */
public class FeedPhotoAdapter extends BaseWeiBoAdapter<FeedPhotoModel> {

    private int mColumnWidth;

    private LayoutInflater mInflater;

    public FeedPhotoAdapter(Activity context, List<FeedPhotoModel> mEntities, int mColumnWidth) {
        super(context, mEntities);
        this.mColumnWidth = mColumnWidth;
        this.mInflater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FeedPhotoModel item = getDatas().get(position);
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_feed_photo, null);
        }
        ImageView photo = ViewHolder.get(convertView, R.id.iv_photo);
        ViewGroup.LayoutParams params = photo.getLayoutParams();
        params.width = mColumnWidth;
        params.height = mColumnWidth;
        photo.setLayoutParams(params);
        photo.setImageResource(item.getLocalRes());

        return convertView;
    }
}
