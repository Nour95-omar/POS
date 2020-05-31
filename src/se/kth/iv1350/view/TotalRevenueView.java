package se.kth.iv1350.view;

import se.kth.iv1350.model.PaymentObserver;

public class TotalRevenueView implements PaymentObserver {



    @Override
    public void updateTotal(double total) {
        System.out.println("*************************************************");
        System.out.println("*****************TotalRevenueView****************");
        System.out.println("Hello, the total amount paid for purchases = " + total+ " kr.\n");

    }
}
