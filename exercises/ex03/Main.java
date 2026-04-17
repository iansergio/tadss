package exercises.ex03;

import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        int[] numbers = new int[1_000_000_000];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(1, Integer.MAX_VALUE);
        }

        // Sequencial
        long startTime = System.currentTimeMillis();
        long generalSum = 0;

        for (int i = 0; i < numbers.length; i++) {
            generalSum += numbers[i];
        }
        
        System.out.println("Sequencial");
        System.out.printf("Valor: %d\n", generalSum);
        System.out.printf("%dms\n\n", System.currentTimeMillis() - startTime);

        // 10 Threads de Plataforma
        startTime = System.currentTimeMillis();
        int range = numbers.length / 10;
        Sum[] sum = new Sum[10];
        Thread[] threads = new Thread[10];
        int start = 0;

        for (int i = 0; i < 10; i++) {
            sum[i] = new Sum(numbers, start, range);
            threads[i] = Thread.ofPlatform().start(sum[i]);
            start += range;
        }

        generalSum = 0;
        for (int i = 0; i < 10; i++) {
            threads[i].join();
            generalSum += sum[i].getSum();
        }

        System.out.println("Threads de Plataforma");
        System.out.printf("Valor: %d\n", generalSum);
        System.out.printf("%dms \n\n", System.currentTimeMillis() - startTime);
    }
}
