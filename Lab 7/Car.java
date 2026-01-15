/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*
 * Car.java
 * This class represents a Car, which is a type of Vehicle.
 * It extends the Vehicle class and implements Rentable and Insurable behavior
 * inherited from Vehicle (through interfaces).
 * 
 * The Car class adds a specific property 'automatic' to indicate whether the
 * car has an automatic transmission, and it customizes rental price and
 * insurance calculations. It also demonstrates method overloading and static
 * method hiding.
 * 
 * Author: amuleekreehal
 */

package labs;

public class Car extends Vehicle {

    // Specific field for Car: whether the transmission is automatic
    private boolean automatic;

    /**
     * Constructor for Car.
     * Calls the superclass (Vehicle) constructor to initialize plate number, model, and year.
     * Initializes the Car-specific field 'automatic'.
     * 
     * @param plateNumber The car's license plate number
     * @param model The car's model
     * @param year The car's manufacturing year
     * @param automatic True if the car has an automatic transmission, false if manual
     */
    public Car(String plateNumber, String model, int year, boolean automatic) {
        super(plateNumber, model, year); // Call Vehicle constructor
        this.automatic = automatic;      // Initialize car-specific field
    }

    /**
     * Getter for transmission type
     * @return True if automatic, false if manual
     */
    public boolean isAutomatic() {
        return automatic;
    }

    /**
     * Overrides Vehicle's toString() method.
     * Provides a human-readable string representation of the car,
     * including its type, basic vehicle info (plate, model, year), and transmission type.
     * 
     * @return a string representation of the car
     */
    @Override
    public String toString() {
        return "Car: " + super.toString() + 
               (automatic ? " [Automatic]" : " [Manual]");
    }

    /**
     * Overrides Vehicle's calculateRentalPrice() method.
     * Computes the rental price based on number of days and transmission type.
     * Rate: $65/day for automatic, $55/day for manual.
     * 
     * @param days Number of rental days
     * @return Total rental price
     */
    @Override
    public double calculateRentalPrice(int days) {
        if (automatic) {
            return 65.0 * days; // Higher daily rate for automatic
        } else {
            return 55.0 * days; // Lower daily rate for manual
        }
    }

    /**
     * Overrides Vehicle's calculateInsurancePremium() method.
     * Uses the base insurance premium from Vehicle and applies a 10% surcharge.
     * 
     * @param days Number of rental days
     * @return Total insurance premium
     */
    @Override
    public double calculateInsurancePremium(int days) {
        double base = super.calculateInsurancePremium(days); // Base from Vehicle
        return base * 1.10; // Apply 10% surcharge for cars
    }

    /**
     * Overloaded version of calculateRentalPrice().
     * Adds an optional daily fee for GPS inclusion.
     * 
     * @param days Number of rental days
     * @param gpsIncluded True if GPS is requested, false otherwise
     * @return Total rental price including optional GPS fee
     */
    public double calculateRentalPrice(int days, boolean gpsIncluded) {
        double base = calculateRentalPrice(days); // Base price without GPS
        if (gpsIncluded) {
            base += 10.0 * days; // Add $10/day for GPS
        }
        return base;
    }

    /**
     * Static method to print the type of this vehicle.
     * Demonstrates method hiding (static methods are not overridden in Java).
     */
    public static void printVehicleType() {
        System.out.println("Car");
    }
}
