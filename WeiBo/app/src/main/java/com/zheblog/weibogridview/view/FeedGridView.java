package com.zheblog.weibogridview.view;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;

import com.zheblog.weibogridview.adapter.FeedPhotoAdapter;
import com.zheblog.weibogridview.model.FeedPhotoModel;
import com.zheblog.weibogridview.util.Utils;

import java.util.ArrayList;

/**
 * Created by liuz on 16/6/3.
 */
public class FeedGridView extends BaseGridView implements AdapterView.OnItemClickListener {

    //当发布动态时，每行显示4个
    public boolean isPublish;

    public FeedGridView(Context context) {
        super(context);
    }

    public FeedGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FeedGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private FeedPhotoAdapter photoAdapter;
    private String[] mBigImgs;
    private int mColumnNum;

    public void setPhotoAdapter(LayoutInflater inflater, String[] imgs, String[] bigImgs) {
        mBigImgs = bigImgs;
        ArrayList<FeedPhotoModel> photoList = new ArrayList<>();
        for (String imgStr : imgs) {
            FeedPhotoModel photoModel = new FeedPhotoModel();
            photoModel.setUrl(imgStr);
            photoList.add(photoModel);
        }
        if (!isPublish) {
            int count = photoList.size();
            //一张图片的时候也是占1/2
            if (count == 1 || count == 2 || count == 4) {
                mColumnNum = 2;
                setNumColumns(2);
            } else {
                mColumnNum = 3;
                setNumColumns(3);
            }
        }
        int width = calculateColumnWidth();
        setColumnWidth(width);
        photoAdapter = new FeedPhotoAdapter(getContext(), photoList, inflater, width);
        this.setAdapter(photoAdapter);
        this.setOnItemClickListener(this);
        photoAdapter.notifyDataSetChanged();
        setGridViewWidthBasedOnChildren(this, photoList.size());
    }

    private int calculateColumnWidth() {
        int width = Utils.getScreenWidth((Activity) getContext());
        if (mColumnNum == 2) {
            width = width / mColumnNum - Utils.px2dp(getContext(), 24 * 2 + 10);
        } else if (mColumnNum == 3) {
            width = width / mColumnNum - Utils.px2dp(getContext(), 24 * 2 + 10 * 2);
        }
        return width;
    }

    /**
     * 动态计算gridview的宽度
     *
     * @param gridView
     * @param count
     */
    public static void setGridViewWidthBasedOnChildren(GridView gridView, int count) {
        // 获取gridview的adapter
        ListAdapter listAdapter = gridView.getAdapter();
        if (listAdapter == null) {
            return;
        }
        // 固定列宽，有多少列
        int col = count;
        if (count == 4) {
            col = 2;
        }
        if (listAdapter.getCount() < count) {
            col = listAdapter.getCount();
        }
        int totalWidth = 0;
        for (int i = 0; i < col; i++) {
            // 获取gridview的每一个item
            View listItem = listAdapter.getView(i, null, gridView);
            listItem.measure(0, 0);
            // 获取item的宽度和
            if (i == 0) {
                totalWidth += listItem.getMeasuredWidth() + 5;
            } else {
                totalWidth += listItem.getMeasuredWidth() + 10;
            }
        }
        // 获取gridview的布局参数
        ViewGroup.LayoutParams params = gridView.getLayoutParams();
        // 设置宽度
        params.width = totalWidth;
        // 设置参数
        gridView.setLayoutParams(params);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ArrayList<String> photoList = new ArrayList<>();
        for (String str : mBigImgs) {
            photoList.add(str);
        }
    }
}