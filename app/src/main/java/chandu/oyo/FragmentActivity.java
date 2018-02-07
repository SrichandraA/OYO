package chandu.oyo;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Chandu on 2/6/2018.
 */

public class FragmentActivity extends AppCompatActivity{
    FragmentAdapter adapter;
    ViewPager viewPager;
    TabLayout tabs;
   static String checkin = "Set Date" ;
   static String checkout = "Set Date";



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
         tabs = (TabLayout) findViewById(R.id.tabs);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        tabs.setTabTextColors(Color.parseColor("#696560"),Color.parseColor("#E50000"));
        adapter = new FragmentAdapter(getSupportFragmentManager());
        tabs.setupWithViewPager(viewPager);

        viewPager.setAdapter(adapter);
        if(getIntent().getExtras().getInt("page") == 1)
        viewPager.setCurrentItem(1);
        else if(getIntent().getExtras().getInt("page") == 2)
            viewPager.setCurrentItem(2);

    }

    public  String getCheckin() {
        return checkin;
    }

    public void setCheckin(String checkin) {
        this.checkin = checkin;
    }

    public String getCheckout() {
        return checkout;
    }

    public void setCheckout(String checkout) {
        this.checkout = checkout;
    }
}
