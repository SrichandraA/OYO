package chandu.oyo;

import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Chandu on 2/7/2018.
 */

public class RoomRecyclerViewAdapter extends RecyclerView.Adapter<RoomRecyclerViewAdapter.MyViewHolder> {

    int prevPosition = 0;
    int currentPosition;
    int itemcount;

    ArrayList<Integer> arrayList = new ArrayList<>();
    public  RoomRecyclerViewAdapter(){
            arrayList.add(1);
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.roomrow,parent,false);

        return new MyViewHolder(view);
    }

    public void addItem(){

        arrayList.add(2);
        notifyDataSetChanged();
    }
    public void removeItem(int position){

        arrayList.remove(position);
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final int[] totaladult = {1};
        final int[] totalChildren = {0};
        final int[] total = {0};
        holder.holderchild = 0;
        holder.holderadult = 1;

        if(position > prevPosition){

            AnimationUtil.animate(holder,true);
        }else {
            AnimationUtil.animate(holder,false);

        }
        if(holder.getAdapterPosition() == 0){
            holder.close.setVisibility(View.GONE);
        }
        holder.close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                removeItem(holder.getAdapterPosition());
            }
        });
        holder.adult1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.adult1.setBackgroundColor(Color.parseColor("#E50000"));

                holder.adult2.setBackgroundResource(R.drawable.ripple);
                holder.adult3.setBackgroundResource(R.drawable.ripple);

//                holder.adult2.setBackgroundColor(Color.WHITE);
//                holder.adult3.setBackgroundColor(Color.WHITE);
                holder.adult1.setTextColor(Color.WHITE);
                holder.adult2.setTextColor(Color.BLACK);
                holder.adult3.setTextColor(Color.BLACK);
                totaladult[0] = Integer.parseInt(holder.adult1.getText().toString());
                total[0] = totaladult[0] + totalChildren[0];
                holder.holderadult = totaladult[0];
                holder.holderchild = totalChildren[0];

            }
        });
        holder.adult2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalChildren[0] <= 2) {
                    holder.adult2.setBackgroundColor(Color.parseColor("#E50000"));
//                    holder.adult1.setBackgroundColor(Color.WHITE);
//                    holder.adult3.setBackgroundColor(Color.WHITE);
                    holder.adult1.setBackgroundResource(R.drawable.ripple);
                    holder.adult3.setBackgroundResource(R.drawable.ripple);
                    holder.adult2.setTextColor(Color.WHITE);
                    holder.adult1.setTextColor(Color.BLACK);
                    holder.adult3.setTextColor(Color.BLACK);
                    totaladult[0] = Integer.parseInt(holder.adult2.getText().toString());
                    total[0] = totaladult[0] + totalChildren[0];
                    holder.holderadult = totaladult[0];
                    holder.holderchild = totalChildren[0];

                }
            }
        });
        holder.adult3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(totalChildren[0] <= 1) {
                    holder.adult3.setBackgroundColor(Color.parseColor("#E50000"));
//                    holder.adult1.setBackgroundColor(Color.WHITE);
//                    holder.adult2.setBackgroundColor(Color.WHITE);
                    holder.adult2.setBackgroundResource(R.drawable.ripple);
                    holder.adult1.setBackgroundResource(R.drawable.ripple);
                    holder.adult3.setTextColor(Color.WHITE);
                    holder.adult2.setTextColor(Color.BLACK);
                    holder.adult1.setTextColor(Color.BLACK);
                    totaladult[0] = Integer.parseInt(holder.adult3.getText().toString());
                    total[0] = totaladult[0] + totalChildren[0];
                    holder.holderadult = totaladult[0];
                    holder.holderchild = totalChildren[0];

                }
            }
        });
        holder.checkBox.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if(holder.checkBox.isChecked()){

                    holder.childlayout.setVisibility(View.VISIBLE);
                    totalChildren[0] = 1;
                    holder.holderchild = totalChildren[0];
                    total[0] = totaladult[0] + totalChildren[0];
                }

                else if (!holder.checkBox.isChecked()){

                    holder.childlayout.setVisibility(View.GONE);
                    totalChildren[0] = 0;
                    holder.holderchild = totalChildren[0];
                    total[0] = totaladult[0] + totalChildren[0];


                }
            }
        });

            holder.childincrease.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(total[0]  < 4) {
                        int i = Integer.parseInt(holder.childcount.getText().toString()) + 1;
                        Log.v("d", String.valueOf(i));
                        totalChildren[0] += 1;
                        total[0] = totaladult[0] + totalChildren[0];
                        holder.holderchild = totalChildren[0];
                        holder.childcount.setText(String.valueOf(i));
                    }

                }
            });

        holder.childdecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(total[0] > 2 && totalChildren[0] >= 2) {
                    int i = Integer.parseInt(holder.childcount.getText().toString()) - 1;
                    Log.v("i", String.valueOf(i));
                    totalChildren[0] -= 1;
                    total[0] = totaladult[0] + totalChildren[0];
                    holder.holderchild = totalChildren[0];
                    holder.childcount.setText(String.valueOf(i));
                }
            }
        });
        prevPosition = position;
        currentPosition = position;
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView adult1,adult2,adult3,childcount,childdecrease,childincrease,close;
        CheckBox checkBox;
        LinearLayout childlayout;
        int holderchild ;
        int holderadult ;


        public MyViewHolder(View itemView) {
            super(itemView);

            close = (TextView)itemView.findViewById(R.id.close);
            adult1 = (TextView)itemView.findViewById(R.id.adult1);
            adult2 = (TextView)itemView.findViewById(R.id.adult2);
            adult3 = (TextView)itemView.findViewById(R.id.adult3);
            childcount = (TextView)itemView.findViewById(R.id.childcount);
            childincrease = (TextView)itemView.findViewById(R.id.childincrease);
            childdecrease = (TextView)itemView.findViewById(R.id.childdecrease);
            checkBox = (CheckBox)itemView.findViewById(R.id.ticbox);
            childlayout = (LinearLayout) itemView.findViewById(R.id.childlayout);


        }
    }
}
