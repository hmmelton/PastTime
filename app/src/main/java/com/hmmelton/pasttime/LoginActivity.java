package com.hmmelton.pasttime;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class LoginActivity extends AppCompatActivity {

    private final int ANIM_DURATION = 600; // duration - in ms - of animation

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();

        // content view - contains sub-views for activity
        View contentView = findViewById(R.id.content_login);

        // find bars on bottom of screen
        final View topBar = contentView.findViewById(R.id.login_top_bar);
        final View middleBar = contentView.findViewById(R.id.login_middle_bar);
        View bottomBar = contentView.findViewById(R.id.login_bottom_bar);

        Animation bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_bar_slide_in);
        bottomAnim.setDuration(ANIM_DURATION);

        Animation middleAnim = AnimationUtils.loadAnimation(this, R.anim.middle_bar_slide_in);
        middleAnim.setDuration(ANIM_DURATION);

        Animation topAnim = AnimationUtils.loadAnimation(this, R.anim.top_bar_slide_in);
        topAnim.setDuration(ANIM_DURATION);

        bottomBar.startAnimation(bottomAnim);
        middleBar.startAnimation(middleAnim);
        topBar.startAnimation(topAnim);

    }
}
