/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;
    
/**
 *
 * @author amuleekreehal
 */

/**
 * Bank class represents a bank that can hold multiple accounts.
 * It keeps track of the bank name, the list of accounts, and the number of accounts.
 */
public class Bank {

    // Instance variables
    private String name;        // Name of the bank
    private Account[] accounts; // Array to store accounts in the bank
    private int numAccounts;    // Number of accounts currently in the bank

    /**
     * Constructor to create a Bank object
     * @param name Name of the bank
     * @param maxAccounts Maximum number of accounts the bank can hold
     */
    public Bank(String name, int maxAccounts) {
        this.name = name;                 // Set the bank name
        accounts = new Account[maxAccounts]; // Initialize the accounts array with max capacity
        numAccounts = 0;                  // Start with zero accounts
    }

    /**
     * Method to add a new account to the bank
     * @param newAccount The account to add
     * @return true if added successfully, false if account number already exists
     */
    public boolean add(Account newAccount) {
        // Loop through existing accounts to check for duplicate account numbers
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getNumber() == newAccount.getNumber()) {
                return false; // Duplicate account number found, cannot add
            }
        }
        // No duplicate found, add the account to the array
        accounts[numAccounts] = newAccount;
        numAccounts++; // Increment the number of accounts
        return true;   // Account added successfully
    }

    /**
     * Method to check if a bank has an account with a specific number
     * @param number Account number to search for
     * @return true if account exists, false otherwise
     */
    public boolean hasAccountNumber(int number) {
        // Loop through all existing accounts
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getNumber() == number) {
                return true; // Found a matching account number
            }
        }
        return false; // No matching account number found
    }

    /**
     * toString method returns a string representation of the bank
     * Shows bank name, number of accounts open, and details of each account
     */
    @Override
    public String toString() {
        String s = name + ": " + numAccounts + " of " + accounts.length + " accounts open";
        // Loop through accounts array and print each account
        for (Account account : accounts) {
            if (account == null) break; // Stop at empty slots in the array
            s += "\n  " + account; // Indent each account for readability
        }
        return s;
    }
}
