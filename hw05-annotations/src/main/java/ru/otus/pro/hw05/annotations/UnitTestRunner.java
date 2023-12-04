package ru.otus.pro.hw05.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.*;

public class UnitTestRunner {

    public static void main(String[] args) {
        runAllTests(AnnotationDemoTest.class);
    }

    private static ArrayList<Method> getAllAnnotetionsByName(Method[] methods, Class<? extends Annotation> annotationClass) {
        ArrayList<Method> annotationsSet = new ArrayList<>();
        for(Method method: methods) {
            Annotation anotation = method.getAnnotation(annotationClass);
            if (anotation!=null) {
                annotationsSet.add(method);
            }
        }
        return annotationsSet;
    }

    private static void runAllTests(Class <?> cls) {
        HashMap<Method, TypeOfResult> results = new HashMap<>();
        Method[] methods = cls.getDeclaredMethods();
        ArrayList<Method>  beforeAnnotations = getAllAnnotetionsByName(methods,Before.class);
        ArrayList<Method>  afterAnnotations = getAllAnnotetionsByName(methods,After.class);
        for(Method method: methods) {
            runTest(cls, method, beforeAnnotations, afterAnnotations, results);
        }
        showResults(results);
    }

    private static void runTest(Class <?> cls, Method method, ArrayList<Method> beforeAnnotations, ArrayList<Method> afterAnnotations, HashMap<Method, TypeOfResult> results) {
        Annotation[] annotations = method.getAnnotations();
        if ((annotations.length == 1) && (annotations[0] instanceof ru.otus.pro.hw05.annotations.Test)) {
            AnnotationDemoTest annotationDemoTest = null;
            try {
                annotationDemoTest = (AnnotationDemoTest) cls.getDeclaredConstructor().newInstance();
            } catch (InstantiationException e) {
                throw new RuntimeException(e);
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            } catch (InvocationTargetException e) {
                throw new RuntimeException(e);
            } catch (NoSuchMethodException e) {
                throw new RuntimeException(e);
            }
            for(Method methodBefore: beforeAnnotations) {
                invokeMethod(methodBefore, annotationDemoTest);
            }
            Boolean result = (Boolean)invokeMethod(method, annotationDemoTest);
            results.put(method, result == true?TypeOfResult.PASED:TypeOfResult.FAILED);
            for(Method afterBefore: afterAnnotations) {
                invokeMethod(afterBefore, annotationDemoTest);
            }
        }
        else if (annotations.length > 1) {
            throw new RuntimeException("Method " + method + " has more 1 annotation!");
        };
    }

    private static Boolean invokeMethod(Method method, AnnotationDemoTest annotationDemoTest) {
        Boolean result = false;
        try {
            result =  (Boolean) method.invoke(annotationDemoTest);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return  result;
    }

    private static void showResults(HashMap<Method, TypeOfResult> results) {
        int passed = 0;
        for(Map.Entry<Method, TypeOfResult> entry : results.entrySet()) {
            System.out.println("Test " + entry.getKey().getName() + " " + entry.getValue());
            if (entry.getValue()==TypeOfResult.PASED) {
                passed++;
            }
        }
        System.out.println("Total tests: " + results.size() + ", passed: " + passed+ ", failed: " + (results.size()-passed));
    }

}
