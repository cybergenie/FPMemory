package com.example.android.fpmemory;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.android.fpmemory.PullDoorView;

public class Heartrate_Content extends Fragment {
    private Button mBut;
    private PullDoorView mView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        View view = inflater.inflate(R.layout.subfg_health_heartrate, null);
        mBut = (Button) this.getActivity().findViewById(R.id.but);
        mView = (PullDoorView) this.getActivity().findViewById(R.id.myImage);
        mBut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mView.showImgAnimation();
            }
        });
        return view;
    }
}

//package com.test.animation;
//
//        import android.os.Bundle;
//        import android.support.v7.app.AppCompatActivity;
//        import android.view.View;
//        import android.widget.Button;
//
//        import com.test.animation.view.PullDoorView;
//
//public class MainActivity extends AppCompatActivity {
//    private Button mBut;
//    private PullDoorView mView;
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        mBut = (Button) findViewById(R.id.but);
//        mView = (PullDoorView) findViewById(R.id.myImage);
//        mBut.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mView.showImgAnimation();
//            }
//        });
//
//    }
//}

