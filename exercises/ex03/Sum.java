package exercises.ex03;

public class Sum implements Runnable {
    private int[] numbers;
    private int start;
    private int amount;
    private long sum;

    public Sum(int[] numbers, int start, int amount) {
        this.numbers = numbers;
        this.start = start;
        this.amount = amount;
    }

    @Override
    public void run() {
        for (int i = start; i < start + amount; i++) {
            sum += numbers[i];
        }
    }

    public long getSum() {
        return sum;
    }
}
