package com.example.kolin.fintechhomework6.first;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kolin.fintechhomework6.R;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class FirstActivity extends AppCompatActivity {

    private static final String KEY_TASK = "TASK";

    private Gson gson;
    private DogOwner testData;
    private TextView resultText;

    public static void start(Context context, int task) {
        Intent starter = new Intent(context, FirstActivity.class);
        starter.putExtra(KEY_TASK, task);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.first_task);
        }

        initGson();
        testData = createTestData();

        int task = getIntent().getIntExtra(KEY_TASK, 0);

        ((TextView) findViewById(R.id.text_task)).setText(getResources().getStringArray(R.array.desc_task)[task - 1]);
        ((TextView) findViewById(R.id.text_test_data)).setText(testData.toString());
        resultText = findViewById(R.id.text_result);

        findViewById(R.id.button_do_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String json = gson.toJson(testData, DogOwner.class);
                resultText.setText(json);
            }
        });
    }

    private DogOwner createTestData() {
        return new DogOwner(10, "Nikolay Kirilov", 22, new Dog("Xoroshii malchik", 234));
    }

    private void initGson() {
        //TODO set @Expose(serialize = false) to fields that you do not want to serialize or use this
        gson = new GsonBuilder()
                .setExclusionStrategies(
                        new ExclusionStrategy() {
                            @Override
                            public boolean shouldSkipField(FieldAttributes f) {
                                //set to remove field age from result json

                                return f.getName().equals("age");
                            }

                            @Override
                            public boolean shouldSkipClass(Class<?> clazz) {
                                //set to remove class Dog
                                return clazz == Dog.class;
                            }
                        })
                .setPrettyPrinting()
                .create();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
