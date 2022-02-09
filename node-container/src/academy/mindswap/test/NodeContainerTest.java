package academy.mindswap.test;

import academy.mindswap.NodeContainerSolution;

public class NodeContainerTest {


    public static void main(String[] args) {
        NodeContainerTest test = new NodeContainerTest();
        test.assertCondition("Adding data correctly?", test.testAdd());
        test.assertCondition("Retrieving index correctly?", test.testIndex());
        test.assertCondition("Retrieving data correctly?", test.testGet());
        test.assertCondition("Removing data correctly?", test.testRemove());
    }

    public boolean testAdd() {
        NodeContainerSolution list = new NodeContainerSolution();
        Object element1 = "one";
        Object element2 = "two";
        Object element3 = "three";

        if (list.size() != 0) {
            return false;
        }

        list.add(element1);

        if (list.size() != 1) {
            return false;
        }

        list.add(element2);

        if (list.size() != 2) {
            return false;
        }

        list.add(element3);

        return list.size() == 3;
    }

   public boolean testIndex() {
        NodeContainerSolution list = new NodeContainerSolution();
        Object element1 = "one";
        Object element2 = "two";
        Object element3 = "three";

        if (list.indexOf(element1) != -1 || list.indexOf(element2) != -1 || list.indexOf(element3) != -1) {
            return false;
        }

        list.add(element1);

        if (list.indexOf(element1) != 0) {
            return false;
        }

        if(list.indexOf(4) != -1){
            return false;
        }

        list.add(element2);

        if (list.indexOf(element1) != 0) {
            return false;
        }

        if (list.indexOf(element2) != 1) {
            return false;
        }

        list.add(element3);

        if (list.indexOf(element1) != 0 && list.indexOf(element2) != 1) {
            return false;
        }

        return list.indexOf(element3) == 2;
    }

    public boolean testGet() {
        NodeContainerSolution list = new NodeContainerSolution();
        Object data1 = "one";
        Object data2 = "two";
        Object data3 = "three";

        if (list.get(0) != null || list.get(1) != null || list.get(2) != null) {
            return false;
        }

        if (list.get(9) != null) {
            return false;
        }

        list.add(data1);

        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (list.get(1) != null) {
            return false;
        }

        list.add(data2);

        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (!data2.equals(list.get(1))) {
            return false;
        }

        if (list.get(2) != null) {
            return false;
        }

        list.add(data3);

        if (!data1.equals(list.get(0))) {
            return false;
        }

        if (!data2.equals(list.get(1))) {
            return false;
        }

        if (!data3.equals(list.get(2))) {
            return false;
        }

        return list.get(3) == null;
    }

    public boolean testRemove() {
        NodeContainerSolution list = new NodeContainerSolution();
        Object data1 = "one";
        Object data2 = "two";
        Object data3 = "three";

        if (list.remove(data1)) {
            return false;
        }

        list.add(data1);

        if (list.remove(data2)) {
            return false;
        }

        if (!list.remove(data1)) {
            return false;
        }

        if (list.size() != 0) {
            return false;
        }

        list.add(data1);
        list.add(data2);

        if (list.remove(data3)) {
            return false;
        }

        if (!list.remove(data1)) {
            return false;
        }

        if (list.size() != 1) {
            return false;
        }

        list.add(data1);

        if (!list.remove(data1)) {
            return false;
        }

        if (!list.remove(data2)) {
            return false;
        }

        if (list.size() != 0) {
            return false;
        }

        list.add(data1);
        list.add(data2);
        list.add(data3);

        if (!list.remove(data2)) {
            return false;
        }

        if (list.size() != 2) {
            return false;
        }

        if (list.indexOf(data1) != 0) {
            return false;
        }

        if (list.indexOf(data3) != 1) {
            return false;
        }

        if (!list.remove(data3)) {
            return false;
        }

        return list.size() == 1;
    }

    private void assertCondition(String test, boolean result) {
        System.out.println(test + ": " + (result ? "YES" : "NO"));
    }
}
