package dm.sandbox.pattern;

import dm.sandbox.Customer;
import dm.sandbox.Waiter;
import dm.sandbox.WaiterPool;

import java.util.concurrent.Semaphore;

public class WaitingForSeatHandler extends ChainHandler {

    private final Semaphore seats;
    private final WaiterPool waiterPool;

    public WaitingForSeatHandler(Semaphore seats, WaiterPool waiterPool) {
        this.seats = seats;
        this.waiterPool = waiterPool;
    }

    @Override
    public void handle(Customer customer) {
        try {
            if (seats.tryAcquire()) {
                System.out.println("Seat is available");
                Waiter waiter = waiterPool.acquire();
                System.out.println("Waiter " + waiter.getName() + " is seating the customer " + customer + "-" + Thread.currentThread() + " and gives menu");
                waiter.run();
                waiterPool.release(waiter);
                next.handle(customer);
            }
        } catch (InterruptedException e) {
            //ignored
        }
    }
}
