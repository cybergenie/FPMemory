package com.example.android.fpmemory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Jay on 2015/8/28 0028.
 */
public class Fragment_Me extends Fragment {

    public Fragment_Me() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_content,container,false);

        return view;
    }
}
