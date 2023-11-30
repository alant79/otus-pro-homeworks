package ru.otus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.otus.Banknote;
import ru.otus.Currency;
import ru.otus.MoneyBoxDTO;
import ru.otus.atmmachine.ATMMachineImpl;
import ru.otus.moneybox.MoneyBox;
import ru.otus.moneybox.MoneyBoxImpl;

import java.util.HashMap;
import java.util.Map;


@Controller
public class SomeDataController {

    private Currency curRUB;
    private Banknote rub50;
    private Banknote rub100;
    private Banknote rub500;
    private Banknote rub1000;
    private Banknote rub5000;
    private MoneyBoxImpl moneyBox1;
    private MoneyBoxImpl moneyBox2;
    private MoneyBoxImpl moneyBox3;
    private MoneyBoxImpl moneyBox4;
    private MoneyBoxImpl moneyBox5;
    private ATMMachineImpl atmMachine;

    @GetMapping()
    public String index(Model model) {
        init();
        model.addAttribute("balance", atmMachine.getTotalMoney(curRUB) + " " + curRUB.getName());
        return "index";
    }

    @PostMapping(value = "main")
    public String index(Model model, Boolean noInit) {
        model.addAttribute("balance", atmMachine.getTotalMoney(curRUB) + " " + curRUB.getName());
        return "index";
    }

    @PostMapping(value = "putMoney")
    public String putMoney(Model model, MoneyBoxDTO moneyBoxDTO) {
        boolean isError = false;
        MoneyBoxDTO newMoneyBoxDTO = new MoneyBoxDTO();
        int idx = 0;
        for (MoneyBox moneyBox : atmMachine.getListMoneyBox()) {
            newMoneyBoxDTO.addMoneyBox(moneyBox, idx++);
        }
        if (moneyBoxDTO != null && newMoneyBoxDTO.getListOfMoneyBox() != null && !moneyBoxDTO.getListOfValue().isEmpty()) {
            try {
                Map<Banknote, Integer> packageOfMoney = new HashMap<>();
                for (Map.Entry<Integer, MoneyBox> moneyBox : newMoneyBoxDTO.getListOfMoneyBox().entrySet()) {
                    packageOfMoney.put(moneyBox.getValue().getTypeOfBanknote(), moneyBoxDTO.getListOfValue().get(moneyBox.getKey()));
                }
                atmMachine.putMoney(packageOfMoney);
            } catch (RuntimeException exception) {
                isError = true;
            }
        }
        model.addAttribute("moneyBoxDTO", newMoneyBoxDTO);
        model.addAttribute("isError", isError);
        return "putMoney";

    }

    @PostMapping(value = "getMoney")
    public String getMoney(Model model, Integer sum) {
        boolean isError = false;
        Map<Banknote, Integer> packageOfMoney = new HashMap<>();
        if (sum != null && sum > 0) {
            try {
                packageOfMoney = atmMachine.getMoney(curRUB, sum);
            } catch (RuntimeException exception) {
                isError = true;
            }
        }
        model.addAttribute("packageOfMoney", packageOfMoney);
        model.addAttribute("isError", isError);
        return "getMoney";
    }

    private void init() {
        curRUB = new Currency(643, "RUB");
        rub50 = new Banknote(50, curRUB);
        rub100 = new Banknote(100, curRUB);
        rub500 = new Banknote(500, curRUB);
        rub1000 = new Banknote(1000, curRUB);
        rub5000 = new Banknote(5000, curRUB);

        moneyBox1 = new MoneyBoxImpl(rub50, 100);
        moneyBox2 = new MoneyBoxImpl(rub100, 100);
        moneyBox3 = new MoneyBoxImpl(rub500, 100);
        moneyBox4 = new MoneyBoxImpl(rub1000, 100);
        moneyBox5 = new MoneyBoxImpl(rub5000, 100);

        atmMachine = new ATMMachineImpl();
        atmMachine.addMoneyBox(moneyBox1);
        atmMachine.addMoneyBox(moneyBox2);
        atmMachine.addMoneyBox(moneyBox3);
        atmMachine.addMoneyBox(moneyBox4);
        atmMachine.addMoneyBox(moneyBox5);

    }
}
