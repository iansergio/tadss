package multithreading;

public class MultiThreadThing implements Runnable {
    
    private int threadNumber;
    
    public MultiThreadThing(int threadNumber) {
        this.threadNumber = threadNumber;
    }

    @Override
    public void run() {
        for (int i = 0; i <= 5; i++) { // things inside each thread
            System.out.println(i + " from thread: " + threadNumber);
            
            if (threadNumber == 2) {
                throw new RuntimeException();
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
            }
        }
    }
}
