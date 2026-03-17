package exercises.four;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import exercises.four.operations.AddNumber;
import exercises.four.operations.PrintNumber;
import exercises.four.operations.RemoveFirstItem;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new CopyOnWriteArrayList<>(); 
        AddNumber addNumber = new AddNumber(array);
        
        for (int i = 0; i <= 1; i++) {
            Thread addThread = new Thread(addNumber);
            addThread.start();
        }

        RemoveFirstItem removeFirstItem = new RemoveFirstItem(array);
        Thread removeThread = new Thread(removeFirstItem);
        removeThread.start();

        PrintNumber printNumber = new PrintNumber(array);
        Thread prinThread = new Thread(printNumber);
        prinThread.start();
    }
}
