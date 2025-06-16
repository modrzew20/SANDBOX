package dm.sandbox;

import java.util.logging.Logger;

public class Waiter implements Runnable {

    private final String name;

    public Waiter(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        System.out.println("Kelner " + name + "obsługuje klienta");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            //ignored
        }
    }
}
