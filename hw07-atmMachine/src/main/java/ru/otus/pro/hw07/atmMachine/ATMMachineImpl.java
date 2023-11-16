package ru.otus.pro.hw07.atmMachine;

import ru.otus.pro.hw07.Banknote;
import ru.otus.pro.hw07.Currency;
import ru.otus.pro.hw07.moneyBox.MoneyBoxImpl;

import java.util.*;

public class ATMMachineImpl implements ATMMachine{
    ArrayList<MoneyBoxImpl> listMoneyBox = new ArrayList<>();

    @Override
    public int getTotalMoney(Currency currency) {
        return listMoneyBox.stream().filter(el->el.getTypeOfBanknote().getCurrency() == currency)
                .mapToInt(el->el.getTotalValue()).sum();
    }

    @Override
    public void putMoney(Map<Banknote, Integer> money) {
        for (Map.Entry<Banknote, Integer> entry: money.entrySet()
             ) {
            if (!checkFreeSpace(entry.getKey(), entry.getValue())) {
               throw new RuntimeException("Not free place in moneybox");
            }
            int balanceMoney = entry.getValue();
            for (MoneyBoxImpl moneyBox: listMoneyBox
                 ) {
                if (moneyBox.getTypeOfBanknote() == entry.getKey()) {
                    int putSumma = Math.min(moneyBox.getFreePlace(),balanceMoney);
                    moneyBox.putToMoneyBox(putSumma);
                    balanceMoney -= putSumma;
                }
                if (balanceMoney == 0){
                    break;
                }
            }
        }
    }

    private boolean checkFreeSpace(Banknote banknote, int checkSumma) {
        int balance = listMoneyBox.stream().filter(el->el.getTypeOfBanknote() == banknote)
                .mapToInt(el->(el.getFreePlace())).sum();
        return checkSumma <= balance;
    }

    @Override
    public Map<Banknote, Integer> getMoney(Currency currency, int value) {
        Map<MoneyBoxImpl, Integer> resultMoneysBox = new HashMap<>();
        Map<Banknote, Integer> result = new HashMap<>();
        int balanceMoney = value;
        int hasMoney;
        for (MoneyBoxImpl moneyBox: listMoneyBox
        ) {
            if (moneyBox.getTypeOfBanknote().getCurrency() == currency) {
                hasMoney = balanceMoney / moneyBox.getTypeOfBanknote().getValue();
                hasMoney = Math.min(hasMoney, moneyBox.getQuantity());
                if (hasMoney > 0) {
                    resultMoneysBox.put(moneyBox, hasMoney);
                    balanceMoney -= hasMoney * moneyBox.getTypeOfBanknote().getValue();
                }
            }
            if (balanceMoney == 0){
                break;
            }
        }
        if (balanceMoney != 0) {
            throw new RuntimeException("Not enough money in ATM machine");
        }
        for (Map.Entry<MoneyBoxImpl, Integer> entry: resultMoneysBox.entrySet()
             ) {
            result.put(entry.getKey().getTypeOfBanknote(),
                    result.getOrDefault(entry.getKey().getTypeOfBanknote(), 0) + entry.getValue());
            entry.getKey().getFromMoneyBox(entry.getValue());
        }
        return result;
    }

    @Override
    public void addMoneyBox(MoneyBoxImpl moneyBox) {
        listMoneyBox.add(moneyBox);
        Collections.sort(listMoneyBox, new Comparator<MoneyBoxImpl>() {
            @Override
            public int compare(MoneyBoxImpl lhs, MoneyBoxImpl rhs) {
                // -1 - less than, 1 - greater than, 0 - equal, all inversed for descending
                return lhs.getTypeOfBanknote().getValue() > rhs.getTypeOfBanknote().getValue() ? -1 :
                        (lhs.getTypeOfBanknote().getValue() < rhs.getTypeOfBanknote().getValue()) ? 1 : 0;
            }
        });
    }


}
