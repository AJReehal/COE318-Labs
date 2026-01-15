/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package labs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author rhake
 */
public class VehicleTest {
    Car instance;
    
    public VehicleTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
        
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
        instance= new Car("BDTC-424", "Porsche 9/11",2020,true);
    }
    
    @AfterEach
    public void tearDown() {
    }


    /**
     * Test of calculateRentalPrice method, of class Car.
     */
    @Test
    public void testCalculateRentalPrice_int() {
        System.out.print("check Rental price for 3 days of a porsche, automatic 2020 ");
        assertEquals(195.0, instance.calculateRentalPrice(3), 0.0001); // 65 * 3
        // TODO review the generated test code and remove the default call to fail.
    }

    /**
     * Test of calculateInsurancePremium method, of class Car.
     */
    @Test
    public void testCalculateInsurancePremium() {
        System.out.print("check Insurance Premium for 3 days of a porsche, automatic 2020 ");
        assertEquals(225.0, instance.calculateRentalPrice(3, true), 0.0001); 
    }


}
