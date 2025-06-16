package dm.sandbox.pattern;

import dm.sandbox.Customer;

public abstract class ChainHandler {

    protected ChainHandler next;

    public ChainHandler() {
    }

    public abstract void handle(Customer customer);

    public ChainHandler setNext(ChainHandler next) {
        this.next = next;
        return next;
    }
}
