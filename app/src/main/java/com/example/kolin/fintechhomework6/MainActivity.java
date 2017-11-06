package com.example.kolin.fintechhomework6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.kolin.fintechhomework6.first.FirstActivity;
import com.example.kolin.fintechhomework6.fourth.FourthActivity;
import com.example.kolin.fintechhomework6.second.SecondActivity;
import com.example.kolin.fintechhomework6.third.ThirdActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_activity_btn_first_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstActivity.start(MainActivity.this, 1);
            }
        });

        findViewById(R.id.main_activity_btn_second_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondActivity.start(MainActivity.this, 2);
            }
        });

        findViewById(R.id.main_activity_btn_third_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ThirdActivity.start(MainActivity.this, 3);
            }
        });

        findViewById(R.id.main_activity_btn_fourth_task).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FourthActivity.start(MainActivity.this, 4);
            }
        });


    }
}
