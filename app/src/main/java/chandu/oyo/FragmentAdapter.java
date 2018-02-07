package chandu.oyo;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.text.Html;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;

/**
 * Created by Chandu on 2/6/2018.
 */

public class FragmentAdapter extends FragmentPagerAdapter {

    public String tabTitles[] = new String[]{"Time", "Time", "Rooms"};

    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment=null;
        if (position == 0 ){
            fragment = new CheckinFragment();
        }
        else if (position == 1){
            fragment = new CheckoutFragment();
        }
        else if (position == 2){
            fragment = new RoomFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {

       return tabTitles[position];
    }

}
