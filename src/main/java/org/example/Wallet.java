package org.example;

import java.util.ArrayList;

public class Wallet {
    public String owner;
    public double cash;
    public ArrayList<String> listCard;

    public Wallet(String owner, double cash, ArrayList<String> listCard) {
        this.owner = owner;
        this.cash = cash;
        this.listCard = listCard;
    }

    public void withdraw(double amount) {
        if (this.cash < amount) {
            return;
        }
        this.cash -= amount;
    }

    public void deposit(double amount) {
        this.cash += amount;
    }

    public void addCard(String idCard) {
        this.listCard.add(idCard);
    }

    public void removeCard(String idCard) {
        boolean isDeleted = this.listCard.remove(idCard);
        if (!isDeleted) {
            throw new Error();
        }
    }
}
