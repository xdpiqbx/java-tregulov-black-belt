package com.dpiqb.Lambdas.UtilsFuncs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        Consumer<Integer> getSomeInt = number -> System.out.println(number + " Thats all");
        getSomeInt.andThen(getSomeInt).accept(42);

        Car mers = new Car("Mercedes", "Black", "steel", false);

        System.out.println("Before pimp => " + mers);

        pimpRide(mers, (m) -> {
            m.setModel("Lamborghini");
            m.setColor("Orange-Red");
            m.setSpoiler(true);
            m.setWheels("Carbon Phantom");
        });

        System.out.println("After pimp => " + mers);
    }
    static void pimpRide(Car car, Consumer<Car> consumer){
        consumer.accept(car);
    }
}
