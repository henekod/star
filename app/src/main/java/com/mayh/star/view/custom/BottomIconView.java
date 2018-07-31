package com.mayh.star.view.custom;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;

/**
 * @author mayuhua
 * @date   2018/5/24
 *
 * @desc   主页底部Tab图标类，分正常和选中两种状态
 *         根据滑动的偏移量来改变Alpha的值
 */

public class BottomIconView extends AppCompatImageView {
    public static final int START_POSITION = 0;
    public static final int ALPHA_MAX = 255;

    // 画笔
    private Paint mPaint;

    // 选中时的图标
    private Bitmap mIconSelected;

    // 未选中时的图标
    private Bitmap mIconNormal;

    // 选中时的矩形(限制绘制范围)
    private Rect mRectSelected;

    // 未选中时的矩形(限制绘制范围)
    private Rect mRectNormal;

    // 当前的alpha值
    private int mAlphaCurrent = 0;

    public BottomIconView(Context context) {
        super(context);
    }

    public BottomIconView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public BottomIconView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化
     * @param normal
     * @param selected
     * @throws Exception
     */
    public final void init(int normal, int selected) throws Exception {
        mIconNormal = createBitmap(normal);
        mIconSelected = createBitmap(selected);
        // 创建不了图片
        if (mIconNormal == null || mIconSelected == null)
            throw new Exception("icon id can not create1 bitmap");

        // 根据位图创建对应的矩形
        mRectNormal = new Rect(START_POSITION, START_POSITION, mIconNormal.getWidth(), mIconNormal.getHeight());
        mRectSelected = new Rect(START_POSITION, START_POSITION, mIconSelected.getWidth(), mIconSelected.getHeight());

        // 实例化画笔
        mPaint = new Paint(1);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // 画笔为空，直接返回
        if (mPaint == null)
            return;
        // 设置当前选中图标的alpha值(逐渐减少)
        mPaint.setAlpha(ALPHA_MAX - mAlphaCurrent);
        canvas.drawBitmap(mIconNormal, null, mRectNormal, mPaint);
        // 设置目标图标的alpha值(逐渐增大)
        mPaint.setAlpha(mAlphaCurrent);
        canvas.drawBitmap(mIconSelected, null, mRectSelected, mPaint);
    }

    /**
     * 根据资源ID创建位图
     * @param resId
     * @return
     */
    private Bitmap createBitmap(int resId){
        return BitmapFactory.decodeResource(getResources(), resId);
    }

    /**
     * 改变alpha值
     * @param alpha
     */
    public final void changeSelectedAlpha(int alpha){
        mAlphaCurrent = alpha;
        invalidate();
    }

    /**
     * ViewPager切换时
     * @param offset
     */
    public final void transformPage(float offset){
        changeSelectedAlpha((int)(ALPHA_MAX * (1 - offset)));
    }
}
