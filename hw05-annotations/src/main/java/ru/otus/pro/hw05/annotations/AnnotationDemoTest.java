package ru.otus.pro.hw05.annotations;

public class AnnotationDemoTest {

    public int a = 5;

    @Before
    public void beforeMethod1() {
        a++;
    }

    @Before
    public void beforeMethod2() {
        a++;
    }

    @Test
    public Boolean testMethod1() {
        return a==7;
    }

    @Test
    public Boolean testMethod2() {
        return a==6;
    }

    @After
    public void afterMethod1() {

    }

    @After
    public void afterMethod2() {

    }
}
