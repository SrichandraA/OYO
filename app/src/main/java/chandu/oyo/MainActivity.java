package chandu.oyo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.support.annotation.DimenRes;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSmoothScroller;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.support.v7.widget.RecyclerView.SCROLL_STATE_DRAGGING;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    Toolbar toolbar;
    ImageView imageView;
    FloatingActionButton fab;
    TextView checkin,checkout,noofrooms,noofpeople,nooffavs;
    RecyclerView.Adapter adapter;
    LinearLayout checkinLayout,checkoutLayout,roomsandpersons;
    CollapsingToolbarLayout ctl;
 //RecyclerView.LayoutManager layoutManager;
    ArrayList<Room> arrayList = new ArrayList<>();
    int[] img_id = {R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room4,R.drawable.room5,R.drawable.room6,R.drawable.room7,R.drawable.room8,R.drawable.room1,R.drawable.room2,R.drawable.room3,R.drawable.room4,R.drawable.room5,R.drawable.room6,R.drawable.room7,R.drawable.room8};
    int[] strikeprice = {2000,2100,2200,2300,2400,2500,2600,2700,2000,2100,2200,2300,2400,2500,2600,2700};
    int[] originalprice = {1000,1100,1200,1300,1400,1500,1600,1700,1000,1100,1200,1300,1400,1500,1600,1700};
    int[] offer = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    int[] noofratings = {100,200,300,400,500,600,700,800,100,200,300,400,500,600,700,800};
    double[] ratingdigit = {2.2,3.2,4.5,5.0,3.2,3.5,4.4,3.1,2.2,3.2,4.5,5.0,3.2,3.5,4.4,3.1};
    String[] hotelname = {"Paradise","Ramchandra","Hitex","Radisson","Taj Deccan"
    ,"Sheraton Hyderabad","ITC Kakatiya","Taj Banjara","Paradise","Ramchandra","Hitex","Radisson","Taj Deccan"
            ,"Sheraton Hyderabad","ITC Kakatiya","Taj Banjara"};
    String[] hoteladdr = {"Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad","Hyderabad"};
    String[] commentrating = {"Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good","Good","Very Good"};
    String personsString,checkinString,checkoutString,noOfRoomsString;
    static int validity=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = (Toolbar)findViewById(R.id.toolbar);
        ctl = (CollapsingToolbarLayout)findViewById(R.id.collapsingToolbarLayout);
        checkinLayout = (LinearLayout)toolbar.findViewById(R.id.checkinlayout);
        checkoutLayout = (LinearLayout)toolbar.findViewById(R.id.checkoutlayout);
        roomsandpersons = (LinearLayout)toolbar.findViewById(R.id.roomsandpersons);
        imageView = (ImageView)findViewById(R.id.countfav);
        nooffavs = (TextView)findViewById(R.id.nooffavs);

        checkin = (TextView) findViewById(R.id.checkindate);
        checkout = (TextView) findViewById(R.id.checkoutdate);
        noofrooms = (TextView) findViewById(R.id.noofrooms);
        noofpeople = (TextView) findViewById(R.id.noofpeople);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerview);
        fab = (FloatingActionButton)findViewById(R.id.fab);

//        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;
//        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
//        layoutManager = new GridLayoutManager(this,1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemViewCacheSize(20);
        recyclerView.setDrawingCacheEnabled(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE){
                    fab.show();

                }
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        if(validity == 0){
            validity =1;
        }else {
            Log.v("else:","in else");
            personsString = getIntent().getExtras().getString("persons");
            checkinString = getIntent().getExtras().getString("checkin");
            checkoutString = getIntent().getExtras().getString("checkout");
            noOfRoomsString = getIntent().getExtras().getString("rooms");
            checkin.setText(checkinString);
            checkout.setText(checkoutString);
            noofrooms.setText(noOfRoomsString);
            noofpeople.setText(personsString);

        }

        recyclerView.setHasFixedSize(true);
        recyclerView.smoothScrollBy(0,100);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(this, R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        for(int i = 0 ; i < 16 ; i ++){

            arrayList.add(new Room(img_id[i],strikeprice[i],originalprice[i],offer[i]
            ,noofratings[i],ratingdigit[i],hotelname[i],hoteladdr[i],commentrating[i]));
        }

//        for(int i = 0 ; i < 8 ; i ++){
//
//            arrayList.add(new ImageInfo(img_id[i]));
//        }
        adapter = new RecyclerAdapter(arrayList,imageView,nooffavs,MainActivity.this);
//        adapter = new RoomImagesAdapter(arrayList,MainActivity.this);
        recyclerView.setAdapter(adapter);




        checkoutLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FragmentActivity.class);
                i.putExtra("page",1);
                startActivity(i);
            }
        });
        checkinLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FragmentActivity.class);
                i.putExtra("page",0);

                startActivity(i);
            }
        });
        roomsandpersons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,FragmentActivity.class);
                i.putExtra("page",2);

                startActivity(i);
            }
        });

    }

}

