package ru.otus.pro.hw03.generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Orange> listOrange = new ArrayList<>(Arrays.asList(new Orange(10),new Orange(20), new Orange(30)));
        List<Apple> listApple = new ArrayList<>(Arrays.asList(new Apple(30),new Apple(20), new Apple(10)));
        List<Fruit> listFruit = new ArrayList<>(Arrays.asList(new Fruit(40)));

        Box<Orange> boxOrange = new Box<>(listOrange);
        Box<Apple> boxApple = new Box<>(listApple);
        Box<Fruit> boxFruit = new Box<>(listFruit);

        System.out.println("Box with fruits init");
        System.out.println(boxFruit);

        System.out.println("Box with fruits equals box with Apple? "+ boxFruit.compare(boxApple));

        boxFruit.add(new Fruit(20));
        System.out.println("Box with fruits after add 1 fruit");
        System.out.println(boxFruit);

        System.out.println("Now. Box with fruits equals box with Apple? "+ boxFruit.compare(boxApple));

        boxOrange.moveToBox(boxFruit);
        System.out.println("Box with Oranges after move to Box Fruits");
        System.out.println(boxOrange);
        System.out.println("Box with fruits after add from Box Orange");
        System.out.println(boxFruit);
    }
}