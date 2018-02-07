package chandu.oyo;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.timessquare.CalendarPickerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Chandu on 2/6/2018.
 */

public class CheckinFragment extends Fragment  {
    String[] day = {"Sun","Mon","Tue","Wed","Thu","Fri","Sat"};
    String[] month = {"Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec"};
    static String selectedDate = "Date";
        @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable final ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.checkin_checkout_fragment,container,false);
        final Calendar nextYear = Calendar.getInstance();
        nextYear.add(Calendar.MONTH,6);

        CalendarPickerView calendar = (CalendarPickerView) rootView.findViewById(R.id.calendar_view);
            TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
            tabLayout.getTabAt(0).setText(selectedDate);
        final Date today = new Date();
        calendar.init(today, nextYear.getTime())
                .withSelectedDate(today);
        calendar.setOnDateSelectedListener(new CalendarPickerView.OnDateSelectedListener() {
            @Override
            public void onDateSelected(Date date) {

                    selectedDate = day[date.getDay()]+","+date.getDate()+" "+month[date.getMonth()];
                ViewPager viewPager= (ViewPager) getActivity().findViewById(R.id.viewpager);
                TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
                int currentItem = viewPager.getCurrentItem();
                    //for changing the tab name
                    tabLayout.getTabAt(currentItem).setText(selectedDate);
                    //for tabs transition
                    viewPager.setCurrentItem(currentItem+1);
                    String checkinDate = date.getDate()+"/"+date.getMonth()+1+"/"+nextYear.get(Calendar.YEAR);
                ((FragmentActivity)getActivity()).setCheckin(selectedDate);
//                    Toast.makeText(getActivity(),checkinDate,Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onDateUnselected(Date date) {

            }
        });
          return rootView;
    }




}
