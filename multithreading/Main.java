package multithreading;

public class Main {
    public static void main(String[] args) {
        
        for (int i = 0; i <= 3; i++) {
            MultiThreadThing myThing= new MultiThreadThing(i); // i -> number of threads

            Thread myThread = new Thread(myThing);
            myThread.start();
        }        
    }

}
