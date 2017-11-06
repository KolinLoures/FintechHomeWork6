package com.example.kolin.fintechhomework6.fourth;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TimeUtils;
import android.view.View;
import android.widget.TextView;

import com.example.kolin.fintechhomework6.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Calendar;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class FourthActivity extends AppCompatActivity {

    private static final String KEY_TASK = "TASK";

    private Gson gson;

    public static void start(Context context, int task) {
        Intent starter = new Intent(context, FourthActivity.class);
        starter.putExtra(KEY_TASK, task);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.fourth_task);
        }

        initGson();
        final DateExample testObject = createTestObject();
        int task = getIntent().getIntExtra(KEY_TASK, 0);

        ((TextView) findViewById(R.id.text_task)).setText(getResources().getStringArray(R.array.desc_task)[task - 1]);
        ((TextView) findViewById(R.id.text_test_data)).setText(testObject.toString());

        final TextView result = findViewById(R.id.text_result);

        findViewById(R.id.button_do_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = gson.toJson(testObject, DateExample.class);
                result.setText(json);
            }
        });
    }

    public DateExample createTestObject(){
        return new DateExample(new Date(Calendar.getInstance().getTimeInMillis()));
    }

    private void initGson() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .setDateFormat("yyyy-MM-dd")
                .create();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
