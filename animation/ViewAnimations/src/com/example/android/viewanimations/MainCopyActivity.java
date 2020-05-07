package com.example.android.viewanimations;

import android.animation.AnimatorSet;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.CheckBox;

import java.util.concurrent.TimeUnit;

public class MainCopyActivity extends AppCompatActivity {
    private CheckBox mCheckBox;
    /**
     * 动画时间：1秒
     */
    private static final long ANIMATION_DURATION = TimeUnit.SECONDS.toMillis(1);

    /**
     * 透明动画，由透明度由1到0，从完全可见到完全不可见
     */
    private Animation mAnimationAlpha = new AlphaAnimation(1.0f, 0.0f);

    /**
     * 绝对位置
     */
    private int fromXType = Animation.ABSOLUTE;
    private float fromXValue = 0.0f;
    /**
     * 相对于父容器
     */
    private int toXType = Animation.RELATIVE_TO_PARENT;
    private float toXValue = 1.0f;
    private int fromYType = Animation.ABSOLUTE;
    private float fromYValue = 0.0f;
    private int toYType = Animation.ABSOLUTE;
    private float toYValue = 100f;
    /**
     * 平移
     * {@link TranslateAnimation#TranslateAnimation(int, float, int, float, int, float, int, float)}
     * {@link Animation#ABSOLUTE}
     */
    private Animation mAnimationTranslate = new TranslateAnimation(fromXType, fromXValue,
            toXType, toXValue,
            fromYType, fromYValue,
            toYType, toYValue
    );

    final float fromDegrees = 0f;
    final float toDegrees = 720f;
    /**
     * 相对于自身，旋转圆心x坐标
     */
    final int pivotXType = Animation.RELATIVE_TO_SELF;
    /**
     * 与
     * {@link #pivotXType}搭配，当前x中心
     */
    final float pivotXValue = 0.5f;
    /**
     * 相对于自身，旋转圆心y坐标
     */
    final int pivotYType = Animation.RELATIVE_TO_SELF;
    /**
     * 与
     * {@link #pivotYType}搭配，当前y中心
     */
    final float pivotYValue = 0.5f;
    /**
     * 旋转动画
     */
    private Animation mAnimationRotate = new RotateAnimation(fromDegrees, toDegrees,
            pivotXType, pivotXValue,
            pivotYType, pivotYValue);


    /**
     * 缩放
     */
    private final float fromX = 1f;
    private final float toX = 2f;
    private final float fromY = 0.5f;
    private final float toY = 2f;
    private Animation mAnimationScale = new ScaleAnimation(fromX, toX, fromY, toY);

    private AnimationSet mAnimationSet = new AnimationSet(true);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animations);
        mAnimationAlpha.setDuration(ANIMATION_DURATION);
        mAnimationTranslate.setDuration(ANIMATION_DURATION);
        mAnimationRotate.setDuration(ANIMATION_DURATION);
        mAnimationScale.setDuration(ANIMATION_DURATION);

//        mAnimationSet.addAnimation(mAnimationAlpha);
        mAnimationSet.addAnimation(mAnimationTranslate);
//        mAnimationSet.addAnimation(mAnimationRotate);
        mAnimationSet.addAnimation(mAnimationScale);
        mAnimationSet.setDuration(ANIMATION_DURATION);


        mCheckBox = (CheckBox) findViewById(R.id.checkbox);


        final Button alphaButton = (Button) findViewById(R.id.alphaButton);
        final Button translateButton = (Button) findViewById(R.id.translateButton);
        final Button rotateButton = (Button) findViewById(R.id.rotateButton);
        final Button scaleButton = (Button) findViewById(R.id.scaleButton);
        final Button setButton = (Button) findViewById(R.id.setButton);


        setupAnimation(alphaButton, mAnimationAlpha, R.anim.alpha_anim_copy);
        setupAnimation(translateButton, mAnimationTranslate, R.anim.translate_anim_copy);
        setupAnimation(rotateButton, mAnimationRotate, R.anim.rotate_anim_copy);
        setupAnimation(scaleButton, mAnimationScale, R.anim.scale_anim_copy);
        setupAnimation(setButton, mAnimationSet, R.anim.set_anim_copy);


    }

    private void setupAnimation(View view, final Animation animation,
                                final int animationID) {
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // If the button is checked, load the animation from the given resource
                // id instead of using the passed-in animation paramter. See the xml files
                // for the details on those animations.
                v.startAnimation(mCheckBox.isChecked() ?
                        // TODO: 2020/5/7 加载动画的工具类
                        AnimationUtils.loadAnimation(MainCopyActivity.this, animationID) :
                        animation);
            }
        });
    }
}
