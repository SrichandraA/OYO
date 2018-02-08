package chandu.oyo;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Chandu on 2/8/2018.
 */

public class FacilitiesRecyclerViewAdapter extends RecyclerView.Adapter<FacilitiesRecyclerViewAdapter.MyViewHolder> {
    ArrayList<FacilityData> arrayList = new ArrayList<>();

    public FacilitiesRecyclerViewAdapter(ArrayList<FacilityData> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public FacilitiesRecyclerViewAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.facilityrow,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FacilitiesRecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImg_id());
        holder.textView.setText(arrayList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
    public static class MyViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public MyViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.facilityimg);
            textView = (TextView)itemView.findViewById(R.id.facilityname);
        }
    }
}
