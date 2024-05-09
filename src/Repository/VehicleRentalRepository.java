package Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import DTO.Branch;

public class VehicleRentalRepository {
	
	 private Map<String, Branch> branches;

	    public VehicleRentalRepository() {
	        this.branches = new HashMap<>();
	    }

	    public void addBranch(Branch branch) {
	        branches.put(branch.getName(), branch);
	    }

	    public Branch getBranch(String name) {
	        return branches.get(name);
	    }

	    public List<Branch> getAllBranches() {
	        return new ArrayList<>(branches.values());
	    }
}
