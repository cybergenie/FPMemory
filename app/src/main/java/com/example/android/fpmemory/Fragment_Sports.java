package com.example.android.fpmemory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Context;

import java.util.ArrayList;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class Fragment_Sports extends Fragment implements View.OnClickListener{


    public Fragment_Sports() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_sports, container, false);
        ImageView iv_history = (ImageView) view.findViewById(R.id.arrow_history);
        iv_history.setOnClickListener(this);
        ImageView iv_finished = (ImageView) view.findViewById(R.id.arrow_finished);
        iv_finished.setOnClickListener(this);
        ImageView iv_nonfinished = (ImageView) view.findViewById(R.id.arrow_nonfinished);
        iv_nonfinished.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.arrow_history:
                Intent sports_history = new Intent(this.getActivity(), sports_history_content.class);
                startActivity(sports_history);
                break;
            case R.id.arrow_finished:
                Intent sports_finished = new Intent(this.getActivity(), sports_finished_content.class);
                startActivity(sports_finished);
                break;
            case R.id.arrow_nonfinished:
                Intent sports_nonfinished = new Intent(this.getActivity(), sports_nonfinished_content.class);
                startActivity(sports_nonfinished);
                break;
            default:
                break;

        }
    }


    }
