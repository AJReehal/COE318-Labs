/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab8;

/**
 *
 * @author amuleekreehal
*/


import java.util.Scanner;

// Main class for reading user commands and building a simple circuit.
public class UserMain {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Circuit circuit = new Circuit();

        // Continuous loop to read user commands.
        while (true) {
            String line = input.nextLine().trim();

            // Handles the "end" command to quit the program.
            if (line.equalsIgnoreCase("end")) {
                System.out.println("All Done");
                break;
            }

            // Handles the "spice" command to print the circuit.
            else if (line.equalsIgnoreCase("spice")) {
                System.out.print(circuit.toSpice());
            }

            // Handles adding a resistor (r node1 node2 value).
            else if (line.toLowerCase().startsWith("r ")) {
                String[] parts = line.split("\\s+");
                if (parts.length == 4) {
                    int node1 = Integer.parseInt(parts[1]);
                    int node2 = Integer.parseInt(parts[2]);
                    double value = Double.parseDouble(parts[3]);

                    Resistor r = new Resistor(node1, node2, value);
                    circuit.addResistor(r);
                }
            }

            // Handles adding a voltage source (v node1 node2 value).
            else if (line.toLowerCase().startsWith("v ")) {
                String[] parts = line.split("\\s+");
                if (parts.length == 4) {
                    int node1 = Integer.parseInt(parts[1]);
                    int node2 = Integer.parseInt(parts[2]);
                    double voltage = Double.parseDouble(parts[3]);

                    VoltageSource v = new VoltageSource(node1, node2, voltage);
                    circuit.addVoltageSource(v);
                }
            }

        }

        input.close();
    }
}