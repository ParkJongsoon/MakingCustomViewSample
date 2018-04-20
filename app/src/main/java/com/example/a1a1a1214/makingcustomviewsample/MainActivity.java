package com.example.a1a1a1214.makingcustomviewsample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private String TAG = "MAINACTIVTY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyCustomView indicator = (MyCustomView) findViewById(R.id.indicator);
        findViewById(R.id.MainActivity_BTN).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //선택된 별을 가져온다.
                int selected = indicator.getSelected();
                if(selected == 2)
                {
                    //맨 오른쪽에 있을 때는 처음으로 돌아간다.
                    selected = 0;
                }
                else
                {
                    //1개씩 오른쪽으로 이동
                    selected++;
                }
                Log.d(TAG, "selected = " + selected);
                //선택상태 갱신!
                indicator.setSelected(selected);
            }
        });
    }

}
