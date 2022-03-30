package academy.mindswap.wtfjunit;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class OtherClass {

    public List<Integer> getRandomNumbers (int length){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numbers.add((int) Math.random()*9);
        }
        return numbers;
    }

    public void printReference(String reference){
        System.out.println(reference);
    }
}
