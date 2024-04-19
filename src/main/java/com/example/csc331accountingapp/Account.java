//sidney tsui
//added: withdraw, deposit, and view balance



package com.example.csc331accountingapp;
//import java.util.Scanner;

/**
 * user account
 */
public class Account {
  /*public static void main(String[] args){
  
  }*/
  //assign private instance variables
  private String username;
  private String password;
  private int userID;
/**
 * 
 * @param username
 * @param password
 * @param userID
 * @throws Exception IllegalArgumentException if username or password is empty or null
 */
  public Account(String username, String password, int userID) throws IllegalArgumentException {
    if ((username == null || username.isEmpty()) || (password == null || password.isEmpty())) {
      throw new IllegalArgumentException("invalid input");
    }
    this.username = username;
    this.password = password;
    this.userID = userID;
  }

  //accessors
  public String getUsername() {
    return username;
  }

  public String getPassword() {
    return password;
  }

  public int getUserID() {
    return userID;
  }

  //mutators
  public void setUsername(String username) {
    this.username = username;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public void setUserID(int userID) {
    this.userID = userID;
  }

  public static class Department{
    private String deptName;
    private double budget;
    private double balance;

    public Department(String deptName, double budget){
      this.deptName = deptName;
      this.budget = budget;
    }
    public String getDeptName() {
      return deptName;
    }
    public double getBudget(){
      return budget;
    }
    public double getBalance(){
      return balance;
    }

    //question: are we using preset budgets for each dept, or having the user input it 
   
    /*public void setDeptName(){
      this.deptName = deptName;
    }
    public void setBudget(){
      this.budget = budget;
    }*/

    public void viewBalance(double balance){
      System.out.println("Current balance of the " + deptName + " department: $" + balance);
    }
    /**
     * allows user to deposit some amount of money then have their balance updated
     * @param deposit_value
     */
    public void deposit(double deposit_value){
      if(deposit_value > 0){
        balance += deposit_value;
        System.out.println("Deposit amount: $" + deposit_value);
        System.out.println("Deposit Location: " + deptName);
        System.out.println("Current balance: " + balance);
      }
      else{
        //prints if value entered is null
        System.out.println("Ivalid entry");
      }

    }
    /**
     * allows user to withdraw some amount of money then have their balance updated
     * @param withdraw_value
     */
    public void withdraw(double withdraw_value){
      if(withdraw_value <= balance){
        balance -= withdraw_value;
        System.out.println("Withdraw amount: $" + withdraw_value);
        System.out.println("Withdraw Location: " + deptName);
        System.out.println("Current balance: " + balance);
      }
      else if(withdraw_value > 0){
        //prints if value entered is null
        System.out.println("Invalid entry");
      }
      else{
        //prints if value entered is larger than balance
        System.out.println("Insufficient funds");
      }

    }
 
  }

}
