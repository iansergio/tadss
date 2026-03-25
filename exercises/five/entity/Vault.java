package five.entity;

public class Vault implements Runnable {

    private double value;

    public Vault(double value) {
        this.value = value;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                System.out.println("Valor total do cofre: " + value);
            }
            
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
            }
        }

    }
}
