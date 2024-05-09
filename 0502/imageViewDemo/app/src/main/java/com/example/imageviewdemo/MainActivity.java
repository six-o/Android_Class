package com.example.imageviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private ImageView image, image1, image2, image3, image4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = (ImageView) findViewById(R.id.imgOutput);
        RadioGroup rgImages = (RadioGroup) findViewById(R.id.rgImages);


        image1 = (ImageView) findViewById(R.id.imageView1);
        image2 = (ImageView) findViewById(R.id.imageView2);
        image3 = (ImageView) findViewById(R.id.imageView3);
        image4 = (ImageView) findViewById(R.id.imageView4);
        image1.setVisibility(ImageView.GONE);
        image2.setVisibility(ImageView.GONE);
        image3.setVisibility(ImageView.GONE);
        image4.setVisibility(ImageView.GONE);

        rgImages.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(checkedId == R.id.rdbDog) {
                    image.setImageResource(R.mipmap.dog);
                    image1.setVisibility(ImageView.VISIBLE);
                    image2.setVisibility(ImageView.GONE);
                    image3.setVisibility(ImageView.GONE);
                    image4.setVisibility(ImageView.GONE);
                } else if(checkedId == R.id.rdbElephant) {
                    image.setImageResource(R.mipmap.elephant);
                    image1.setVisibility(ImageView.GONE);
                    image2.setVisibility(ImageView.VISIBLE);
                    image3.setVisibility(ImageView.GONE);
                    image4.setVisibility(ImageView.GONE);
                } else if(checkedId == R.id.rdbMouse) {
                    image.setImageResource(R.mipmap.mouse);
                    image1.setVisibility(ImageView.GONE);
                    image2.setVisibility(ImageView.GONE);
                    image3.setVisibility(ImageView.VISIBLE);
                    image4.setVisibility(ImageView.GONE);
                } else if(checkedId == R.id.rdbRabbit) {
                    image.setImageResource(R.mipmap.rabbit);
                    image1.setVisibility(ImageView.GONE);
                    image2.setVisibility(ImageView.GONE);
                    image3.setVisibility(ImageView.GONE);
                    image4.setVisibility(ImageView.VISIBLE);
                }
//                switch (checkedId) {
//                    case R.id.rdbDog:
//                        image.setImageResource(R.mipmap.dog);
//                    case R.id.rdbElephant:
//                        image.setImageResource(R.mipmap.elephant);
//                    case R.id.rdbMouse:
//                        image.setImageResource(R.mipmap.mouse);
//                    case R.id.rdbRabbit:
//                        image.setImageResource(R.mipmap.rabbit);
//                }
            }
        });
    }
}