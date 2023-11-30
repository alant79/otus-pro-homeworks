package ru.otus.pro.hw07.atmMachine;

import ru.otus.pro.hw07.Banknote;
import ru.otus.pro.hw07.Currency;
import ru.otus.pro.hw07.moneyBox.MoneyBox;
import ru.otus.pro.hw07.moneyBox.MoneyBoxImpl;

import java.util.Map;

public interface ATMMachine {

    int getTotalMoney(Currency currency);

    void putMoney(Map<Banknote, Integer> money);

    Map<Banknote, Integer> getMoney(Currency currency, int value);

    void addMoneyBox(MoneyBoxImpl moneyBox);

}
