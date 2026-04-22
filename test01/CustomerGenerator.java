package test01;

import java.util.Random;

public class CustomerGenerator implements Runnable {
    private Line waitingLine;
    private Random random = new Random();

    public CustomerGenerator(Line waitingLine) {
        this.waitingLine = waitingLine;
    }

    @Override
    public void run() {
        int c = 1;
        double startTime = System.currentTimeMillis();
        long SIMULATION_TIME = 30000; // 30s (teste) | 7200000 (2 horas)
        
        while (System.currentTimeMillis() < startTime + SIMULATION_TIME) {
            // 500-5000ms (teste) | 5000-50000ms (original: 5-50 segundos)
            int randomTime = random.nextInt(5000 - 500 + 1) + 500;
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }

            Customer customer = new Customer(c);
            waitingLine.add(customer);
            c++;
        }
        waitingLine.close();
    }
}
