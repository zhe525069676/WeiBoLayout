package com.zheblog.weibogridview;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.zheblog.weibogridview.adapter.TestAdapter;
import com.zheblog.weibogridview.model.FeedModel;
import com.zheblog.weibogridview.model.FeedPhotoModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private ListView lvTest;

    private TestAdapter mAdapter;

    private List<FeedModel> mDatas = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        lvTest = (ListView) findViewById(R.id.lv_test);
    }

    private void initData() {
        for (int i = 0; i < 10; i++) {
            List<FeedPhotoModel> list = new ArrayList<>();
            FeedModel feedModel = new FeedModel();
            for (int j = 0; j < i; j++) {
                list.add(new FeedPhotoModel(R.mipmap.icon_head));
            }
            feedModel.setContent("#秋天来了#夏天就这么静悄悄的走了~~@哲匠"+i+"\u200B,加油!!!www.zheblog.com");
            feedModel.setPhotoModels(list);
            mDatas.add(feedModel);
        }
        mAdapter = new TestAdapter(this, mDatas);
        lvTest.setAdapter(mAdapter);
    }

}
