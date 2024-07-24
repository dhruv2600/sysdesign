
import java.time.LocalDate;

public class Rental {
    int rentalId;
    int vehicleId;
    int customerId;
    LocalDate rentDate;
    LocalDate returnDate;
    boolean isActive;

    public Rental(int vehicleId, int customerId, LocalDate rentDate, LocalDate returnDate) {
        this.vehicleId = vehicleId;
        this.customerId = customerId;
        this.rentDate = rentDate;
        this.returnDate = returnDate;
        this.isActive = true;
    }

    public void returnRental() {
        this.returnDate = LocalDate.now();
        this.isActive = false;
    }

    public int getRentedTime() {
        int daysRented = returnDate.getDayOfMonth() - rentDate.getDayOfMonth();
        return daysRented;
    }

}
