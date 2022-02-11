package academy.mindswap;

import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        String prayer = "Oh Lord, won't you buy me a trash Mercedes Benz\n" +
                "My friends all drive trash Porsches, I must make trash amends\n" +
                "Worked hard all my trash lifetime, no help from my trash friends\n" +
                "So Lord, won't you buy me a trash Mercedes Benz";

        String correctedString = Arrays.stream(prayer.toUpperCase().split(" ")).
                filter(word -> !(word.equalsIgnoreCase("trash"))).
                collect(Collectors.joining(" "));

        System.out.println(correctedString);
    }
}
