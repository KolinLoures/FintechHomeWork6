package com.example.kolin.fintechhomework6.third;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;


/**
 * Created by kolin on 06.11.2017.
 */

public class BigDecimalDeserializer implements JsonDeserializer<BigDecimal> {
    @Override
    public BigDecimal deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        BigDecimal value = null;

        String money_amount = json.getAsJsonObject().get("money_amount").getAsString();

        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator(',');

        DecimalFormat decimalFormat = new DecimalFormat();
        decimalFormat.setParseBigDecimal(true);
        decimalFormat.setDecimalFormatSymbols(symbols);

        try {
           value = (BigDecimal) decimalFormat.parse(money_amount);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return value;
    }
}
