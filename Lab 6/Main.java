/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package shipment;

/**
 *
 * @author amuleekreehal
 */
public class Main {
    public static void main(String[] args) {
        Parcel[] parcels = new Parcel[] {
            new StandardParcel(2.0, 120, true, "M"),
            new ExpressParcel(1.0, 40, false, "S", true),
            new InternationalParcel(3.2, 800, true, "EU", 0.12),
        };

        for (Parcel p : parcels) {
            System.out.printf("  Cost: $%.2f%n", p.shippingCost());
        }
    }
    
}