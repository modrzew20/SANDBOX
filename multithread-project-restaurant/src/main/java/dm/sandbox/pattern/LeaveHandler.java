package dm.sandbox.pattern;

import dm.sandbox.Customer;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class LeaveHandler extends ChainHandler {

    private final Semaphore seats;

    public LeaveHandler( Semaphore seats) {
        this.seats = seats;
    }

    @Override
    public void handle(Customer customer) {
        System.out.println("Jam jam");
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            //ignored
        }
        seats.release();
    }
}
