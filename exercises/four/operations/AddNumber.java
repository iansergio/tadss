package exercises.four.operations;

import java.util.List;
import java.util.Random;

public class AddNumber implements Runnable {
    private List<Integer> array;

    public AddNumber(List<Integer> array) {
        this.array = array;
    }

    @Override
    public void run() {

        Random random = new Random();

        while (true) {
            var number = random.nextInt(100);
            array.add(number);
        }
    }

}
