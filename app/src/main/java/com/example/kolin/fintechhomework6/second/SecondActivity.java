package com.example.kolin.fintechhomework6.second;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.kolin.fintechhomework6.R;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;


public class SecondActivity extends AppCompatActivity {

    private static final String KEY_TASK = "TASK";

    private String testJson;
    private Gson gson;

    public static void start(Context context, int task) {
        Intent starter = new Intent(context, SecondActivity.class);
        starter.putExtra(KEY_TASK, task);
        context.startActivity(starter);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        initGson();
        testJson = gson.toJson(createTestJson());
        int task = getIntent().getIntExtra(KEY_TASK, 0);

        ((TextView) findViewById(R.id.text_task)).setText(getResources().getStringArray(R.array.desc_task)[task - 1]);
        ((TextView) findViewById(R.id.text_test_data)).setText(testJson);

        final TextView textView = findViewById(R.id.text_result);

        findViewById(R.id.button_do_it).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SecondPojo secondPojo = gson.fromJson(testJson, SecondPojo.class);
                textView.setText(secondPojo.toString());

                textView.append("\n\nCheck any_map instance of HasMap");
                textView.append("\n" + Boolean.toString(secondPojo.getAnyMap() instanceof HashMap));
            }
        });
    }

    private void initGson() {
        gson = new GsonBuilder()
                .registerTypeAdapter(SecondPojo.class, new SecondPojoDeserializer())
                .setPrettyPrinting()
                .create();
    }

    private JsonObject createTestJson(){
        JsonObject json = new JsonObject();
        json.addProperty("name", "name");

        JsonObject jsonAnyMap = new JsonObject();
        jsonAnyMap.addProperty("a", "55");
        jsonAnyMap.addProperty("b", "85");
        jsonAnyMap.addProperty("c", "56");

        json.add("any_map", jsonAnyMap);

        return json;
    }


}