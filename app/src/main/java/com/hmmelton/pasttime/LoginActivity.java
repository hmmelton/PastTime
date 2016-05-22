package com.hmmelton.pasttime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;

public class LoginActivity extends AppCompatActivity {

    private final int ANIM_DURATION = 600; // duration - in ms - of animation
    private View mContentView;
    private View mFbLogin;
    private View mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // content view - contains sub-views for activity
        mContentView = findViewById(R.id.content_login);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // find bars on bottom of screen
        View topBar = mContentView.findViewById(R.id.login_top_bar);
        View middleBar = mContentView.findViewById(R.id.login_middle_bar);
        View bottomBar = mContentView.findViewById(R.id.login_bottom_bar);

        mFbLogin = mContentView.findViewById(R.id.facebook_login_button);

        View topShape = mContentView.findViewById(R.id.login_top_shape);
        mTitle = mContentView.findViewById(R.id.login_title);


        // animation that fades in views
        final Animation fadeIn = new AlphaAnimation(0, 1);
        fadeIn.setInterpolator(new DecelerateInterpolator());
        fadeIn.setDuration(ANIM_DURATION * 2);

        // animation that slides top portion down from top
        Animation slideFromTop = AnimationUtils.loadAnimation(this, R.anim.slide_in_from_top);
        slideFromTop.setInterpolator(new DecelerateInterpolator());
        slideFromTop.setDuration(ANIM_DURATION * 2);
        slideFromTop.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mTitle.setAlpha(1.0f);
                mTitle.startAnimation(fadeIn);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        //**********************************************************************
        // These animations are for the sliding bars on the bottom of the screen
        //**********************************************************************
        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.white_bar_slide_in);
        bottomAnim.setDuration(ANIM_DURATION);

        Animation middleAnim = AnimationUtils.loadAnimation(this, R.anim.white_bar_slide_in);
        middleAnim.setDuration(ANIM_DURATION);
        middleAnim.setStartOffset(ANIM_DURATION / 2);

        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.white_bar_slide_in);
        topAnim.setDuration(ANIM_DURATION);
        topAnim.setStartOffset(ANIM_DURATION);
        topAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                mFbLogin.setAlpha(1.0f);
                mFbLogin.startAnimation(fadeIn);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        bottomBar.startAnimation(bottomAnim);
        middleBar.startAnimation(middleAnim);
        topBar.startAnimation(topAnim);
        topShape.startAnimation(slideFromTop);

    }

    @Override
    protected void onPause() {
        super.onPause();
        mTitle.setAlpha(0.0f);
        mFbLogin.setAlpha(0.0f);
    }
}
