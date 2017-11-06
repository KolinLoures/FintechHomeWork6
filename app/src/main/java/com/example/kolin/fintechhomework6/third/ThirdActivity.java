package com.example.kolin.fintechhomework6.third;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.kolin.fintechhomework6.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.math.BigDecimal;
import java.util.HashMap;

public class ThirdActivity extends AppCompatActivity {

    private static final String KEY_TASK = "TASK";
    private static final String TAG = ThirdActivity.class.getSimpleName();

    private Gson gson;
    private String testJson;

    public static void start(Context context, int task) {
        Intent starter = new Intent(context, ThirdActivity.class);
        starter.putExtra(KEY_TASK, task);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setTitle(R.string.third_task);
        }

        initGson();
        testJson = gson.toJson(createTestJson());
        int task = getIntent().getIntExtra(KEY_TASK, 0);

        ((TextView) findViewById(R.id.text_task)).setText(getResources().getStringArray(R.array.desc_task)[task - 1]);
        ((TextView) findViewById(R.id.text_test_data)).setText(testJson);
        final TextView result = findViewById(R.id.text_result);

        findViewById(R.id.button_do_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BigDecimal bigDecimal = gson.fromJson(testJson, BigDecimal.class);

                result.setText("Result : " + bigDecimal.toString());
            }
        });
    }

    private void initGson() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(BigDecimal.class, new BigDecimalDeserializer())
                .create();
    }

    private JsonObject createTestJson() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("money_amount", "2444,88");
        return jsonObject;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        finish();
    }
}
