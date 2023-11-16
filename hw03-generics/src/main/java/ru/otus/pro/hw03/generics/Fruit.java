package ru.otus.pro.hw03.generics;

public class Fruit {

    private int weight;

    public Fruit(int weight) {
        this.weight = weight;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "weight=" + weight +
                '}';
    }
}
