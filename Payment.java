public class Payment {
    int rentalId;
    int amountOwed;
    int amountPaid;
    boolean isPaid;
    int paymentId;

    public Payment(int rentalId, int amountOwed) {
        this.rentalId = rentalId;
        this.amountOwed = amountOwed;
        this.amountPaid = 0;
        this.isPaid = false;
    }

    public void recordPayment(int amount) {
        amountPaid += amount;
        if(amountPaid == amountOwed) {isPaid = true;}
    }

}
