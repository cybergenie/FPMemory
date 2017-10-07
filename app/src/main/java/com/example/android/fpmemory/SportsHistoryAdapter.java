package com.example.android.fpmemory;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import com.example.android.fpmemory.SportsResultHistory;

/**
 * Created by Lee on 2017/10/07.
 */

public class SportsHistoryAdapter extends RecyclerView.Adapter<SportsHistoryAdapter.ViewHolder>{
    private List<SportsResultHistory> mSportsHistoryList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView sportsImage;
        TextView sportsStutas;
        TextView sportsTime;
        TextView sportsResult;
        public ViewHolder(View view) {
            super(view);
            sportsImage = (ImageView) view.findViewById(R.id.image_sports_history);
            sportsStutas = (TextView) view.findViewById(R.id.stutas_sports_history);
            sportsTime = (TextView) view.findViewById(R.id.time_sports_history);
            sportsResult = (TextView) view.findViewById(R.id.result_sports_history);
        }
    }

    public SportsHistoryAdapter(List<SportsResultHistory> sportsHistoryList){
        mSportsHistoryList=sportsHistoryList;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent,int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sports_history_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    public void onBindViewHolder(ViewHolder holder,int position){
        SportsResultHistory sportsResultHistory = mSportsHistoryList.get(position);
        holder.sportsImage.setImageResource(sportsResultHistory.getImageId());
        holder.sportsStutas.setText(sportsResultHistory.getSportsStutas());
        holder.sportsTime.setText(sportsResultHistory.getSportsTime());
        holder.sportsResult.setText(sportsResultHistory.getSportsResult());
    }

    public int getItemCount(){
        return mSportsHistoryList.size();
    }
}
