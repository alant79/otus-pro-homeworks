package ru.otus;

import ru.otus.moneybox.MoneyBox;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MoneyBoxDTO {
    private Map<Integer, MoneyBox> listOfMoneyBox = new HashMap<>();
    private List<Integer> listOfValue = new ArrayList<>();

    public void addMoneyBox(MoneyBox moneyBox, Integer idx) {
        this.listOfMoneyBox.put(idx, moneyBox);
        this.listOfValue.add(0);
    }

    public Map<Integer, MoneyBox> getListOfMoneyBox() {
        return listOfMoneyBox;
    }

    public void setListOfMoneyBox(Map<Integer, MoneyBox> listOfMoneyBox) {
        this.listOfMoneyBox = listOfMoneyBox;
    }

    public List<Integer> getListOfValue() {
        return listOfValue;
    }

    public void setListOfValue(List<Integer> listOfValue) {
        this.listOfValue = listOfValue;
    }
}
