package com.javarush.weekday;

public class Sunday implements WeekDay {
    String dayOfWeek="Sunday";

    @Override
    public String getWeekDayName() {
        return dayOfWeek;
    }
}