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
 * The InternationalParcel class represents a shipment that crosses national borders.
 * It extends the base Parcel class and adds international-specific fields and costs.
 */
public class InternationalParcel extends Parcel {
    
    // Instance variables specific to an international shipment:
    private final String region;      // Stores the destination region (e.g., "EU", "APAC").
    private final double customsRate; // Stores the percentage used to calculate customs duty (must be 0.0 to 0.25).

    /**
     * Constructor for the InternationalParcel class.
     * * @param weightKg      The weight of the parcel in kilograms.
     * @param distanceKm    The distance to be shipped in kilometers.
     * @param insured       Indicates if the parcel is insured.
     * @param region        The destination region of the parcel.
     * @param customsRate   The customs duty rate (0.0 to 0.25).
     */
    public InternationalParcel(double weightKg, double distanceKm, boolean insured,
                               String region, double customsRate) {
        
        // Call the superclass (Parcel) constructor to initialize inherited fields 
        // (weight, distance, insured).
        super(weightKg, distanceKm, insured); 
        
        // Validate that the provided customs rate is within the allowable range (0% to 25%).
        if (customsRate < 0 || customsRate > 0.25) {
            // Throw an exception if the rate is invalid to prevent object creation.
            throw new IllegalArgumentException("customsRate must be between 0.0 and 0.25");
        }
        
        // Initialize the InternationalParcel-specific fields.
        this.region = region;
        this.customsRate = customsRate;
    }

    /**
     * Calculates the total shipping cost for the international parcel.
     * This overrides the base shippingCost() method to include international fees.
     * * The total cost is: Base Cost + Fixed Cross-Border Fee ($8.00) + Customs Duty.
     * * @return The final total shipping cost.
     */
    @Override
    public double shippingCost() {
        // Retrieve the base shipping cost (from the Parcel superclass) before any international fees.
        double base = super.shippingCost();
        
        // Calculate the customs duty: customsRate (percentage) multiplied by the base cost.
        double duty = customsRate * base;
        
        // Calculate the final cost by summing the base cost, the fixed cross-border fee ($8.00), 
        // and the calculated customs duty.
        double finalcost = 8.00 + base + duty;
        
        // Return the final cost to the user.
        return finalcost;
    }
    
}