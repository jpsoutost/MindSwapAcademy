package academy.mindswap;


import academy.mindswap.fruit.Apple;
import academy.mindswap.fruit.Fruit;
import academy.mindswap.fruit.Orange;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Fruit> fruits = Arrays.asList(
            new Apple(1),
            new Apple(0),
            new Apple(1),
            new Orange(2),
            new Orange(2),
            new Orange(3),
            new Apple(2),
            new Orange(3),
            new Orange(4)
        );

        DupeFinder<Fruit> dupeFinder = new DupeFinder<>(fruits);
        System.out.println(dupeFinder.checkDupes());

        for (Fruit fruit : dupeFinder.getDupes()){
            System.out.println(fruit);
        }
    }
}
