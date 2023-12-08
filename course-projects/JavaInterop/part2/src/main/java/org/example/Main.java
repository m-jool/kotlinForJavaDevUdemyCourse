package org.example;

import learn.kotlin.Car;
import learn.kotlin.CarKt;
import learn.kotlin.SingletonObject;

import java.io.IOException;

import static learn.kotlin.CarKt.topLevel;

public class Main {
    public static void main(String[] args) {
        topLevel();
        CarKt.topLevel();

        Car car = new Car("bla", "bla");
        Car.Companion.carComp();
        Car.carComp();

        SingletonObject.INSTANCE.myFun();

        car.printMe(null);

        try {
            car.doIO();
        } catch (IOException ex){

        }

        car.defaultArgs("bla");
    }

}