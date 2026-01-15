/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shipment;

/**
 *
 * @author amuleekreehal
 */

/**
 * The StandardParcel class represents a standard package that extends the basic
 * Parcel class by adding a size category, which affects the handling fee.
 * It inherits attributes like weight, distance, and insurance status from Parcel.
 */
class StandardParcel extends Parcel {
    
    // Protected and final field to store the size category of the parcel.
    // The valid values are "S" (Small), "M" (Medium), or "L" (Large).
    protected final String sizeTier;

    /**
     * Constructor for StandardParcel.
     * * @param weightKg The weight of the parcel in kilograms.
     * @param distanceKm The distance the parcel will travel in kilometers.
     * @param insured A boolean indicating if the parcel is insured.
     * @param sizeTier The size category of the parcel ("S", "M", or "L").
     */
    public StandardParcel(double weightKg, double distanceKm, boolean insured, String sizeTier) {
        // First, call the constructor of the parent class (Parcel) 
        // to initialize the shared attributes (weight, distance, insured).
        super(weightKg, distanceKm, insured);
        
        // Input validation: Check if the provided sizeTier is one of the allowed values ("S", "M", or "L").
        // The regex pattern "[SML]" checks for exactly one of those characters.
        if (!sizeTier.matches("[SML]")) {
            // If the sizeTier is invalid, throw an exception to prevent object creation 
            // with incorrect data.
            throw new IllegalArgumentException("sizeTier must be S, M, or L");
        }
        
        // Assign the validated sizeTier to the class field.
        this.sizeTier = sizeTier;
    }

    /**
     * Calculates the total shipping cost for the StandardParcel.
     * This method overrides the parent's shippingCost() method 
     * to add a size-dependent handling surcharge.
     * * @return The total shipping cost, including the base cost and the handling fee.
     */
    @Override
    public double shippingCost() {
        // Get the base shipping cost calculated by the parent class (Parcel).
        double cost = super.shippingCost();
        
        // Initialize the handling surcharge amount to zero.
        double handling = 0;
        
        // Determine the extra handling fee based on the parcel's sizeTier.
        if (sizeTier.equals("S")){
            // Small Parcel ("S"): add a surcharge of +0.75.
            handling += 0.75;
        } else if (sizeTier.equals("M")) {
            // Medium Parcel ("M"): add a surcharge of +1.25.
            handling += 1.25;            
        } else {  
            // Large Parcel ("L"): Since the constructor validates the size, 
            // the 'else' block implicitly handles the "L" case.
            // Add a surcharge of +1.75.
            handling += 1.75;
        }
        
        // Return the final total cost: base cost plus the size-dependent handling fee.
        return cost + handling;
    }

}