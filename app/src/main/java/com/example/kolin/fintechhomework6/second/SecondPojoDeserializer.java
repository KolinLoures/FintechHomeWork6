package com.example.kolin.fintechhomework6.second;

import android.util.Log;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by kolin on 06.11.2017.
 */

public class SecondPojoDeserializer implements JsonDeserializer<SecondPojo> {

    public static final String TAG = SecondPojoDeserializer.class.getSimpleName();

    @Override
    public SecondPojo deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        SecondPojo temp = new SecondPojo();

        if (json != null){

            JsonObject asJsonObject = json.getAsJsonObject();

            String name = asJsonObject.get("name").getAsString();
            Set<Map.Entry<String, JsonElement>> any_map = asJsonObject.get("any_map").getAsJsonObject().entrySet();

            HashMap<String, String> map = new HashMap<>();

            for (Map.Entry<String, JsonElement> entries : any_map) {
                map.put(entries.getKey(), entries.getValue().getAsString());
            }

            temp.setName(name);
            temp.setAnyMap(map);

            Log.i(TAG, "deserialize: map" + map.toString());
        }

        return temp;
    }
}
