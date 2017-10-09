package com.example.android.fpmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static com.example.android.fpmemory.R.id.none;


public class Heartrate_Content extends Fragment implements View.OnClickListener{

    private ImageView heartImage;
    private RelativeLayout recycleviewLayout;
    private TextView recycleview_head;

    private boolean recycleview_full=false;

    private List<SportsResultHistory> sportsResultHistories = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.subfg_health_heartrate, null);
        heartImage = (ImageView)view.findViewById(R.id.heart);
        Animation heartrateOnMeasure = AnimationUtils.loadAnimation(this.getActivity().getApplicationContext(),R.anim.heartrate_measure);
        heartImage.startAnimation(heartrateOnMeasure);
        initSportsResultHistory();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.heartrate_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        SportsHistoryAdapter sportsHistoryAdapter = new SportsHistoryAdapter(sportsResultHistories);
        recyclerView.setAdapter(sportsHistoryAdapter);


        recycleviewLayout = (RelativeLayout)view.findViewById(R.id.recycleview);
        recycleview_head = (TextView)view.findViewById(R.id.recycleview_head);

        recycleview_head.setOnClickListener(this);

        return view;
    }

    private void initSportsResultHistory(){
        sportsResultHistories.clear();
       SportsResultHistory sport1 = new SportsResultHistory(R.mipmap.runner,"运动后","2017/10/07 16:37","103");
       SportsResultHistory sport2 = new SportsResultHistory(R.mipmap.runner,"运动后","2017/10/05 16:37","106");
        sportsResultHistories.add(sport1);
        sportsResultHistories.add(sport2);

    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.recycleview_head: {
                if (recycleview_full == true) {
                    RelativeLayout.LayoutParams lyParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    lyParams.addRule(RelativeLayout.BELOW, R.id.heartrate_circle);
                    recycleviewLayout.setLayoutParams(lyParams);
                    recycleview_full = false;
                } else {
                    RelativeLayout.LayoutParams lyParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                    lyParams.addRule(RelativeLayout.BELOW, none);
                    recycleviewLayout.setLayoutParams(lyParams);
                    recycleview_full = true;
                }
                break;
            }
            default:
                break;

        }
    }
}
