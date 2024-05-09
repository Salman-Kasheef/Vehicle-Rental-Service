package Main;

import java.util.Arrays;
import java.util.Date;

import Repository.VehicleRentalRepository;
import Service.VehicleRentalService;

public class Driver {
	 public static void main(String[] args) {
		 VehicleRentalRepository repository = new VehicleRentalRepository();
	        VehicleRentalService service = new VehicleRentalService(repository);

	        service.addBranch("koramangala", Arrays.asList("1 suv for Rs.12 per hour", "3 sedan for Rs.10 per hour", "3 bikes for Rs.20 per hour"));
	     
	        service.addVehicle("koramangala", "1 sedan");

	        service.rentVehicle("suv", new Date(), new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000));
	       

	        service.printSystemViewForTimeSlot(new Date(System.currentTimeMillis() + 1 * 60 * 60 * 1000), new Date(System.currentTimeMillis() + 2 * 60 * 60 * 1000));
	    }
}
