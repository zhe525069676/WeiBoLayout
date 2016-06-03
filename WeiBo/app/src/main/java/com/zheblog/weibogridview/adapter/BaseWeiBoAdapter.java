package com.zheblog.weibogridview.adapter;

import android.content.Context;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuz on 16/6/3.
 */
public abstract class BaseWeiBoAdapter<T> extends BaseAdapter {

    protected List<T> mEntities;

    protected Context mContext;

    public BaseWeiBoAdapter() {
    }

    public BaseWeiBoAdapter(Context context, List<T> mEntities) {
        this.mContext = context;
        this.mEntities = mEntities;
        setDatas(mEntities);
    }

    /**
     * 设置元素
     *
     * @param datas
     */
    private void setDatas(List<T> datas) {
        setListDatas(datas);
    }

    public void setListDatas(List<T> datas) {
        if (datas == null) {
            this.mEntities = new ArrayList<T>();
        } else {
            this.mEntities = datas;
        }
        notifyDataSetChanged();
    }

    public void addDatas(List<T> datas) {
        if (mEntities == null) {
            mEntities = new ArrayList<T>();
        }
        mEntities.addAll(datas);
        notifyDataSetChanged();
    }

    public void addData(T t) {
        if (mEntities == null) {
            mEntities = new ArrayList<T>();
        }
        mEntities.add(t);
        notifyDataSetChanged();
    }

    public void addDatasToFirst(List<T> datas) {
        if (mEntities == null) {
            mEntities = new ArrayList<T>();
        }
        mEntities.addAll(0, datas);
        notifyDataSetChanged();
    }

    public void addDataToFirst(T t) {
        if (mEntities == null) {
            mEntities = new ArrayList<T>();
        }
        mEntities.add(0, t);
        notifyDataSetChanged();
    }

    public List<T> getDatas() {
        return mEntities;
    }

    @Override
    public int getCount() {
        return mEntities == null ? 0 : mEntities.size();
    }

    @Override
    public Object getItem(int position) {
        return mEntities == null ? null : mEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

}
