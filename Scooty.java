public class Scooty extends Vehicle {
    ScootyType fuelType;

    public Scooty(int id, ScootyType fuelType) {
        super(id, VehicleType.SCOOTY);
        this.fuelType = fuelType;
    }

}
