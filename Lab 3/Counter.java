package coe318.Lab3;   // This declares the package name where this class belongs

/**
 * The Counter class represents a digital counter
 * that can be connected to another counter on its left
 * to simulate multi-digit counting (like an odometer).
 */
public class Counter {

    // Instance variables

    int modulus;   // The base or limit of the counter (e.g., 10 for decimal, 3 for mod 3)
    int digit;     // The current value (digit) stored in this counter
    Counter left;  // Reference to the counter on the left (null if this is the leftmost one)


    // Constructor

    /**
     * Creates a new Counter with the given modulus and a link
     * to a Counter on its left.
     *
     * @param modulus The maximum value before rolling over to 0
     * @param left The counter to the left (null if none)
     */
    public Counter(int modulus, Counter left) {
        this.modulus = modulus;  // Set the modulus for this counter
        this.left = left;        // Connect this counter to the left counter
        this.digit = 0;          // Initialize the counter’s digit to zero
    }


    // Accessor (getter) methods

    /**
     * Returns the modulus (base) of this counter.
     *
     * @return The modulus value
     */
    public int getModulus() {
        return this.modulus;
    }

    /**
     * Returns the Counter to the left of this one.
     * If there is none, returns null.
     *
     * @return The left counter reference
     */
    public Counter getLeft() {
        return this.left;
    }

    /**
     * Returns the current digit value of this counter.
     *
     * @return The current digit
     */
    public int getDigit() {
        return digit;
    }


    // Mutator (setter) method

    /**
     * Sets the digit of this counter to a specific value.
     *
     * @param digit The value to set this counter to
     */
    public void setDigit(int digit) {
        this.digit = digit;  // Assign the new value directly
    }


    // Counter behavior

    /**
     * Increments this counter by 1.
     * If the digit reaches the modulus value, it rolls over to 0.
     * If there is a counter to the left, that counter is also incremented.
     */
    public void increment() {
        digit++;  // Increase this counter's value by 1

        // Check if the counter exceeds its maximum (rollover condition)
        if (digit >= modulus) {
            digit = 0;  // Reset this counter to 0

            // If there is a counter to the left, increment it as well
            if (this.left != null) {
                this.left.increment();  // Recursive call to handle carry-over
            }
        }
    }


    // Combined count logic

    /**
     * Returns the total count represented by this counter
     * combined with all counters to its left.
     * 
     * For example, if this counter has modulus 10 and digit 3,
     * and the left counter has count 2, the total is 2*10 + 3 = 23.
     *
     * @return The total combined count
     */
    public int getCount() {
        // If there is a counter to the left, include its count in the total
        if (this.left != null) {
            return digit + modulus * left.getCount();
        } else {
            // If no left counter, the total is just this counter’s digit
            return digit;
        }
    }


    // String representation

    /**
     * Returns the string form of the total count.
     * (This method should not be modified according to lab instructions.)
     *
     * @return String showing the total count
     */
    @Override
    public String toString() {
        return "" + getCount();
    }
}
