/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * RentalContract.java
 * This class represents a rental contract for any object that implements the Rentable interface (like a Vehicle, Car, or Truck).
 * It calculates the total price of the rental, optionally including insurance, and can print a summary of the contract.
 * 
 * Author: amuleekreehal
 */
package labs;

public class RentalContract {

    // The item being rented (any object implementing Rentable, e.g., Car or Truck)
    private Rentable rentable;        

    // Duration of the rental in days
    private int days;

    // Flag indicating whether optional insurance is included in this contract
    private boolean insuranceAdded;

    /**
     * Constructor for RentalContract.
     * Initializes the rentable item, rental duration, and insurance option.
     *
     * @param rentable The object being rented
     * @param days Number of rental days
     * @param insuranceAdded True if insurance is included, false otherwise
     */
    public RentalContract(Rentable rentable, int days, boolean insuranceAdded) {
        this.rentable = rentable;
        this.days = days;
        this.insuranceAdded = insuranceAdded;
    }

    /**
     * Calculates the total price of the rental contract.
     * This includes the base rental price plus the insurance premium if insurance is selected.
     *
     * @return The total price of the rental contract as a double
     */
    public double calculateTotalPrice() {
        // Calculate base rental price using polymorphism
        // The actual method called depends on the runtime type of 'rentable' (Car, Truck, etc.)
        double basePrice = this.rentable.calculateRentalPrice(this.days);

        double insurance = 0.0; // Initialize insurance cost to 0

        // If insurance is added, calculate the insurance premium
        if (insuranceAdded) {
            // Safe cast: all Rentable objects we use (Car, Truck) also implement Insurable
            insurance = ((Insurable) rentable).calculateInsurancePremium(days);
        }

        // Total price = base rental price + insurance premium (if any)
        return basePrice + insurance;
    }

    /**
     * Prints a formatted summary of the rental contract.
     * Includes vehicle type, rental duration, insurance info, and total price.
     */
    public void printSummary() {
        System.out.println("=== Rental Contract Summary ===");

        // Print the simple class name of the rented object (e.g., "Car" or "Truck")
        System.out.println("Vehicle type: " + rentable.getClass().getSimpleName());

        // Print the number of rental days
        System.out.println("Days: " + days);

        // Print whether insurance is included
        System.out.println("Insurance added: " + insuranceAdded);

        // Print the total price calculated by calculateTotalPrice()
        System.out.println("Total price: " + calculateTotalPrice());

        System.out.println("===============================");
    }
}
