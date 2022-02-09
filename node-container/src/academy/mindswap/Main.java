package academy.mindswap;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        NodeContainerSolution <String> list = new NodeContainerSolution<>();
        String data1 = "one";
        String data2 = "two";
        String data3 = "three";

        list.add(data1);
        list.add(data2);
        list.add(data3);

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list.indexOf(data2));
        System.out.println(list.remove(data1));

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
