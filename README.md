# WeiBoLayout
仿微博、微信QQ，包含展示动态(Feed)图片，不同数量不同布局的GridView和识别包含超链接、#字话题、@人的文本效果。
---

### WeiBoLayout中的FeedGridView是根据显示子View的个数，使其填充满屏幕宽度的View，WeiBoLayout可识别文本中的超链接、#字话题、@人，适用于社交软件Feed的展示。###


FeedGridView XML:

```
<com.zheblog.weibogridview.view.FeedGridView
        android:id="@+id/gv_photo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/zhe_dp10"
        android:listSelector="@color/zhe_transparent"
        android:scrollbars="none"
        android:stretchMode="none"
        app:hSpacing="@dimen/zhe_dp10"
        app:pSpacing="@dimen/zhe_dp10"
        app:vSpacing="@dimen/zhe_dp10" />
```
```
hSpacing是水平间距
vSpacing是垂直间距
pSpacing是GridView两边距父控件的间距，便于动态计算每个item的宽度
```

FeedGridView 使用代码：

```
gvPhoto.setPhotoAdapter(item.getPhotoModels());
```

动态效果图：

![FeedGridView](https://github.com/zhe525069676/WeiBoLayout/blob/master/gif/WeiBoGridView.gif)

识别文本中的超链接、#字话题、@人的文本

```
tvContent.setText(TimeLineUtility.convertNormalStringToSpannableString(item.getContent(), TimeLineUtility.TimeLineStatus.FEED));
tvContent.setOnTouchListener(new ClickableTextViewMentionLinkOnTouchListener());
```
```
//LINK单一识别超链接
//FEED识别超链接、#字话题、@人
public enum TimeLineStatus {
        LINK, FEED
    }
```
动态效果图：

![识别文本](https://github.com/zhe525069676/WeiBoLayout/blob/master/gif/WeiBoLayoutDes.gif)

###[GitHub代码下载](https://github.com/zhe525069676/WeiBoLayout)

### 最后 ###

如果对您有帮助请Star，有问题随时联系我，谢谢.

### 关于我 ###

邮箱: nh_zhe@163.com

[简书](http://www.jianshu.com/users/550d52af9d72/latest_articles)

[个人博客](http://www.zheblog.com)