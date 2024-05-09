package DTO;

public class Vehicle {

	private String type;
    private int quantity;
    private double pricePerHour;

    public Vehicle(String type, int quantity, double pricePerHour) {
        this.type = type;
        this.quantity = quantity;
        this.pricePerHour = pricePerHour;
    }

    public String getType() {
        return type;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPricePerHour() {
        return pricePerHour;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
