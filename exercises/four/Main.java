package four;

import java.util.ArrayList;
import java.util.List;

import four.operations.Add;
import four.operations.Print;
import four.operations.Remove;

public class Main {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(); 

        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Add(array));
        Thread.ofPlatform().start(new Remove(array));
        Thread.ofPlatform().start(new Print(array));
    }
}
