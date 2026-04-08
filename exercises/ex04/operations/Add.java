package exercises.ex04.operations;

import java.util.List;
import java.util.Random;

public class Add implements Runnable {
    private List<Integer> array;
    private Random random;

    public Add(List<Integer> array) {
        this.array = array;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (true) {
            synchronized(array) {
                var number = random.nextInt(10_000);
                array.add(number);
            }
        }
    }
}
