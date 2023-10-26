package ru.otus.pro.hw01.gradle;


import java.util.List;
import com.google.common.collect.Lists;


public class HelloOtus {
    public static void main(String[] args) {
        List<String> strings = Lists.newArrayList("one", "two", "three", "four", "five");
        List<String> stringsRev = Lists.reverse(strings);
        System.out.println(stringsRev);
    }
}

