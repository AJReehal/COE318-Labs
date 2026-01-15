/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab8;

/**
 *
 * @author amuleekreehal
*/

import java.util.ArrayList;

public class Circuit {

    private ArrayList<Resistor> resistors;
    private ArrayList<VoltageSource> voltageSources;
    private ArrayList<Object> elements; 

    public Circuit() {
        resistors = new ArrayList<>();
        voltageSources = new ArrayList<>();
        elements = new ArrayList<>();
    }

    public void addResistor(Resistor r) {
        resistors.add(r);
        elements.add(r); 
    }

    public void addVoltageSource(VoltageSource v) {
        voltageSources.add(v);
        elements.add(v);    
    }

  
    public String toSpice() {
        String output = "";

        for (Object element : elements) {
            output = output + element.toString() + "\n";
        }

        return output;
    }
}
