package ru.otus.pro.hw03.generics;

public class Orange extends Fruit{
    public Orange(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Orange{" +
                "weight=" + this.getWeight() +
                '}';
    }
}
