package dm.sandbox;

import java.util.concurrent.Semaphore;
import java.util.logging.Logger;

public class Chef implements Runnable {

    private final static Logger log = Logger.getLogger("Thread: " + Thread.currentThread());

    private final Semaphore meals = new Semaphore(2);

    public Chef() {
    }

    @Override
    public void run() {
        if (meals.tryAcquire()) {
            log.info("Prepare the meal");
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                //ignored
            }
            meals.release();
        }
    }
}
