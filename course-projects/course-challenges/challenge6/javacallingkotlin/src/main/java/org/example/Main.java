package org.example;

import kotlin.example.Challenge;
import kotlin.example.Employee;
//import kotlin.example.KotlinStuff;
import kotlin.example.KotlinCodeKt;

public class Main {
    public static void main(String[] args) {
//        KotlinStuff.sayHelloToJava("Student");
//        Employee employee = new Employee("jose", "smith", 2010);
//        employee.startYear = 2009;
//        Challenge.doMath(5, 4);
//        employee.takesDefault("arg1");

        KotlinCodeKt.sayHelloToJava("Student");
        Employee employee = new Employee("jose", "smith", 2010);
        employee.setStartYear(2009);
        Challenge.INSTANCE.doMath(5, 4);
//        employee.takesDefault("arg1"); => no solution for this one
    }
}