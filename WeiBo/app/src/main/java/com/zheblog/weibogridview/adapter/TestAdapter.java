package com.zheblog.weibogridview.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zheblog.weibogridview.R;
import com.zheblog.weibogridview.biz.ClickableTextViewMentionLinkOnTouchListener;
import com.zheblog.weibogridview.biz.TimeLineUtility;
import com.zheblog.weibogridview.model.FeedModel;
import com.zheblog.weibogridview.view.FeedGridView;
import com.zheblog.weibogridview.viewholder.ViewHolder;

import java.util.List;

/**
 * Created by liuz on 16/6/3.
 */
public class TestAdapter extends BaseWeiBoAdapter<FeedModel> {

    private LayoutInflater mInflater;

    public TestAdapter(Activity context, List<FeedModel> mEntities) {
        super(context, mEntities);
        this.mInflater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FeedModel item = getDatas().get(position);

        if (null == convertView) {
            convertView = mInflater.inflate(R.layout.item_main_test, null);
        }

        TextView tvContent = ViewHolder.get(convertView, R.id.tv_content);
        FeedGridView gvPhoto = ViewHolder.get(convertView, R.id.gv_photo);

        tvContent.setText(TimeLineUtility.convertNormalStringToSpannableString(item.getContent(), TimeLineUtility.TimeLineStatus.FEED));
        tvContent.setOnTouchListener(new ClickableTextViewMentionLinkOnTouchListener());
        gvPhoto.setPhotoAdapter(item.getPhotoModels());

        return convertView;
    }
}
