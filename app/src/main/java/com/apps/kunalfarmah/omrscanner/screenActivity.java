package com.apps.kunalfarmah.omrscanner;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class screenActivity extends AppCompatActivity {


    private ImageView mImageView;
    private TextView mTextView;

    Handler h = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen);


        mImageView = findViewById(R.id.my_image);
        mTextView = findViewById(R.id.my_text);


        // Load the animation
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.anim_text);

        // Apply the animation to the ImageView
        mImageView.startAnimation(anim);

        // Apply the animation to the TextView
        mTextView.startAnimation(anim);

        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(screenActivity.this,LoginActivity.class);
                startActivity(i);
                finish();
            }
        },4000);





    }
}