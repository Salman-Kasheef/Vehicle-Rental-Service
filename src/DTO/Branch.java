package DTO;

import java.util.HashMap;
import java.util.Map;

public class Branch {

	  private String name;
	    private Map<String, Vehicle> vehicles;

	    public Branch(String name) {
	        this.name = name;
	        this.vehicles = new HashMap<>();
	    }

	    public String getName() {
	        return name;
	    }

	    public Map<String, Vehicle> getVehicles() {
	        return vehicles;
	    }

	    public void addVehicle(Vehicle vehicle) {
	        vehicles.put(vehicle.getType(), vehicle);
	    }
	}
