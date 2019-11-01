package com.development.johnhrapp.model;

public class MonthlyShift {
    private String title;
    private String amount;
    private String date;
    private String address;

    public MonthlyShift() {
    }

    public MonthlyShift(String title, String amount, String date, String address) {
        this.title = title;
        this.amount = amount;
        this.date = date;
        this.address = address;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
