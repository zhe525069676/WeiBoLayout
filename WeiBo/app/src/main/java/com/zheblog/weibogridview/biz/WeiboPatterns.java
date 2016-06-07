package com.zheblog.weibogridview.biz;

import java.util.regex.Pattern;

/**
 * Created by liuz on 16/06/07.
 */
public class WeiboPatterns {

    public static final Pattern WEB_URL = Pattern
            .compile("(((http|https)://)|((?<!((http|https)://))www\\.))" + ".*?" + "(?=(&nbsp;|[\\u4e00-\\u9fa5]|\\s|　|<br />|$|[<>]))");
    public static final Pattern TOPIC_URL = Pattern
            .compile("#[\\p{Print}\\p{InCJKUnifiedIdeographs}&&[^#]]+#");
    public static final Pattern MENTION_URL = Pattern
            .compile("@[\u4e00-\u9fa5a-zA-Z0-9_-·\\.]+[\u200B]");

    public static final String WEB_SCHEME = "http://";
    public static final String TOPIC_SCHEME = "com.zheblog.weibo.topic://";
    public static final String MENTION_SCHEME = "com.zheblog.weibo.at://";

    public static final String WEB_COMPARE_HTTP = "http";
    public static final String WEB_COMPARE_HTTPS = "https";
    public static final String TOPIC_COMPARE_SCHEME = "com.zheblog.weibo.topic";
    public static final String MENTION_COMPARE_SCHEME = "com.zheblog.weibo.at";

}
