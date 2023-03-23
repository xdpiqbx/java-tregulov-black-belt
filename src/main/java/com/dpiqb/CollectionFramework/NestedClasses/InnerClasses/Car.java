package com.dpiqb.CollectionFramework.NestedClasses.InnerClasses;

public class Car {
    String color;
    int doorCount;
    Engine engine;

    public Car(String color, int doorCount, int horsePower) {
        this.color = color;
        this.doorCount = doorCount;
        this.engine = this.new Engine(horsePower);
    }

    public void setEngine(Engine engine) {
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

    class Engine{
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
        Car redCar = new Car("Red", 2, 300);
        System.out.println("car = " + redCar);
        Car.Engine engine = redCar.new Engine(500);
        redCar.setEngine(engine);
        System.out.println("car = " + redCar);

        // Car.Engine blackCarEngine = new Car("Black", 5, 200).new Engine(200); // You can do it but...
    }
}
