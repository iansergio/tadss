package exercises.four.operations;

import java.util.List;

public class RemoveFirstItem implements Runnable {
    private List<Integer> array;

    public RemoveFirstItem(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {
        while (true) {
            array.remove(0);
        }
    }

}