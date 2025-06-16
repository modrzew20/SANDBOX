package dm.sandbox.pattern;

import dm.sandbox.Customer;
import dm.sandbox.Waiter;
import dm.sandbox.WaiterPool;

public class OrderHandler extends ChainHandler {
    private final WaiterPool waiterPool;


    public OrderHandler(WaiterPool waiterPool) {
        this.waiterPool = waiterPool;
    }

    @Override
    public void handle(Customer customer) {
        try {
            Waiter acquire = waiterPool.acquire();
            Thread.sleep(300);
            acquire.run();
            waiterPool.release(acquire);
            System.out.println("Klient " + customer.getName() + " złożył zamówienie");
        } catch (InterruptedException e) {
        //ignore
        }
        next.handle(customer);
    }
}
