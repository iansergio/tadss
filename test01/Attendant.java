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

            int randomTime = random.nextInt(120000 - 30000 + 1) + 30000; // 30 a 120 segundos
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
