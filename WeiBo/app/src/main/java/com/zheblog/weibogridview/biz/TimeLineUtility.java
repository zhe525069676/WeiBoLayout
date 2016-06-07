package com.zheblog.weibogridview.biz;

import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.URLSpan;
import android.text.util.Linkify;
import android.util.Log;

import com.zheblog.weibogridview.util.Constant;

import java.util.regex.Matcher;

/**
 * Created by liuz on 16/6/7.
 */
public class TimeLineUtility {

    private static final String TAG = "TimeLineUtility";

    private static String mColor = Constant.SPAN_LINK_COLOR;

    public static void setSpanColor(String color) {
        mColor = color;
    }

    private TimeLineUtility() {

    }

    public enum TimeLineStatus {
        LINK, FEED
    }

//    public static void addLinks(TextView view) {
//        CharSequence content = view.getText();
//        view.setText(convertNormalStringToSpannableString(content.toString()));
//        if (view.getLinksClickable()) {
//            view.setMovementMethod(LongClickableLinkMovementMethod.getInstance());
//        }
//    }

    public static SpannableString convertNormalStringToSpannableString(String txt, TimeLineStatus status) {
        //hack to fix android imagespan bug,see http://stackoverflow.com/questions/3253148/imagespan-is-cut-off-incorrectly-aligned
        //if string only contains emotion tags,add a empty char to the end
        String hackTxt;
        if (txt.startsWith("[") && txt.endsWith("]")) {
            hackTxt = txt + " ";
        } else {
            hackTxt = txt;
        }

        SpannableString value = SpannableString.valueOf(hackTxt);
        switch (status) {
            case LINK: {
                Linkify.addLinks(value, WeiboPatterns.WEB_URL, WeiboPatterns.WEB_SCHEME);
            }
            break;
            case FEED: {
                Linkify.addLinks(value, WeiboPatterns.WEB_URL, WeiboPatterns.WEB_SCHEME);
                Linkify.addLinks(value, WeiboPatterns.TOPIC_URL, WeiboPatterns.TOPIC_SCHEME);
                Linkify.addLinks(value, WeiboPatterns.MENTION_URL, WeiboPatterns.MENTION_SCHEME);
            }
            break;
        }

        URLSpan[] urlSpans = value.getSpans(0, value.length(), URLSpan.class);
        MyURLSpan weiboSpan;

        for (URLSpan urlSpan : urlSpans) {
            if (urlSpan.getURL().startsWith(WeiboPatterns.TOPIC_SCHEME)) {
                String topic = urlSpan.getURL().substring(WeiboPatterns.TOPIC_SCHEME.length(), urlSpan.getURL().length());
                //不识别空格话题和大于30字话题
                String group = topic.substring(1, topic.length() - 1).trim();
                if (1 > group.length() || group.length() > 30) {
                    value.removeSpan(urlSpan);
                    continue;
                }
            }
            weiboSpan = new MyURLSpan(urlSpan.getURL(), mColor);
            int start = value.getSpanStart(urlSpan);
            int end = value.getSpanEnd(urlSpan);
            value.removeSpan(urlSpan);
            value.setSpan(weiboSpan, start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        }

        return value;
    }

}
