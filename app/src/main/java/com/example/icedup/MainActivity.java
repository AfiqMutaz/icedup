package com.example.icedup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    ViewFlipper v_flipper;
    ImageView imgView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.image1, R.drawable.image2, R.drawable.image3};

        v_flipper = findViewById(R.id.viewflipper);

        //foreach / for loop through images
        for (int image: images) {
            flipperImages(image);
        }

        imgView = findViewById(R.id.image_1);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ItemDisplay.class);
                startActivity(intent);
            }
        });
    }

    public void flipperImages(int image) {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        v_flipper.addView(imageView);
        v_flipper.setFlipInterval(4000);
        v_flipper.setAutoStart(true);

        //animation
        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
        v_flipper.setOutAnimation(this, android.R.anim.slide_out_right);
    }
}