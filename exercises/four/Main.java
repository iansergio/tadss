package exercises.four;

import java.util.ArrayList;
import java.util.List;

import exercises.four.operations.Add;
import exercises.four.operations.Print;
import exercises.four.operations.Remove;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(); 

        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Remove(array));
        Thread.ofPlatform().start(new Print(array));
    }
}
