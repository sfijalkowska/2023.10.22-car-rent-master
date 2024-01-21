package com.comarch.camp.it.rent.car.db;

import com.comarch.camp.it.rent.car.authenticate.Authenticator;
import com.comarch.camp.it.rent.car.model.*;

import java.util.Collection;
import java.util.HashMap;

public class VehicleRepository {
    private final HashMap<String, Vehicle> vehicles = new HashMap<>();

    public VehicleRepository() {
        this.vehicles.put("KR11",
                new Car("BMW", "5", 2020, 399.99, "KR11"));
        this.vehicles.put("KR22",
                new Car("Audi", "A6", 2021, 499.99, "KR22"));
        this.vehicles.put("KR33",
                new Car("Toyota", "Corolla", 2019, 299.99, "KR33"));
        this.vehicles.put("KR44",
                new Car("Honda", "Civic", 2020, 299.99, "KR44"));
        this.vehicles.put("KR55",
                new Car("Kia", "Ceed", 2015, 199.99, "KR55"));
        this.vehicles.put("KR66",
                new Bus("Solaris", "S1000", 2020, 800.00, "KR66", 50));
        this.vehicles.put("KR77",
                new Bus("Mercedes", "Turbo", 2020, 900.00, "KR77", 55));
        this.vehicles.put("KR88",
                new Bus("Solaris", "Super", 2020, 850.00, "KR88", 52));
        this.vehicles.put("KR99",
                new Truck("Scania", "Wielka", 2010, 500.00,
                        "KR99", 4000));
        this.vehicles.put("KR10",
                new Motorcycle("Honda", "CVS", 2015, 400.00,
                        "KR10", true));
        this.vehicles.put("BENTLEY",
                new LuxuryCar("Bentley", "Continentral", 2022,
                        5000.00, "BENTLEY"));
        this.vehicles.put("FERRARI",
                new LuxuryCar("Ferrari", "Italia", 2020,
                        6000.00, "FERRARI"));
    }

    public boolean rentVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle instanceof LuxuryCar &&
                !"ADMIN".equals(Authenticator.loggedUserRole)) {
            return false;
        }
        if(vehicle != null && !vehicle.isRent()) {
            vehicle.setRent(true);
            return true;
        }
        return false;
    }
    public boolean returnVehicle(String plate) {
        Vehicle vehicle = this.vehicles.get(plate);
        if(vehicle instanceof LuxuryCar &&
                !"ADMIN".equals(Authenticator.loggedUserRole)) {
            return false;
        }
        if(vehicle != null && vehicle.isRent()) {
            vehicle.setRent(false);
            return true;
        }
        return false;
    }

    public Collection<Vehicle> getVehicles() {
        return this.vehicles.values();
    }
}
