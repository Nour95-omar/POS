package se.kth.iv1350.model;

/**
 * A listener interface for receiving notifications about
 * payment process. The class that is interested in such
 * notifications implements this interface.
 */
public interface PaymentObserver {
    /**
     * Invoked when a sale paid.
     * @param totalPrice the total of the made payment.
     */
    void updateTotal(double totalPrice);

}
