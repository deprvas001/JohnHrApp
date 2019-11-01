package com.development.johnhrapp.model;

public class Notification {
    private String notification_desc;
    private String date;

    public Notification(String notification_desc, String date) {
        this.notification_desc = notification_desc;
        this.date = date;
    }

    public String getNotification_desc() {
        return notification_desc;
    }

    public void setNotification_desc(String notification_desc) {
        this.notification_desc = notification_desc;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
