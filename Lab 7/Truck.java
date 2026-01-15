/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * Truck.java
 * This class represents a Truck, which is a type of Vehicle.
 * It extends the Vehicle class and implements the Rentable and Insurable behaviors
 * inherited from Vehicle (through interfaces).
 * 
 * Author: amuleekreehal
 */
package labs;

public class Truck extends Vehicle {

    // Specific field for Truck: the maximum load capacity in tons
    private double loadCapacityInTons;

    /**
     * Constructor for Truck.
     * Calls the superclass (Vehicle) constructor to initialize plate number, model, and year.
     * Initializes the Truck-specific field loadCapacityInTons.
     * 
     * @param plateNumber the license plate of the truck
     * @param model the model name of the truck
     * @param year the manufacturing year
     * @param loadCapacityInTons the maximum load capacity in tons
     */
    public Truck(String plateNumber, String model, int year, double loadCapacityInTons) {
        super(plateNumber, model, year); // Call Vehicle constructor
        this.loadCapacityInTons = loadCapacityInTons; // Initialize truck-specific field
    }

    /**
     * Getter for load capacity
     * @return the load capacity of the truck in tons
     */
    public double getLoadCapacityInTons() {
        return loadCapacityInTons;
    }

    /**
     * Overrides Vehicle's toString() method.
     * Provides a human-readable string representation of the truck,
     * including its type, basic vehicle info (plate, model, year), and load capacity.
     * 
     * @return a string representation of the truck
     */
    @Override
    public String toString() {
        return "Truck: " + super.toString() + // Calls Vehicle's toString()
               " [Capacity: " + loadCapacityInTons + " tons]";
    }

    /**
     * Overrides Vehicle's calculateRentalPrice() method.
     * Computes the rental price based on number of days and truck's load capacity.
     * Formula: $90/day + $10 per ton of capacity
     * 
     * @param days the number of days to rent the truck
     * @return total rental price
     */
    @Override
    public double calculateRentalPrice(int days) {
        double dailyRate = 90 + (10 * loadCapacityInTons); // Base + per-ton rate
        return dailyRate * days; // Total for all days
    }

    /**
     * Overrides Vehicle's calculateInsurancePremium() method.
     * Uses the base insurance rate from Vehicle and increases it by 50% for trucks.
     * 
     * Steps:
     * 1. Get base insurance rate from Vehicle using inherited getBaseInsuranceRate()
     * 2. Multiply by 1.5 to add 50% premium
     * 3. Multiply by number of rental days
     * 
     * @param days the number of rental days
     * @return total insurance premium
     */
    @Override
    public double calculateInsurancePremium(int days) {
        double baseInsuranceRate = getBaseInsuranceRate(); // Inherited from Vehicle (always 20.0)
        double dailyInsurance = baseInsuranceRate * 1.5;   // Truck-specific 50% increase
        return dailyInsurance * days; // Total for all days
    }

    /**
     * Static method to print the type of this vehicle.
     * Demonstrates method hiding (static methods are not overridden in Java).
     */
    public static void printVehicleType() {
        System.out.println("Truck");
    }
}
