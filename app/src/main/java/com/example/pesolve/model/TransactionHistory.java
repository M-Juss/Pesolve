package com.example.pesolve.model;

public class TransactionHistory
{
    String type, category, note, date;
    int id, amount;
    public TransactionHistory(int id, String type, String category, String note, String date, int amount){
        this.id  = id;
        this.type = type;
        this.category = category;
        this.note = note;
        this.date = date;
        this.amount = amount;
    }
}
