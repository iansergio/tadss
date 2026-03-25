package three.concurrent;

import java.util.ArrayList;
import java.util.Random;

public class MainPlatform {
    public static void main(String[] args) throws InterruptedException {
        int size = 1000000000;
        int numThreads = 100;

        ArrayList<Integer> array = new ArrayList<>(size);
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            array.add(random.nextInt(10));
        }

        long start = System.nanoTime(); // start count exec time
        int chunkSize = size / numThreads;
        Array[] tasks = new Array[numThreads];
        Thread[] threads = new Thread[numThreads];

        for (int i = 0; i < numThreads; i++) {
            int startIndex = i * chunkSize;
            int endIndex = startIndex + chunkSize;

            if (i == numThreads - 1) {
                endIndex = size;
            }
            
            tasks[i] = new Array(array, startIndex, endIndex);
            threads[i] = new Thread(tasks[i]);
            threads[i].start();
        }

        for (Thread thread : threads) {
            thread.join();
        }

        long totalSum = 0;
        for (Array task : tasks) {
            totalSum += task.partialSum;
        }

        long end = System.nanoTime(); // finish count exec time
        long duration = end - start;

        System.out.println("Soma total: " + totalSum);
        System.out.println("Tempo de execução concorrente com " + numThreads + " threads (ms): " + duration / 1000000);
        System.out.println("Tempo de execução (s): " + duration / 1000000000.0);
    }
}
