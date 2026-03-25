package three.concurrent;

import java.util.ArrayList;

public class Array implements Runnable {
    private ArrayList<Integer> array;
    private int start;
    private int end;
    public long partialSum = 0;

    public Array(ArrayList<Integer> array, int start, int end) {
        this.array = array;
        this.start = start;
        this.end = end;
    }

    @Override
    public void run() {
        for (int i = start; i < end; i++) {
            partialSum += array.get(i);
        }
    }
}
