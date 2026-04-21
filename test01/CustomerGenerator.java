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
        
        while (System.currentTimeMillis() < startTime + 7200000) { // 2 horas
            int randomTime = random.nextInt(50000 - 5000 + 1) + 5000; // 5 a 50 segundos
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
