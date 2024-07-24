public class HourlyPayCalculator implements PayCalculator {
    int hourlyRate;

    public HourlyPayCalculator(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    @Override
    public int calculatePayment(int daysRented) {
        return daysRented*24*hourlyRate;
    }
}