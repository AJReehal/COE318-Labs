/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab8;

/**
 *
 * @author amuleekreehal
 */



 // Represents one resistor in the circuit.
 
public class Resistor {

    private static int nextId = 1;   // R1, R2, R3...

    private int id;
    private int node1;
    private int node2;
    private double value;

    public Resistor(int node1, int node2, double value) {
        this.id = nextId++;
        this.node1 = node1;
        this.node2 = node2;
        this.value = value;
    }

    @Override
    public String toString() {
        return "R" + id + " " + node1 + " " + node2 + " " + value;
    }
}
