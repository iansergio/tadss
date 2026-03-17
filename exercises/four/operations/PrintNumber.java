package exercises.four.operations;

import java.util.List;

public class PrintNumber implements Runnable {
    private List<Integer> array;

    public PrintNumber(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(array.toString());
            
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
        }
    }

}
