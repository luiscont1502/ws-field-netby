package com.netby.persistence.service.utils;

import java.time.LocalTime;

public final class Constant {
    public static final LocalTime MORNING_SESSION_START = LocalTime.of(9, 0);
    public static final LocalTime LUNCH_TIME = LocalTime.of(12, 0);
    public static final LocalTime AFTERNOON_SESSION_START = LocalTime.of(13, 0);
    public static final LocalTime NETWORKING_EVENT_EARLIEST_START = LocalTime.of(16, 0);
    public static final LocalTime NETWORKING_EVENT_LATEST_START = LocalTime.of(17, 0);
    public static String formatTime(LocalTime time) {
        return time.toString()+ (time.isBefore(LocalTime.NOON) ? "AM" : "PM");
    }
}
