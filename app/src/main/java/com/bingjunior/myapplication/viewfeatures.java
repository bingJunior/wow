package com.student.crimnalalert;

import androidx.appcompat.app.AppCompatActivity;
        import androidx.core.content.ContextCompat;
        import androidx.viewpager.widget.ViewPager;

        import android.os.Build;
        import android.os.Bundle;
        import android.text.Layout;
        import android.view.View;
        import android.view.ViewGroup;
        import android.view.WindowManager;
        import android.widget.Button;
        import android.widget.ImageView;
        import android.widget.LinearLayout;

public class viewfeatures extends AppCompatActivity {
    private ViewPager mPager;
    private int Layouts[] = {R.layout.slide1, R.layout.slide2, R.layout.slide3, R.layout.slide4};
    private mpagerAdapter mpagerAdapter;
    private LinearLayout dotslayout;
    private ImageView dots[];
    private int currentpage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewfeatures);

//        if (Build.VERSION.SDK_INT >= 19) {
//            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        } else {
//            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//
//        }

        mPager = findViewById(R.id.viewpager);
        dotslayout = findViewById(R.id.dotlayout);


        mpagerAdapter = new mpagerAdapter(Layouts, viewfeatures.this);
        mPager.setAdapter(mpagerAdapter);
//        createdots(0);


        mPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                createdots(position);
                currentpage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void createdots(int current_position) {
        if (dotslayout != null) {
            dotslayout.removeAllViews();
        }
        dots = new ImageView[Layouts.length];
        for (int i = 0; i < Layouts.length; i++) {
            dots[i] = new ImageView(viewfeatures.this);
            if (i == current_position) {
                dots[i].setImageDrawable(ContextCompat.getDrawable(viewfeatures.this,R.drawable.activedots));
            }else{
                dots[i].setImageDrawable(ContextCompat.getDrawable(viewfeatures.this,R.drawable.inactivedots));
            }
            LinearLayout.LayoutParams params=new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(4,0,4,0);
            dotslayout.addView(dots[i],params);
        }
    }

}
