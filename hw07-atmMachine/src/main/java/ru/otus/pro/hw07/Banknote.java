package ru.otus.pro.hw07;

public class Banknote {

    private int value;
    private Currency currency;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Banknote(int value, Currency currency) {
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Banknote{" +
                "value=" + value +
                ", currency=" + currency +
                '}';
    }
}
