package four.operations;

import java.util.List;

public class Print implements Runnable {
    private List<Integer> array;

    public Print(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (array) {
                System.out.println(array.toString());
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }
}
