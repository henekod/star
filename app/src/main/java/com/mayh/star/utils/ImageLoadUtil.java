package com.mayh.star.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.mayh.star.R;
import com.mayh.star.view.custom.TouchImageView;

import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * =========================================
 *
 * author: Ma Yuhua
 * date: 2018/5/28
 * desc: 图片加载工具类
 *
 * =========================================
 */
public class ImageLoadUtil {
    private static ImageLoadUtil instance;

    private ImageLoadUtil() {
    }

    /**
     * 饿汉式
     *
     * @return
     */
    public static ImageLoadUtil getInstance() {
        if (instance == null) {
            instance = new ImageLoadUtil();
        }
        return instance;
    }

    /**
     * 显示随机图片（每日推荐）
     *
     * @param imgNumber 图片张数
     * @param imageUrl  图片url
     * @param imageView 图片控件
     */
    public static void displayRandom(int imgNumber, String imageUrl, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(imageUrl)
                .apply(new RequestOptions()
                        .placeholder(getMusicDefaultPic(imgNumber))
                        .error(getMusicDefaultPic(imgNumber)))
                .transition(new DrawableTransitionOptions().crossFade(1500))
                .into(imageView);
    }

    private static int getMusicDefaultPic(int imgNumber) {
        switch (imgNumber) {
            case 1:
                return R.drawable.img_two_bi_one;

            case 2:
                return R.drawable.img_four_bi_three;

            case 3:
                return R.drawable.img_one_bi_one;
        }
        return R.drawable.img_four_bi_three;
    }

    /**
     * 将gif图转换为静态图
     *
     * @param url
     * @param imageView
     */
    public static void displayGif(String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .asBitmap()
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.img_one_bi_one)
                        .error(R.drawable.img_one_bi_one))
                .into(imageView);
    }

    /**
     * 书籍、妹子、电影列表图
     *
     * @param type
     * @param url
     * @param imageView
     */
    public static void displayImage(int type, String url, ImageView imageView) {
        Glide.with(imageView.getContext())
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(new RequestOptions()
                        .placeholder(getDefaultPic(type))
                        .error(getDefaultPic(type)))
                .into(imageView);
    }

    private static int getDefaultPic(int type) {
        switch (type) {
            case 0:// 电影
                return R.drawable.img_default_movie;

            case 1:// 妹子
                return R.drawable.img_default_meizi;

            case 2:// 书籍
                return R.drawable.img_default_book;
        }
        return R.drawable.img_default_meizi;
    }

    /**
     * 高斯效果模糊（电影详情页）
     *
     * @param context
     * @param url
     * @param imageView
     */
    public static void displayGaussian(Context context, String url, ImageView imageView) {
        // 23：模糊度 4：图片缩放4倍后再进行模糊
        Glide.with(context)
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(new RequestOptions()
                        .error(R.drawable.stackblur_default)
                        .placeholder(R.drawable.stackblur_default)
                        .transform(new BlurTransformation(3)))
                .into(imageView);
    }

    /**
     * 加载圆角图片
     *
     * @param imageView 设置的图片
     * @param url       图片地址
     */
    public static void displayCircle(ImageView imageView, String url) {
        Glide.with(imageView.getContext())
                .load(url)
                .transition(new DrawableTransitionOptions().crossFade(500))
                .apply(new RequestOptions()
                        .transform(new CircleTransform(imageView.getContext())))
                .into(imageView);
    }

    /**
     * 加载banner图片
     *
     * @param context 上下文
     * @param url     图片地址
     */
    public static void displayBanner(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .apply(new RequestOptions()
                        .placeholder(R.drawable.img_four_bi_three)
                        .error(R.drawable.img_four_bi_three)
                        .centerCrop())
                .into(imageView);
    }

    /**
     * 加载music各item图片
     *
     * @param context   上下文
     * @param url       图片地址
     * @param imageView 图片控件
     * @param type      item类型
     */
    public static void displayImage(Context context, String url, ImageView imageView, int type) {
        if (type == 3) {
            Glide.with(context)
                    .load(url)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.img_one_bi_one)
                            .error(R.drawable.img_one_bi_one)
                            .fitCenter())
                    .into(imageView);
        } else {
            Glide.with(context)
                    .load(url)
                    .apply(new RequestOptions()
                            .placeholder(R.drawable.img_one_bi_one)
                            .error(R.drawable.img_one_bi_one)
                            .centerCrop())
                    .into(imageView);
        }
    }

    /**
     * 展示大图
     *
     * @param context        上下文
     * @param url            本地图片路径
     * @param touchImageView 显示控件
     */
    public static void displayPhoto(Context context, String url, final TouchImageView touchImageView) {
        Glide.with(context)
                .asBitmap()
                .load(url)
                .into(new SimpleTarget<Bitmap>(200, 200) {
                    @Override
                    public void onResourceReady(@NonNull Bitmap resource, @Nullable Transition<? super Bitmap> transition) {
                        touchImageView.setImageBitmap(resource);
                    }
                });
    }

    /**
     * 滑动过程停止加载
     *
     * @param context 上下文
     */
    public static void pauseRequest(Context context) {
        Glide.with(context).pauseRequests();
    }

    /**
     * 滑动停止继续加载
     *
     * @param context 上下文
     */
    public static void resumeRequest(Context context) {
        Glide.with(context).resumeRequests();
    }

}
