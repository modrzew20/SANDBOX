package dm.sandbox;

import dm.sandbox.pattern.*;

import java.util.concurrent.*;

public class Restaurant {

    //todo: investigate amount of threads
    public static void main(String[] args) {
        Semaphore seats = new Semaphore(3);
        WaiterPool waiterPool = new WaiterPool(2);
        Chef chef = new Chef();

        ChainHandler chain = new WaitingForSeatHandler(seats, waiterPool);
        chain.setNext(new OrderHandler(waiterPool))
                .setNext(new ChefHandler(chef))
                .setNext(new LeaveHandler(seats));

        while (true) {
            Customer client = new Customer("Klient-" + Thread.currentThread().getId());
            new Thread(() -> chain.handle(client), "Klient-" + Thread.currentThread().getId()).start();
            int randomSleep = ThreadLocalRandom.current().nextInt(100, 500);
            try {
                Thread.sleep(randomSleep);
            } catch (InterruptedException e) {
                //ignored
            }
        }
    }
}
