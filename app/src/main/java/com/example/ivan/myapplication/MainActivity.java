package com.example.ivan.myapplication;

import android.app.WallpaperManager;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.IOException;

public class MainActivity extends FragmentActivity{
    ViewPager pager;
    PagerAdapter pagerAdapter;
    private int chw18[]=new int[]{R.drawable.chw1, R.drawable.chw2, R.drawable.chw3, R.drawable.chw4,
            R.drawable.chw5, R.drawable.chw6, R.drawable.chw7, R.drawable.chw8, R.drawable.chw9,
            R.drawable.chw10 };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button setWlpBtn = (Button) findViewById(R.id.setWlpBtn);
        setWlpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WallpaperManager wallpaperManager =
                        WallpaperManager.getInstance(getApplicationContext());
                try {

                    wallpaperManager.setResource(chw18[pager.getCurrentItem()]);

                    // success toast
                    Context context = getApplicationContext();
                    CharSequence text = "Обои успешно установлены!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        pager = (ViewPager) findViewById(R.id.viewPager);
        pagerAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());
        pager.setAdapter(pagerAdapter);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i2) {

            }

            @Override
            public void onPageSelected(int i) {

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    private class MyFragmentPageAdapter extends FragmentPagerAdapter {

        private int chw18[]=new int[]{R.drawable.chw1, R.drawable.chw2, R.drawable.chw3, R.drawable.chw4,
                R.drawable.chw5, R.drawable.chw6, R.drawable.chw7, R.drawable.chw8, R.drawable.chw9,
                R.drawable.chw10 };

        private int imagesCount = chw18.length;

        public MyFragmentPageAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return PageFragment.newInstance(chw18[i]);
        }

        @Override
        public int getCount() {
            return imagesCount;
        }

    }
}
