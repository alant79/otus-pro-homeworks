package ru.otus.atmMachine;

import ru.otus.Banknote;
import ru.otus.Currency;
import ru.otus.moneyBox.MoneyBoxImpl;

import java.util.Map;

public interface ATMMachine {

    int getTotalMoney(Currency currency);

    void putMoney(Map<Banknote, Integer> money);

    Map<Banknote, Integer> getMoney(Currency currency, int value);

    void addMoneyBox(MoneyBoxImpl moneyBox);

}
