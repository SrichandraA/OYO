package chandu.oyo;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Created by Chandu on 2/8/2018.
 */

public class ImagesViewPagerAdapter extends PagerAdapter {
    int[] img_id = {R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room4,R.drawable.room5,R.drawable.room6,R.drawable.room7,R.drawable.room8,R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room4,R.drawable.room5,R.drawable.room6,R.drawable.room7,R.drawable.room8};
    Context context;
    LayoutInflater layoutInflater;

    public ImagesViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return img_id.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.image_view_pager_row,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.image);
        imageView.setImageResource(img_id[position]);
        container.addView(view);
        return view;
    }
}
