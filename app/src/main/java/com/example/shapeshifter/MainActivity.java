package com.example.shapeshifter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    AnimatedVectorDrawable avd;
    AnimatedVectorDrawable ava;
    int switchNumber;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ImageView animatedImage = findViewById(R.id.animatedImageView);
        AnimatedVectorDrawable animation = (AnimatedVectorDrawable) animatedImage.getDrawable();



        animatedImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (switchNumber == 0) {
                    animatedImage.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.avd_play_to_pause));
                } else {
                    animatedImage.setImageDrawable(ContextCompat.getDrawable(MainActivity.this, R.drawable.avd_pause_to_play));
                }
                Drawable drawable = animatedImage.getDrawable();
                if (drawable instanceof AnimatedVectorDrawableCompat) {
                    avd = (AnimatedVectorDrawable) drawable;
                    avd.start();
                } else if (drawable instanceof AnimatedVectorDrawable) {
                    ava = (AnimatedVectorDrawable) drawable;
                    ava.start();
                }
                switchNumber = 1 - switchNumber;

            }
        });
    }

}