/**
 * Section: CSC331-001
 * Group: 7
 * Team: Ryan Eisenbeis, Jake Rouse, Oliver Rice, Sidney Tsui, Jackson Snyder
 * Project Title: Accounting/Budgeting App
 * Date: April 21, 2024.
 * Purpose: User Account class
 */

package com.example.csc331accountingapp;

public class Account {

  //assign private instance variables
  private String username;
  private String password;
  private int userID;

  /**
   * @param username: username entered at Login page
   * @param password: password entered at Login page
   * @param userID: userID to identify the user that is logging in
   * @throws IllegalArgumentException IllegalArgumentException if username or password is empty or null
   */
  public Account(String username, String password, int userID) throws IllegalArgumentException {

    if ((username == null || username.isEmpty()) || (password == null || password.isEmpty())) {
      throw new IllegalArgumentException("invalid input");
    }

    this.username = username;
    this.password = password;
    this.userID = userID;

  }

  // Accessors
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public int getUserID() {
    return userID;
  }

  // Mutators
  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

public class Department {
  private String deptName;
  private double budget;
  private double balance;

    public Department(String deptName, double budget) {
      this.deptName = deptName;
      this.budget = budget;
    }

    // Accessors
    public String getDeptName() {
      return deptName;
    }

    public double getBudget() {
      return budget;
    }

    public double getBalance() {
      return balance;
    }

    // Mutators
    public void setDeptName(){
      this.deptName = deptName;
    }
    public void setBudget(){
      this.budget = budget;
    }

  /**
   * This method is used to view the current balance of a department
   * @param balance: the department's balance
   */
  public void viewBalance(double balance) {
      System.out.println("Current balance of the " + deptName + " department: $" + balance);
    }

    /**
     * This method allows user to deposit some amount of money then have their balance updated
     * @param deposit_value: The amount being deposited into a department
     */
    public void deposit(double deposit_value) {
      if (deposit_value > 0) {
        balance += deposit_value;
        System.out.println("Deposit amount: $" + deposit_value);
        System.out.println("Deposit Location: " + deptName);
        System.out.println("Current balance: " + balance);
      } else {
        //prints if value entered is null
        System.out.println("Ivalid entry");
      }

    }

    /**
     * This method allows user to withdraw some amount of money then have their balance updated
     * @param withdraw_value: The amount being withdrawn from a department
     */
    public void withdraw(double withdraw_value) {
      if (withdraw_value <= balance) {
        balance -= withdraw_value;
        System.out.println("Withdraw amount: $" + withdraw_value);
        System.out.println("Withdraw Location: " + deptName);
        System.out.println("Current balance: " + balance);
      } else if (withdraw_value > 0) {
        //prints if value entered is null
        System.out.println("Invalid entry");
      } else {
        //prints if value entered is larger than balance
        System.out.println("Insufficient funds");
      }

    }

  }

}
