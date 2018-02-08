package chandu.oyo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.like.LikeButton;
import com.like.OnLikeListener;

import java.util.ArrayList;

/**
 * Created by Chandu on 2/5/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyViewHolder> {

    ArrayList<Room> arrayList = new ArrayList<>();
    int prevPosition = 0;
    ImageView imageView;
    TextView textView;
    Context context;
    public  RecyclerAdapter(ArrayList<Room> arrayList, ImageView imageView,TextView textView,Context context){

        this.arrayList=arrayList;
        this.imageView =imageView;
        this.textView = textView;
        this.context = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {

        holder.room_photo.setBackgroundResource(arrayList.get(position).getImg_id());
        holder.rating_comment.setText(arrayList.get(position).getRating_comment());
        holder.hotel_addr.setText(arrayList.get(position).getHotel_addr());
        holder.hotel_name.setText(arrayList.get(position).getHotel_name());
        holder.no_of_ratings.setText(String.valueOf(arrayList.get(position).getNo_of_ratings())+" Ratings >");
        holder.offer.setText(String.valueOf(arrayList.get(position).getOffer())+"% OFF");
        holder.original_price.setText("INR "+String.valueOf(arrayList.get(position).getOriginal_price()));
        holder.rating_digit.setText(String.valueOf(arrayList.get(position).getRating_digit()));
        holder.strike_price.setText("INR "+String.valueOf(arrayList.get(position).getStrike_price()));

        holder.room_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,RoomActivity.class);
                context.startActivity(i);
            }
        });
        holder.fav.setOnLikeListener(new OnLikeListener() {
            @Override
            public void liked(LikeButton likeButton) {

                imageView.setImageResource(R.drawable.fav);
                int numb = Integer.parseInt(textView.getText().toString())+1;
                textView.setText(String.valueOf(numb));

            }

            @Override
            public void unLiked(LikeButton likeButton) {
                int numb = Integer.parseInt(textView.getText().toString())-1;
                if(numb <= 0){
                    imageView.setImageResource(R.drawable.notfav);
                    textView.setText(String.valueOf(numb));

                }
                else
                    textView.setText(String.valueOf(numb));


            }
        });

        if(position > prevPosition){

            AnimationUtil.animate(holder,true);
        }else {
            AnimationUtil.animate(holder,false);

        }

        prevPosition = position;

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{


        LikeButton fav;
        RelativeLayout room_photo;
        TextView strike_price,original_price,offer,no_of_ratings,rating_digit,hotel_name,hotel_addr,rating_comment;
        public MyViewHolder(View itemView) {
            super(itemView);
            room_photo = (RelativeLayout) itemView.findViewById(R.id.roomphoto);
            fav = (LikeButton) itemView.findViewById(R.id.fav);
            strike_price = (TextView) itemView.findViewById(R.id.strikeprice);
            original_price = (TextView) itemView.findViewById(R.id.originalprice);
            offer = (TextView) itemView.findViewById(R.id.offer);
            no_of_ratings = (TextView) itemView.findViewById(R.id.noofratings);
            rating_digit = (TextView) itemView.findViewById(R.id.ratingdigit);
            hotel_name = (TextView) itemView.findViewById(R.id.hotelname);
            hotel_addr = (TextView) itemView.findViewById(R.id.hoteladdress);
            rating_comment = (TextView) itemView.findViewById(R.id.ratingcomment);
        }
    }
}
