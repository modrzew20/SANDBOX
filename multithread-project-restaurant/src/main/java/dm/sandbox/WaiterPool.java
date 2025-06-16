package dm.sandbox;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class WaiterPool {

    private final BlockingQueue<Waiter> available;

    public WaiterPool(int size) {
        this.available = new ArrayBlockingQueue<>(size);
        for (int i = 0; i < size; i++) {
            available.add(new Waiter("Kelner-" + i));
        }
    }

    public Waiter acquire() throws InterruptedException {
        return available.take();
    }

    public void release(Waiter waiter) {
        available.offer(waiter);
    }

}
