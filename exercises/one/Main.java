package one;

import java.util.Date;

public class Main extends Thread {

    public void run() {
        System.out.println(getName() + " " + new Date());
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Main a = new Main();
            a.start();
        }
    }
}
