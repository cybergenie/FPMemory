package com.example.android.fpmemory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class sports_history_content extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sports_history_content);
        ImageView ivArrowback = (ImageView) this.findViewById(R.id.item_sports_history_back);
        ivArrowback.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.item_sports_history_back:
                finish();
                break;
            default:
                break;
        }

    }
}

