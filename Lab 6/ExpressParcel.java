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
 * The ExpressParcel class represents a fast-track shipment.
 * It extends StandardParcel, inheriting all base parcel properties 
 * and adding logic for express delivery surcharges.
 */
class ExpressParcel extends StandardParcel {
    
    // Instance variable specific to ExpressParcel
    private final boolean sameDay; // Indicates whether the package requires same-day delivery

    /**
     * Constructor for the ExpressParcel.
     * * @param weightKg The weight of the parcel in kilograms.
     * @param distanceKm The distance to be shipped in kilometers.
     * @param insured Whether the parcel is insured (true/false).
     * @param sizeTier The size classification of the parcel (e.g., 'S', 'M', 'L').
     * @param sameDay Whether same-day delivery is requested.
     */
    public ExpressParcel(double weightKg, double distanceKm, boolean insured,
                         String sizeTier, boolean sameDay) {
        
        // Call the superclass (StandardParcel) constructor to initialize 
        // inherited fields (weight, distance, insured, sizeTier).
        super(weightKg, distanceKm, insured, sizeTier);
        
        // Initialize the ExpressParcel-specific field.
        this.sameDay = sameDay;
    }

    /**
     * Calculates the total shipping cost for the express parcel.
     * This overrides the method in StandardParcel to add express premiums.
     * * @return The final total shipping cost as a double.
     */
    @Override
    public double shippingCost() {
   
        // Get the base shipping cost calculated by the StandardParcel class 
        // (which includes weight, distance, and insurance premiums).
        double cost = super.shippingCost();
        
        // Apply Express Surcharge Below
        
        // Apply the express speed premium: Increase the standard cost by 35% 
        // (cost * 1.35).
        cost *= 1.35; 
        
        // Check if the same-day delivery option was selected.
        if (sameDay == true) {
            // If same-day is true, add an additional flat fee of $7.50.
            cost += 7.50;
        }
        
        // Return the final calculated cost.
        return cost;
    }
}