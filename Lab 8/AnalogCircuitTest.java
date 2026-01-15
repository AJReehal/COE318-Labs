/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab8;

/**
 *
 * @author amuleekreehal
 */

import org.junit.Test;
import static org.junit.Assert.*;

public class AnalogCircuitTest {

    @Test
    public void testResistorToStringContainsData() {
        Resistor r = new Resistor(1, 2, 100.0);
        String s = r.toString();

        assertTrue("Resistor string should start with R", s.startsWith("R"));
        assertTrue("Resistor string should contain node1", s.contains("1"));
        assertTrue("Resistor string should contain node2", s.contains("2"));
        assertTrue("Resistor string should contain value", s.contains("100.0"));
    }

    @Test
    public void testResistorIdsAreDifferent() {
        Resistor r1 = new Resistor(1, 2, 50.0);
        Resistor r2 = new Resistor(2, 3, 75.0);

        String s1 = r1.toString();
        String s2 = r2.toString();

        assertNotEquals("Two different resistors should not have identical toString()", s1, s2);
    }

    @Test
    public void testCircuitToSpiceContainsComponents() {
        Circuit c = new Circuit();

        Resistor r1 = new Resistor(1, 2, 100.0);
        Resistor r2 = new Resistor(2, 3, 200.0);
        VoltageSource v1 = new VoltageSource(0, 1, 5.0);

        c.addResistor(r1);
        c.addResistor(r2);
        c.addVoltageSource(v1);

        String spice = c.toSpice();

        assertTrue("SPICE output should contain first resistor",
                spice.contains("1 2 100.0"));
        assertTrue("SPICE output should contain second resistor",
                spice.contains("2 3 200.0"));
        assertTrue("SPICE output should contain voltage source",
                spice.contains("0 1 DC 5.0"));
    }
}
