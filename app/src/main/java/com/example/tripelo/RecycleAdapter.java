package com.example.tripelo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tripelo.RoomDB.ResultStringInt;

import java.util.ArrayList;
import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {


   int id ;
   String time,title,price;
    ArrayList<ResultStringInt> list;
    public RecycleAdapter(HomeFragment homeFragment, ArrayList<ResultStringInt> fillRecyclehome) {
        list = new ArrayList<ResultStringInt>(fillRecyclehome);



    }




    @NonNull
    @Override
    public RecycleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycle_desine,parent,false);

        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecycleAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView recycle_title,recycle_time,recycle_price;
        public ViewHolder(@NonNull View itemView) {

            super(itemView);
            recycle_title =itemView.findViewById(R.id.recycle_title);
            recycle_price = itemView.findViewById(R.id.recycle_price);
            recycle_time = itemView.findViewById(R.id.recycle_time);
        }
    }
}
