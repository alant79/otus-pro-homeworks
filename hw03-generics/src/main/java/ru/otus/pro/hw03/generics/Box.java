package ru.otus.pro.hw03.generics;

import java.util.List;

public class Box<T extends Fruit> {

    private List<T> fruitsList;

    public Box(List<T> fruitsList) {
        this.fruitsList = fruitsList;
    }

    public int weight() {
        return fruitsList.stream().mapToInt(fruit -> fruit.getWeight()).sum();
    }

    public boolean compare(Box<?> box) {
        return weight() == box.weight();
    }

    public void moveToBox(Box<? super T> box) {
        fruitsList.stream().forEach(fruit-> box.add(fruit));
        fruitsList.clear();
    }

    public void add(T fruit) {
        fruitsList.add(fruit);
    }

    @Override
    public String toString() {
        return "Box{" +
                "fruitsList=" + fruitsList +
                '}';
    }
}
