package com.dpiqb.CollectionFramework.NestedClasses.StaticNestedClass;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, Engine engine) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = engine;
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", doorCount=" + doorCount +
                ", engine=" + engine +
                '}';
    }

    static class Engine{
        int horsePower;

        public Engine(int horsePower) {
            this.horsePower = horsePower;
        }

        @Override
        public String toString() {
            return "Engine{" +
                    "horsePower=" + horsePower +
                    '}';
        }
    }
}

class Test{
    public static void main(String[] args) {
        Car.Engine eng = new Car.Engine(200);
        System.out.println("eng = " + eng);

        Car car = new Car("Red", 2, eng);
        System.out.println("car = " + car);
    }
}