package three.sequential;

import java.util.ArrayList;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int size = 1000000000;
        ArrayList<Integer> array = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(10));
        }

        long start = System.nanoTime(); // start count exec time

        long sum = 0;
        for (int n : array) {
            sum += n;
        }

        long end = System.nanoTime(); // finish count exec time
        long duration = end - start;

        System.out.println("Soma total: " + sum);
        System.out.println("Tempo de execução (ms): " + duration / 1000000);
        System.out.println("Tempo de execução (s): " + duration / 1000000000.0);
    }
}
