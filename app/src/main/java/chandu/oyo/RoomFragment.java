package chandu.oyo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.zip.Inflater;

/**
 * Created by Chandu on 2/6/2018.
 */

public class RoomFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RoomRecyclerViewAdapter adapter;
    Button search;
    static TextView noOfRooms;
    Button addroom;
    static String persons = "PERSONS";
    static String rooms = "ROOM/S";

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.rooms_fragment,container,false);
        recyclerView = (RecyclerView) rootView.findViewById(R.id.roomsrecyclerview);
        search = (Button) getActivity().findViewById(R.id.search);
        addroom = (Button) rootView.findViewById(R.id.addroom);
        noOfRooms = (TextView) getActivity().findViewById(R.id.noofrooms);
        layoutManager = new GridLayoutManager(getActivity(),1);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        ItemOffsetDecoration itemDecoration = new ItemOffsetDecoration(getActivity(), R.dimen.item_offset);
        recyclerView.addItemDecoration(itemDecoration);
        adapter = new RoomRecyclerViewAdapter();
        recyclerView.setAdapter(adapter);
        TabLayout tabLayout = (TabLayout) getActivity().findViewById(R.id.tabs);
        tabLayout.getTabAt(2).setText(persons);
        addroom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(recyclerView.getChildCount() != 4)
                adapter.addItem();
                else
                    Toast.makeText(getActivity(),"Only 4 rooms can be booked..!",Toast.LENGTH_SHORT).show();
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int childCount,i,adults=0,children=0;
                for ( childCount = recyclerView.getChildCount(), i = 0; i < childCount; ++i) {
                    RoomRecyclerViewAdapter.MyViewHolder holder = (RoomRecyclerViewAdapter.MyViewHolder) recyclerView.getChildViewHolder(recyclerView.getChildAt(i));
//                    Log.v("kjh",String.valueOf(holder.holderadult));
//                    Log.v("kjh",String.valueOf(holder.holderchild));
                    adults += holder.holderadult;
                    children += holder.holderchild;

                }
                rooms = String.valueOf(childCount)+" ROOM/S";
                noOfRooms.setText(rooms);
                TabLayout tabLayout =(TabLayout)getActivity().findViewById(R.id.tabs);
                persons = adults+" adults, "+children+" children";
                tabLayout.getTabAt(2).setText(persons);
//                Log.v("cin",((FragmentActivity)getActivity()).getCheckin());

                Intent intent = new Intent(getActivity(),MainActivity.class);
                intent.putExtra("persons",persons);
                intent.putExtra("checkin",((FragmentActivity)getActivity()).getCheckin());
                intent.putExtra("checkout",((FragmentActivity)getActivity()).getCheckout());
                intent.putExtra("rooms",rooms);
                intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        return rootView;

    }
}
