package com.example.android.fpmemory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.SubscriptSpan;
import android.text.style.SuperscriptSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class Bloodoxygen_Content extends Fragment {

    private List<SportsResultHistory> sportsResultHistories = new ArrayList<>();
    SpannableString msp = null;
    TextView unitBloodOxygen;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.subfg_health_bloodoxygen, null);
        msp=new SpannableString("%SpO2");
        msp.setSpan(new SubscriptSpan(), 4,5, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        unitBloodOxygen=(TextView)view.findViewById(R.id.unit_bloodoxygen);
        unitBloodOxygen.setText(msp);
        unitBloodOxygen.setMovementMethod(LinkMovementMethod.getInstance());

        initSportsResultHistory();
        RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.heartrate_history);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        SportsHistoryAdapter sportsHistoryAdapter = new SportsHistoryAdapter(sportsResultHistories);
        recyclerView.setAdapter(sportsHistoryAdapter);
        return view;
    }

    private void initSportsResultHistory() {
        sportsResultHistories.clear();
        SportsResultHistory sport1 = new SportsResultHistory(R.mipmap.pnull, "运动后", "2017/10/07 16:37", "95");
        SportsResultHistory sport2 = new SportsResultHistory(R.mipmap.pnull, "运动后", "2017/10/05 16:37", "109/76");
        sportsResultHistories.add(sport1);
    }
}

