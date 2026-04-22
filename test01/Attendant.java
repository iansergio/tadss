package test01;

import java.util.Random;

public class Attendant implements Runnable {
    private int id;
    private Line waitingLine;
    private Random random = new Random();

    public Attendant(int id, Line waitingLine) {
        this.id = id;
        this.waitingLine = waitingLine;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Customer removedCustomer = waitingLine.pick();
            if (removedCustomer == null) {
                break;
            }

            removedCustomer.setStartService(System.currentTimeMillis());
            removedCustomer.setStatus(Status.ONGOING);

            // 1000-3000ms (teste) | 30000-120000ms (original: 30-120 segundos)
            int randomTime = random.nextInt(3000 - 1000 + 1) + 1000;
            try {
                Thread.sleep(randomTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            removedCustomer.setEndService(System.currentTimeMillis());
            removedCustomer.setStatus(Status.FINISHED);
            waitingLine.finish(removedCustomer);
        }
    }
}
