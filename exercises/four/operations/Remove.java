package exercises.four.operations;

import java.util.List;

public class Remove implements Runnable {
    private List<Integer> array;

    public Remove(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            synchronized(array) {
                array.removeFirst();
            }
        }
    }
}
