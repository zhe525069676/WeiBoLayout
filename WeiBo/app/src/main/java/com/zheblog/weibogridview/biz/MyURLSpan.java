package com.zheblog.weibogridview.biz;

import android.graphics.Color;
import android.net.Uri;
import android.os.Parcel;
import android.text.ParcelableSpan;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;

import com.zheblog.weibogridview.util.Constant;
import com.zheblog.weibogridview.util.Utils;

/**
 * Created by liuz on 16/6/7.
 */
public class MyURLSpan extends ClickableSpan implements ParcelableSpan {

    private final String mURL;
    private String mColor = Constant.SPAN_LINK_COLOR;

    public MyURLSpan(String url) {
        this.mURL = url;
    }

    public MyURLSpan(Parcel src) {
        this.mURL = src.readString();
    }

    public MyURLSpan(String url, String color) {
        this.mURL = url;
        if (!TextUtils.isEmpty(color)) {
            this.mColor = color;
        }
    }

    @Override
    public int getSpanTypeId() {
        return 11;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mURL);
    }

    public String getURL() {
        return mURL;
    }

    public void onClick(View widget) {
        if (!TextUtils.isEmpty(getURL())) {
            Uri uri = Uri.parse(getURL());
            if (uri.getScheme().startsWith(WeiboPatterns.WEB_COMPARE_HTTP) || uri.getScheme().startsWith(WeiboPatterns.WEB_COMPARE_HTTPS)) {
                Utils.showToast(widget.getContext(), getURL());
                // TODO: 16/6/7 跳转链接页面
            } else if (uri.getScheme().startsWith(WeiboPatterns.TOPIC_COMPARE_SCHEME)) {
                String topic = getURL();
                topic = topic.substring(WeiboPatterns.TOPIC_SCHEME.length(), topic.length());
                Utils.showToast(widget.getContext(), topic);
                // TODO: 16/6/7 跳转#字话题页面
            } else if (uri.getScheme().startsWith(WeiboPatterns.MENTION_COMPARE_SCHEME)) {
                Utils.showToast(widget.getContext(), uri.getHost());
                // TODO: 16/6/7 跳转@人页面
            }
        }
    }

//    public void onLongClick(View widget) {
//        Uri data = Uri.parse(getURL());
//        if (data != null) {
//            String d = data.toString();
//            String newValue = "";
//            if (d.startsWith("com.xiaoyou.alumni")) {
//                int index = d.lastIndexOf("/");
//                newValue = d.substring(index + 1);
//            } else if (d.startsWith("http")) {
//                newValue = d;
//            }
//            if (!TextUtils.isEmpty(newValue)) {
//                Utility.vibrate(widget.getContext(), widget);
//                LongClickLinkDialog dialog = new LongClickLinkDialog(data);
//                Utility.forceShowDialog((FragmentActivity) widget.getContext(), dialog);
//            }
//        }
//    }

    @Override
    public void updateDrawState(TextPaint tp) {
        tp.setColor(Color.parseColor(mColor));
    }
}