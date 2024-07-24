public class Bike extends Vehicle{
    BikeSize size;
    public Bike(int id, BikeSize size) {
        super(id, VehicleType.BIKE);
        this.size = size;
    }
}
