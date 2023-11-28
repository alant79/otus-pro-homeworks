package ru.otus.moneyBox;

import ru.otus.Banknote;

public interface MoneyBox {
    void putToMoneyBox(int quantity);

    void getFromMoneyBox(int quantity);

    Banknote getTypeOfBanknote();

    int getTotalValue();

    int getFreePlace();
}
