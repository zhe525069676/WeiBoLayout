# WeiBoGridView
类似微博、微信展示动态(Feed)图片，不同数量不同布局的GridView。
---

###WeiBoGridView是根据显示子View的个数，使其填充满屏幕宽度的View，适用于社交软件Feed的展示。

XML:

```
<com.zheblog.weibogridview.view.FeedGridView
        android:id="@+id/gv_photo"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_marginTop="@dimen/zhe_dp10"
        android:horizontalSpacing="@dimen/zhe_dp10"
        android:listSelector="@color/zhe_transparent"
        android:scrollbars="none"
        android:stretchMode="none"
        android:verticalSpacing="@dimen/zhe_dp10" />
```

代码：

```
gvPhoto.setPhotoAdapter(item.getPhotoModels());
```

动态效果图：

![zheblog](http://7xom0g.com1.z0.glb.clouddn.com/WeiBoGridView.gif)

###[GitHub代码下载](https://github.com/zhe525069676/WeiBoGridView)

###最后
<mark>注</mark>：后期会增加#字话题、链接、@人的识别。

如果对您有帮助请Star，有问题随时联系我，谢谢.

###关于我
QQ:525069676

邮箱:nh_zhe@163.com

[个人博客](zheblog.com)