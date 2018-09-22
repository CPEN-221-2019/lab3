package main.java.suggestionLab;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Class to represent a Bank Account. A very impractical implementation!
 */
public class BankAccount {

    // could be public but what are the implications? Why is it static?
    static private Set<Integer> accountIDs = new HashSet<>();

    // arraylist to hold the transactions as pairs of integers -> Pair(int amount, int account number)
    private List<Pair<Integer, Integer>> transactionHistory = new ArrayList<Pair<Integer, Integer>>();

    // variable to hold account number
    private int accountNumber = -1;

    // In our implementation we want balance never to be negative
    private int balance = 0;

    /**
     * The number of all valid accounts created. Why is it static?
     * @return int representing the number of accounts present
     */
    public static int numberOfAccounts(){
        return accountIDs.size();
    }

    /**
     * Get the string of all accountIDs. Why is this static? What happens if you change the
     * set and this method to be object variables and methods (non-static)?
     *
     * @return String representing all the account IDs created
     */
    public static String getAllAccountIDs(){
        return accountIDs.toString();
    }

    /**
     * Create a new account with a given account ID and balance 0. If ID is already associated with an account
     * or ID negative, throw an exception.
     *
     * @param  ID positive integer, ID > 0
     * @throws IllegalArgumentException, thrown if ID invalid
     */
    BankAccount(int ID) throws IllegalArgumentException{
        if(ID <= 0)
            throw new IllegalArgumentException("Invalid ID");
        else if(accountIDs.contains(ID))
            throw new IllegalArgumentException("Account already exists");
        else
            accountIDs.add(ID);
    }


    /**
     * Create a new account with a given account ID, and a given account balance.
     * If ID is already associated with an account or ID negative or balance negative throw an exception.
     *
     * Note that this an extra constructor. Where have you seen something like this?
     *
     * @param ID positive integer, ID > 0
     * @param balance positive integer, balance >= 0
     * @throws IllegalArgumentException, thrown if ID or balance invalid
     */
    BankAccount(int ID, int balance) throws IllegalArgumentException{
        if(ID <= 0)
            throw new IllegalArgumentException("Invalid ID");
        else if(balance < 0)
            throw new IllegalArgumentException("Invalid initial Balance");
        else if(accountIDs.contains(ID))
            throw new IllegalArgumentException("Account already exists");
        else {
            accountIDs.add(ID);
            this.balance = balance; // why do I have this.balance and not balance?
        }
    }

    /**
     * Return the balance of this BankAccount
     *
     * @return int representing the balance
     */
    public int getBalance(){
        return balance;
    }

    /**
     * Return the account ID of this BankAccount
     *
     * @return int representing the accountNumber
     */
    public int getAccountNumber(){
        return accountNumber;
    }

    /**
     * Withdraw an amount from the account
     *
     * @param amount cannot be larger than balance or negative
     * @return true if withdrawal was successful, false otherwise
     */
    public boolean withdraw(int amount){
        if(amount > balance)
            return false;

        balance -= amount;
        transactionHistory.add(new Pair<>(-1 * amount, this.accountNumber));

        return true;
    }

    /**
     * Deposit an amount into the account
     *
     * @param amount cannot be negative
     * @return true if deposit was successful, false otherwise
     */
    public boolean deposit(int amount){
        if(amount < 0)
            return false;

        balance += amount;
        transactionHistory.add(new Pair<>(amount, this.accountNumber));

        return true;
    }

    /**
     * other methods could be: "transfer to other accounts" We could ask students to write it
     * they need to use equals as we assert that an account transferring to itself is a form of
     * deposit or withdrawal. They could implement equals and hashCode too
     */
    public boolean transfer(BankAccount destination, int amount){
        //TODO implement this method
        return false;
    }

    @Override
    public boolean equals(Object other){
        //TODO implement this method
        return false;
    }

    @Override
    public int hashCode(){
        //TODO implement this method
        return 0;
    }
}
