package academy.mindswap;

import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
	// write your code here
        // THE RUNNABLE METHOD
        Thread t1 = new Thread(new MyRunnable());
        t1.start();

        // THE THREAD EXTENSION METHOD
        Thread t2 = new MyThread();
        t2.start();

    }

    public static class MyRunnable implements Runnable {

        @Override
        public void run() {
            IntStream.range(0, 1000).forEach(i -> System.out.println("MyRunnable: " + i));
        }
    }

    public static class MyThread extends Thread {

        @Override
        public void run() {
            IntStream.range(0, 1000).forEach(i -> System.out.println("MyThread: " + i));
        }
    }


}
