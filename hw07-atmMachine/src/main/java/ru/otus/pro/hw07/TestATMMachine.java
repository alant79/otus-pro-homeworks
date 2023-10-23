package ru.otus.pro.hw07;

import ru.otus.pro.hw07.atmMachine.ATMMachineImpl;
import ru.otus.pro.hw07.moneyBox.MoneyBoxImpl;

import java.util.HashMap;
import java.util.Map;

public class TestATMMachine {
    public static void main(String[] args) {

        Currency curRUB = new Currency(643, "Рубль");
        Banknote rub50 = new Banknote(50, curRUB);
        Banknote rub100 = new Banknote(100, curRUB);
        Banknote rub500 = new Banknote(500, curRUB);
        Banknote rub1000 = new Banknote(1000, curRUB);
        Banknote rub5000 = new Banknote(5000, curRUB);

        MoneyBoxImpl moneyBox1 = new MoneyBoxImpl(rub50, 100 );
        MoneyBoxImpl moneyBox2 = new MoneyBoxImpl(rub100, 100 );
        MoneyBoxImpl moneyBox3 = new MoneyBoxImpl(rub500, 100 );
        MoneyBoxImpl moneyBox4 = new MoneyBoxImpl(rub1000, 100 );
        MoneyBoxImpl moneyBox5 = new MoneyBoxImpl(rub5000, 100 );

        ATMMachineImpl atmMachine = new ATMMachineImpl();
        atmMachine.addMoneyBox(moneyBox1);
        atmMachine.addMoneyBox(moneyBox2);
        atmMachine.addMoneyBox(moneyBox3);
        atmMachine.addMoneyBox(moneyBox4);
        atmMachine.addMoneyBox(moneyBox5);

        Map<Banknote,Integer> packageOfMoney = new HashMap<>();
        packageOfMoney.put(rub50, 5);
        packageOfMoney.put(rub100, 5);
        packageOfMoney.put(rub500, 5);
        packageOfMoney.put(rub1000, 5);
        packageOfMoney.put(rub5000, 5);
        atmMachine.putMoney(packageOfMoney);

        System.out.println(atmMachine.getTotalMoney(curRUB));

        packageOfMoney.clear();
        packageOfMoney = atmMachine.getMoney(curRUB, 32000);
        System.out.println(packageOfMoney);
        System.out.println(atmMachine.getTotalMoney(curRUB));
    }
}
