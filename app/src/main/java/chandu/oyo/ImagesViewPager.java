package chandu.oyo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.rd.PageIndicatorView;

/**
 * Created by Chandu on 2/8/2018.
 */

public class ImagesViewPager extends AppCompatActivity {
    ViewPager viewPager;
    ImagesViewPagerAdapter adapter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.images_view_pager);

        viewPager = (ViewPager)findViewById(R.id.viewpager);
        adapter = new ImagesViewPagerAdapter(ImagesViewPager.this);
        viewPager.setAdapter(adapter);

    }
}
