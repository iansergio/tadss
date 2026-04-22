package test01;

public class Bank {
    public static void main(String[] args) {
        Line waitingLine = new Line();
        
        CustomerGenerator generator = new CustomerGenerator(waitingLine);
        Thread gt = Thread.ofPlatform().name("Gerador").start(generator);
        
        Thread[] attendants = new Thread[2];
        for (int i = 1; i <= 2; i++) {
            Attendant attendant = new Attendant(i, waitingLine);
            attendants[i - 1] = Thread.ofPlatform().name("Atendente " + i).start(attendant);
        }

        try {
            gt.join();
            for (Thread t : attendants) {
                t.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        waitingLine.printResults();
    }
}