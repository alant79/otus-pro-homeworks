package ru.otus.pro.hw07.moneyBox;

import ru.otus.pro.hw07.Banknote;

public interface MoneyBox {
    void putToMoneyBox(int quantity);
    void getFromMoneyBox(int quantity);
    Banknote getTypeOfBanknote();
    int getTotalValue();
    int getFreePlace();
}
