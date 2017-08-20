package com.example.android.fpmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class Fragment_Recover extends Fragment implements View.OnClickListener{

    public Fragment_Recover() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_recover,container,false);
        Button btn_rate = (Button)view.findViewById(R.id.btn_rate);
        btn_rate.setOnClickListener(this);
        Button btn_sports = (Button)view.findViewById(R.id.btn_sports);
        btn_sports.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_rate:
                Intent rate_intent = new Intent(getActivity(),rate_content.class);
                startActivity(rate_intent);
                break;
            case R.id.btn_sports:
                Intent sports_intent = new Intent(getActivity(),sports_content.class);
                startActivity(sports_intent);
                break;
            default:
                break;

        }

    }


}
