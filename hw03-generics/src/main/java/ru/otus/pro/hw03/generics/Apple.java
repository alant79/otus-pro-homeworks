package ru.otus.pro.hw03.generics;

public class Apple extends Fruit{
    public Apple(int weight) {
        super(weight);
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + this.getWeight() +
                '}';
    }
}
