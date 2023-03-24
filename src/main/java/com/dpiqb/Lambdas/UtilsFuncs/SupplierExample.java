package com.dpiqb.Lambdas.UtilsFuncs;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public class SupplierExample {
    public static void main(String[] args) {
        Supplier<String> anything = () -> "Anything";
        System.out.println("anything.get() = " + anything.get());

        Supplier<Car> mers = () -> new Car("Mercedes", "Black", "steel", false);
        System.out.println("mers.get() = " + mers.get());

        // *************************************************************************************************

        List<String> models = new ArrayList<>();
        models.add("Mers");
        models.add("Lamborghini");
        models.add("Maserati");

        List<Supplier<Car>> autos = new ArrayList<>();
        for (String model : models) {
            autos.add(() -> new Car(model, "Black", "steel", false));
        }

        for (Supplier<Car> auto : autos) {
            System.out.println("auto.get() = " + auto.get());
        }
    }
}