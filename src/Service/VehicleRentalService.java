package Service;

import java.util.Date;
import java.util.List;

import DTO.Branch;
import DTO.Vehicle;
import Repository.VehicleRentalRepository;

public class VehicleRentalService {
	
	private VehicleRentalRepository repository;

    public VehicleRentalService(VehicleRentalRepository repository) {
        this.repository = repository;
    }
    public void addBranch(String name, List<String> vehicles) {
        Branch branch = new Branch(name);
        for (String vehicle : vehicles) {
            String[] parts = vehicle.split(" for ");
            String[] quantityPrice = parts[0].split(" ");
            int quantity = Integer.parseInt(quantityPrice[0]);
            String type = quantityPrice[1];
            String[] pricePerHour = parts[1].split(" ");
            double price = Double.parseDouble(pricePerHour[pricePerHour.length - 2].replace("Rs.", ""));
            Vehicle v = new Vehicle(type, quantity, price);
            branch.addVehicle(v);
        }
        repository.addBranch(branch);
    }
 
    public void addVehicle(String branchName, String vehicle) {
        Branch branch = repository.getBranch(branchName);
        if (branch!= null) {
            String[] parts = vehicle.split(" ");
            int quantity = Integer.parseInt(parts[0]);
            String type = parts[1];
            Vehicle v = branch.getVehicles().get(type);
            if (v!= null) {
                v.setQuantity(v.getQuantity() + quantity);
            } else {
                double pricePerHour = branch.getVehicles().values().stream()
                       .filter(vehicleType -> vehicleType.getType().equals(type))
                       .findFirst()
                       .orElseThrow()
                       .getPricePerHour();
                v = new Vehicle(type, quantity, pricePerHour);
                branch.addVehicle(v);
            }
        }
    }

    public void rentVehicle(String type, Date startTime, Date endTime) {
        List<Branch> branches = repository.getAllBranches();
        for (Branch branch : branches) {
            Vehicle vehicle = branch.getVehicles().get(type);
            if (vehicle!= null && vehicle.getQuantity() > 0) {
                vehicle.setQuantity(vehicle.getQuantity() - 1);
                System.out.println("Booked " + type + " from " + branch.getName());
                return;
            }
        }
        System.out.println("No vehicle available");
    }

    public void printSystemViewForTimeSlot(Date startTime, Date endTime) {
        List<Branch> branches = repository.getAllBranches();
        for (Branch branch : branches) {
            System.out.println(branch.getName() + ":");
            for (Vehicle vehicle : branch.getVehicles().values()) {
                if (vehicle.getQuantity() == 0) {
                    System.out.println("All " + vehicle.getType() + " are booked.");
                } else {
                    System.out.println(vehicle.getType() + " is available for Rs." + vehicle.getPricePerHour());
                }
            }
        }
    }
}
