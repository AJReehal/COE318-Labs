/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package coe318.lab4;

/**
 *
 * @author amuleekreehal
 */
public class MainAccount {
    public static void main(String[] args) {
        Account alice = new Account("Alice", 123, 100.00);
        Account bob = new Account("Bob", 789, 0);
        System.out.println(bob);
        System.out.println(alice);
        alice.withdraw(15);
        System.out.println(alice);
        alice.withdraw(200);
        System.out.println(alice);
        alice.withdraw(-1);
        System.out.println(alice);
        alice.deposit(150);
        alice.withdraw(200);
        System.out.println(alice);
        bob.deposit(300);
        System.out.println(bob);
        bob.withdraw(100);
        System.out.println(bob);
    }

}


