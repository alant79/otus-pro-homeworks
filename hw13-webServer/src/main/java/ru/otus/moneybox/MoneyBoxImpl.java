package ru.otus.moneybox;

import ru.otus.Banknote;

public class MoneyBoxImpl implements MoneyBox {
    private Banknote typeOfBanknote;
    private int quantity;
    private int capacity;

    public MoneyBoxImpl(Banknote typeOfBanknote, int capacity) {
        this.typeOfBanknote = typeOfBanknote;
        this.capacity = capacity;
    }

    @Override
    public void putToMoneyBox(int quantity) {
        if (quantity + this.quantity > capacity) {
            throw new RuntimeException("Moneybox is full");
        }
        this.quantity += quantity;
    }

    @Override
    public void getFromMoneyBox(int quantity) {
        if (this.quantity < quantity) {
            throw new RuntimeException("Not enough money in moneybox");
        }
        this.quantity -= quantity;
    }

    @Override
    public Banknote getTypeOfBanknote() {
        return typeOfBanknote;
    }

    @Override
    public int getTotalValue() {
        return quantity * typeOfBanknote.getValue();
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public int getFreePlace() {
        return this.capacity - this.quantity;
    }

    @Override
    public String toString() {
        return "MoneyBoxImpl{" +
                "typeOfBanknote=" + typeOfBanknote.getValue() +
                ", currency=" + typeOfBanknote.getCurrency() +
                ", quantity=" + quantity +
                ", capacity=" + capacity +
                '}';
    }
}
