public class Vehicle {
    int id;
    VehicleType type;
    boolean isReserved;
    public Vehicle(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        isReserved = false;
    }

    public boolean rentVehicle() {
        if(isReserved) {return false;}
        isReserved = true;
        return true;
    }

    public boolean returnVehicle() {
        isReserved = false;
        return true;
    }

    public boolean getStatus() {
        isReserved = false;
        return true;
    }
}