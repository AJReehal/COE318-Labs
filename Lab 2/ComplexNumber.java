package coe318.lab2;  

/**
 * 
 * ComplexNumber models a complex number expressed in rectangular form (real and
 * imaginary parts). It is an <em>immutable</em> object.
 *
 * @author AJ Reehal
 * 
 * This class represents a complex number.
 * A complex number has two parts: a real part and an imaginary part.
 * Example: 3 + 4i has a real part 3 and an imaginary part 4.
 * 
 * This class is immutable, meaning once a complex number is created, 
 * it cannot be changed. All operations create and return new ComplexNumber objects.
 */

public class ComplexNumber {

    // These two variables store the parts of the complex number.
    
    // "real" holds the real component (the number without i).
    private double real;

    // "imaginary" holds the imaginary component (the number multiplied by i).
    private double imaginary;

    /**
     * This is the constructor. It is used when we create a new ComplexNumber.
     * The constructor takes two inputs:
     *   re: the real part of the number
     *   im: the imaginary part of the number
     * It stores those values into the instance variables "real" and "imaginary".
     */
    
    public ComplexNumber(double re, double im) {
        real = re;
        imaginary = im;
    }

    /**
     * This method gives back (returns) the real part of the complex number.
     * For example, if the number is 3 + 4i, this method will return 3.
     */
    
    public double getReal() {
        return real;
    }

    /**
     * This method gives back (returns) the imaginary part of the complex number.
     * For example, if the number is 3 + 4i, this method will return 4.
     */
    public double getImaginary() {
        return imaginary;
    }

    /**
     * This method creates and returns a new ComplexNumber that is the negative of this one.
     * Example: If the number is 3 + 4i, the result will be -3 - 4i.
     * The original number is not changed.
     */
    public ComplexNumber negate() {
        return new ComplexNumber(-real, -imaginary); // comma used to sep (re , im)
        // "new" tells Java to actually create a new ComplexNumber object in memory,
    // using the constructor and the values we give it. Without "new", there would be no object — just the blueprint.
    }

    /**
     * This method adds another complex number (other) to this one.
     * It follows the rule: (a + bi) + (c + di) = (a+c) + (b+d)i
     * Example: (3 + 4i) + (1 + 2i) = 4 + 6i.
     * A new ComplexNumber is returned with the result.
     */
    public ComplexNumber add(ComplexNumber other) {
        return new ComplexNumber(real + other.real, imaginary + other.imaginary); // comma used to sep (re , im)
        // "new" tells Java to actually create a new ComplexNumber object in memory,
    // using the constructor and the values we give it. Without "new", there would be no object — just the blueprint.
    }

    /**
     * This method subtracts another complex number (other) from this one.
     * It follows the rule: (a + bi) - (c + di) = (a-c) + (b-d)i
     * Example: (3 + 4i) - (1 + 2i) = 2 + 2i.
     * A new ComplexNumber is returned with the result.
     */
    public ComplexNumber subtract(ComplexNumber other) {
        return new ComplexNumber(real - other.real, imaginary - other.imaginary); // comma used to sep (re , im)
        // "new" tells Java to actually create a new ComplexNumber object in memory,
    // using the constructor and the values we give it. Without "new", there would be no object — just the blueprint.
    }

    /**
     * This method multiplies this complex number by another one (other).
     * The formula is: (a + bi)(c + di) = (ac - bd) + (ad + bc)i
     * Example: (3 + 4i)(1 + 2i) = (3*1 - 4*2) + (3*2 + 4*1)i = -5 + 10i.
     * The result is returned as a new ComplexNumber.
     */
    public ComplexNumber multiply(ComplexNumber other) {
        return new ComplexNumber(
            real * other.real - imaginary * other.imaginary,
            imaginary * other.real + real * other.imaginary
        ); 
    }

    /**
     * This method finds the reciprocal of this complex number (1 / this).
     * The formula is: 1 / (a + bi) = (a / (a^2+b^2)) - (b / (a^2+b^2))i
     * Example: For (3 + 4i), the reciprocal is (3/25) - (4/25)i.
     * A new ComplexNumber is returned with the result.a
     */
    public ComplexNumber reciprocal() {
        double denominator = real * real + imaginary * imaginary;
        return new ComplexNumber(real / denominator, -imaginary / denominator); // comma used to sep (re , im)
        // "new" tells Java to actually create a new ComplexNumber object in memory,
    // using the constructor and the values we give it. Without "new", there would be no object — just the blueprint.
    }

    /**
     * This method divides this complex number by another one (other).
     * The formula is: (a+bi) / (c+di) = [(ac+bd) / (c^2+d^2)] + [(bc-ad) / (c^2+d^2)]i
     * Example: (3 + 4i) / (1 + 2i) = (11/5) + (2/5)i.
     * The result is returned as a new ComplexNumber.
     */
    public ComplexNumber divide(ComplexNumber other) {
        double denominator = other.real * other.real + other.imaginary * other.imaginary; // Calculates the denominator of the division formula: c^2 + d^2

        double reNum = real * other.real + imaginary * other.imaginary; // Calculates the numerator for the real part: a*c + b*d

        double imNum = imaginary * other.real - real * other.imaginary; // Calculates the numerator for the imaginary part: b*c - a*d

        return new ComplexNumber(reNum / denominator, imNum / denominator); // comma used to sep (re , im)
        // "new" tells Java to actually create a new ComplexNumber object in memory,
    // using the constructor and the values we give it. Without "new", there would be no object — just the blueprint.
    }

    /**
     * THE METHOD toString was already created
     * 
     * This method converts the complex number into a readable string format.
     * If the imaginary part is 0, it only shows the real part.
     * If the imaginary part is positive, it shows "real + iimaginary".
     * If the imaginary part is negative, it shows "real - i|imaginary|".
     * 
     * Examples:
     *   new ComplexNumber(0,0) → "0.0"
     *   new ComplexNumber(1,1) → "1.0 + i1.0"
     *   new ComplexNumber(1,-1) → "1.0 - i1.0"
     */
    @Override
    public String toString() {
//DO NOT MODIFY THIS CODE!
        String str = "" + this.getReal();
        if (this.getImaginary() == 0.0) {
            return str;
        }
        if (this.getImaginary() > 0) {
            return str + " + i" + this.getImaginary();
        } else {
            return str + " - i" + -this.getImaginary();
        }
    }

}
