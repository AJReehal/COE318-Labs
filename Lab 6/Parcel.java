/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shipment;

/**
 *
 * @author amuleekreehal
 */
public class Parcel {
    // Defines a public class named 'Parcel' which represents an item being shipped.
    
    protected final double weightKg;
    // Declares a protected, final variable to store the parcel's weight in kilograms.
    // 'final' means the value cannot be changed after assignment (in the constructor).
    // 'protected' allows subclasses to access this field directly.
    
    protected final double distanceKm;
    // Declares a protected, final variable to store the shipping distance in kilometers.
    
    protected final boolean insured;
    // Declares a protected, final variable to store whether the parcel is insured (true/false).

    public Parcel(double weightKg, double distanceKm, boolean insured) {
        // This is the constructor for the Parcel class.
        // It takes the weight, distance, and insurance status as arguments.
        
        if (weightKg <= 0 || distanceKm < 0) {
            // Checks for invalid input:
            // 1. Weight must be greater than 0.
            // 2. Distance must be greater than or equal to 0.
            
            throw new IllegalArgumentException("Weight must be > 0 and distance >= 0");
            // If the input is invalid, it throws an exception with an error message,
            // preventing the creation of an invalid Parcel object.
        }
        
        this.weightKg = weightKg;
        // Assigns the valid input 'weightKg' to the object's instance variable 'this.weightKg'.
        
        this.distanceKm = distanceKm;
        // Assigns the valid input 'distanceKm' to the object's instance variable 'this.distanceKm'.
        
        this.insured = insured;
        // Assigns the input 'insured' status to the object's instance variable 'this.insured'.
    }

    public double shippingCost() {
        // Declares a public method named 'shippingCost' that calculates and returns the cost as a double.
        
        // Base: weight + distance, with small base fee
        // Calculates the initial shipping cost based on a fixed fee, weight, and distance.
        double base = 3.50 + (weightKg * 1.20) + (distanceKm * 0.05);
        // Breakdown:
        // 3.50 is a fixed base fee.
        // (weightKg * 1.20) adds $1.20 for every kilogram of weight.
        // (distanceKm * 0.05) adds $0.05 for every kilometer of distance.
        
        if (insured) base += Math.max(1.50, 0.02 * base);
        // Checks if the parcel is insured.
        // If 'insured' is true:
        //   It adds an insurance fee to the 'base' cost.
        //   The insurance fee is the maximum of:
        //     1. A minimum flat fee of $1.50.
        //     2. 2% (0.02) of the calculated 'base' cost.
        
        return base;
        // Returns the final calculated shipping cost (including insurance if applicable).
    }
}