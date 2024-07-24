
import java.time.LocalDate;
import java.util.List;
import java.util.*;

public class RentShop {
    private static RentShop INSTANCE;
    int cusCount = 0;
    int vehicleCount = 0;
    Map<Integer, Customer> customerMap;
    Map<Integer, Vehicle> vehicleMap;
    Map<Integer, Rental> rentalMap;
    Map<Integer, Payment> paymentMap;
    Set<Integer> rentedVehicles;
    PayCalculator calculator;

    private RentShop() {
        this.customerMap = new HashMap<Integer, Customer>();
        this.vehicleMap = new HashMap<Integer, Vehicle>();
        this.rentalMap = new HashMap<>();
        this.paymentMap = new HashMap<>();
        this.rentedVehicles = new HashSet();
        this.calculator = new HourlyPayCalculator(2);
    }

    public static RentShop getInstance() {
        if(RentShop.INSTANCE == null) {
            RentShop.INSTANCE = new RentShop();
        }
        return RentShop.INSTANCE;
    }

    public void addVehicle(Vehicle vehicle) {
        vehicleMap.put(++vehicleCount, vehicle);
    }

    public void addCustomer(Customer customer) {
        customerMap.put(++cusCount, customer);
    }

    public boolean RentVehicle(int vehicleId, int customerId) {
        rentedVehicles.add(vehicleId);
        Vehicle vehicle = vehicleMap.get(vehicleId);
        if(vehicle.getStatus()) {
            return false;
        }
        Rental rental = new Rental(vehicleId, customerId, LocalDate.now(), LocalDate.now());
        vehicle.rentVehicle();
        rentalMap.put(0, rental);
        return true;
    }

    public boolean returnVehicle(int rentalId) {
        Rental rental = rentalMap.get(rentalId);
        rental.returnRental();
        int timeRented = rental.getRentedTime();
        rentedVehicles.remove(rental.vehicleId);
        int moneyOwed = calculator.calculatePayment(timeRented);
        Payment payment = new Payment(rental.rentalId, moneyOwed);
        paymentMap.put(0, payment);
        return true;
    }

    public boolean recordPayment(int paymentId, int money) {
        Payment payment = paymentMap.get(paymentId);
        payment.recordPayment(money);
        return true;
    }
}
