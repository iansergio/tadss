package exercises.ex04;

import java.util.ArrayList;
import java.util.List;

import exercises.ex04.operations.Add;
import exercises.ex04.operations.Print;
import exercises.ex04.operations.Remove;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(); 

        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Remove(array));
        Thread.ofPlatform().start(new Print(array));
    }
}
