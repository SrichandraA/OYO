package chandu.oyo;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chandu on 2/8/2018.
 */

public class RoomActivity extends AppCompatActivity {

    int[] img_id = {R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room4,R.drawable.room5,R.drawable.room6,R.drawable.room7,R.drawable.room8};
    int[] facility_img_id = {R.drawable.facility1,R.drawable.facility2,R.drawable.facility3,R.drawable.facility4,R.drawable.facility5,R.drawable.facility1,R.drawable.facility2,R.drawable.facility3,R.drawable.facility4,R.drawable.facility5};
    String[] facility_name = {"Beds","Wi-fi","Acodomocoes","Sitting","Swimming","Beds","Wi-fi","Acodomocoes","Sitting","Swimming"};
    int[] strikeprice = {2000,2100,2200,2300,2400,2500,2600,2700};
    int[] originalprice = {1000,1100,1200,1300,1400,1500,1600,1700};
    int[] offer = {10,10,10,10,10,10,10,10};
    int[] noofratings = {100,200,300,400,500,600,700,800};
    double[] ratingdigit = {2.2,3.2,4.5,5.0,3.2,3.5,4.4,3.1};
    String[] hotelname = {"Paradise","Ramchandra","Hitex","Radisson","Taj Deccan"
            ,"Sheraton Hyderabad","ITC Kakatiya","Taj Banjara"};
    String[] hoteladdr = {"Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad"};
    String[] commentrating = {"Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good"};


    RecyclerView recyclerView;
    ArrayList<ImageInfo> arrayList = new ArrayList<>();
    ArrayList<FacilityData> facilityArrayList = new ArrayList<>();
    ArrayList<Room> roomArrayList = new ArrayList<>();
    RoomImagesAdapter adapter;
    ImageView bottomsheeticon;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        recyclerView = (RecyclerView) findViewById(R.id.imageRecyclerView);
        bottomsheeticon = (ImageView) findViewById(R.id.bottomsheeticon);
        bottomSheet();
        layoutManager = new GridLayoutManager(RoomActivity.this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        for(int i = 0; i < img_id.length; i++ ){
            arrayList.add(new ImageInfo(img_id[i]));
        }
        adapter = new RoomImagesAdapter(arrayList,RoomActivity.this);
        recyclerView.setAdapter(adapter);
        bottomsheeticon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bottomSheet();
            }
        });



    }
    public void bottomSheet(){

        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(RoomActivity.this);
        View parentView = getLayoutInflater().inflate(R.layout.room_bottom_sheet,null);
        bottomSheetDialog.setContentView(parentView);
        BottomSheetBehavior bottomSheetBehavior = BottomSheetBehavior.from((View) parentView.getParent());

        bottomSheetBehavior.setPeekHeight(
                (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,370,getResources().getDisplayMetrics())
        );
        RecyclerView recyclerView = (RecyclerView)parentView.findViewById(R.id.facilitiesrecyclerview);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(RoomActivity.this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        for(int i = 0; i < facility_img_id.length; i++ ){
            facilityArrayList.add(new FacilityData(facility_img_id[i],facility_name[i]));
        }
        FacilitiesRecyclerViewAdapter adapter = new FacilitiesRecyclerViewAdapter(facilityArrayList);
        recyclerView.setAdapter(adapter);

        RecyclerView similarRoomsRecyclerView = (RecyclerView)parentView.findViewById(R.id.similarroomsrecyclerview);
        StaggeredGridLayoutManager similarRoomsLinearLayoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL);
        similarRoomsRecyclerView.setLayoutManager(similarRoomsLinearLayoutManager);
        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup vg = (ViewGroup) inflater.inflate(R.layout.activity_main, null);
        TextView textView = (TextView)vg.findViewById(R.id.nooffavs);
        ImageView imageView = (ImageView) vg.findViewById(R.id.countfav);
        for(int i = 0 ; i < 8 ; i ++){

            roomArrayList.add(new Room(img_id[i],strikeprice[i],originalprice[i],offer[i]
                    ,noofratings[i],ratingdigit[i],hotelname[i],hoteladdr[i],commentrating[i]));
        }
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        similarRoomsRecyclerView.addItemDecoration(itemDecoration);
        similarRoomsRecyclerView.setHasFixedSize(true);
        RecyclerAdapter similarRoomsAdapter = new RecyclerAdapter(roomArrayList,imageView,textView,RoomActivity.this);
        similarRoomsRecyclerView.setAdapter(similarRoomsAdapter);


        bottomSheetDialog.show();
    }
}
