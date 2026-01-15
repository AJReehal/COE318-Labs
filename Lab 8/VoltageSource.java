/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab8;

/**
 *
 * @author amuleekreehal
 */

 // Represents one DC voltage source in the circuit.
 
public class VoltageSource {

    private static int nextId = 1;   // V1, V2, V3...

    private int id;
    private int node1;
    private int node2;
    private double voltage;

    public VoltageSource(int node1, int node2, double voltage) {
        this.id = nextId++;
        this.node1 = node1;
        this.node2 = node2;
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "V" + id + " " + node1 + " " + node2 + " DC " + voltage;
    }
}
