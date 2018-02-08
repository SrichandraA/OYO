package chandu.oyo;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

/**
 * Created by Chandu on 2/8/2018.
 */

public class RoomImagesAdapter extends RecyclerView.Adapter<RoomImagesAdapter.MyViewHolder> {
    ArrayList<ImageInfo> arrayList = new ArrayList<>();
    Context context;


    public RoomImagesAdapter(ArrayList<ImageInfo> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;

    }

    @Override
    public RoomImagesAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.imagerow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RoomImagesAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImg_id());
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context,ImagesViewPager.class);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.img);
        }
    }
}
