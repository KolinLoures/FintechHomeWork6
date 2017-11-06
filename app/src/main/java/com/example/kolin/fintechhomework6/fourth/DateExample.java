package com.example.kolin.fintechhomework6.fourth;

import java.util.Date;

/**
 * Created by kolin on 06.11.2017.
 */

public class DateExample {

    private Date date;

    public DateExample(Date date) {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "DateExample{\n" +
                "   date=" + date + "\n" +
                '}';
    }
}
