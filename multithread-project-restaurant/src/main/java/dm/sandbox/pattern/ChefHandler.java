package dm.sandbox.pattern;

import dm.sandbox.Chef;
import dm.sandbox.Customer;

import java.util.logging.Logger;

public class ChefHandler extends ChainHandler {

    private static final Logger log = Logger.getLogger("Thread: " + Thread.currentThread());

    private Chef chef;

    public ChefHandler(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void handle(Customer customer) {
        chef.run();
        next.handle(customer);
    }
}
