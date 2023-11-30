package ru.otus.atmmachine;

import ru.otus.Banknote;
import ru.otus.Currency;
import ru.otus.moneybox.MoneyBoxImpl;

import java.util.Map;

public interface ATMMachine {

    int getTotalMoney(Currency currency);

    void putMoney(Map<Banknote, Integer> money);

    Map<Banknote, Integer> getMoney(Currency currency, int value);

    void addMoneyBox(MoneyBoxImpl moneyBox);

}
