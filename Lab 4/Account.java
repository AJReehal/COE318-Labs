/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;
    
/**
 *
 * @author amuleekreehal
 */

public class Account {

    // Instance variables
    private String name;    // Name of the account owner
    private int number;     // Unique account number
    private double balance; // Current balance of the account
         
    /**
     * Constructor to create a new Account
     * @param name Name of the account owner
     * @param number Unique account number
     * @param balance Initial balance
     */
    
    public Account(String name, int number, double balance){
        this.name = name;      // Set account owner's name
        this.number = number;  // Set account number
        this.balance = balance; // Set initial balance
    }
    
    // Getter method for the account owner's name
    public String getName(){
        return name;
    }
    
    // Getter method for the account number
    public int getNumber (){
        return number;
    }
    
    // Getter method for the current balance
    public double getBalance (){
        return balance;
    }
    
    /**
     * Deposit method to add money to the account
     * @param amount Amount to deposit
     * @return true if deposit is successful, false if amount <= 0
     */
    
    public boolean deposit(double amount){
        if (amount <= 0) {
            return false; // Cannot deposit negative or zero amount
        } else {
            balance += amount; // Add amount to balance
            return true;       // Deposit successful
        }
    }
    
    /**
     * Withdraw method to remove money from the account
     * @param amount Amount to withdraw
     * @return true if withdrawal is successful, false if amount <= 0 or greater than balance
     */
    
    public boolean withdraw(double amount){
        if (amount <= 0 || amount > balance){
            return false; // Cannot withdraw negative amount or more than available balance
        } else{
            balance -= amount; // Subtract amount from balance
            return true;       // Withdrawal successful
        }
    }
    
    /**
     * toString method returns a string representation of the account
     * Format: (Name, Number, $Balance)
     * Example: (Alice, 123, $100.00)
     */
    @Override
    public String toString() {
        return "(" + getName() + ", " + getNumber() + ", " + String.format("$%.2f", getBalance()) + ")";
    }
}
