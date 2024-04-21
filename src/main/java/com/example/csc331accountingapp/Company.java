/**
 * Section: CSC331-001
 * Group: 7
 * Team: Ryan Eisenbeis, Jake Rouse, Oliver Rice, Sidney Tsui, Jackson Snyder
 * Project Title: Accounting/Budgeting App
 * Date: April 21, 2024.
 * Purpose: Company class
 */

package com.example.csc331accountingapp;

public class Company extends Account {
    public double total_funds;
    public double it_funds_percentage;
    public double Marketing_funds_percentage;
    public double Sales_funds_percentage;
    public double Production_funds_percentage;
    public double HR_funds_percentage;
    public double it_funds;
    public double Marketing_funds;
    public double Sales_funds;
    public double Production_funds;
    public double HR_funds;
    public double Dept_percentage;
    public Department[] array = new Department[5];

    public Company(String username, String password, int userID, float total_funds, double Dept_percentage) {
        super(username, password, userID);
        this.total_funds = total_funds;
        this.Dept_percentage = Dept_percentage;
        this.Marketing_funds_percentage = Dept_percentage;
        this.Sales_funds_percentage = Dept_percentage;
        this.Production_funds_percentage = Dept_percentage;
        this.HR_funds_percentage = Dept_percentage;
        this.it_funds_percentage = Dept_percentage;
        this.Marketing_funds = this.Marketing_funds_percentage * total_funds;
        this.Sales_funds = this.Sales_funds_percentage * total_funds;
        this.Production_funds = this.Production_funds_percentage * total_funds;
        this.HR_funds = this.HR_funds_percentage * total_funds;
        this.it_funds = this.it_funds_percentage * total_funds;
        this.array[0] = new Department("Marketing", Marketing_funds);
        this.array[1] = new Department("Sales", Sales_funds);
        this.array[2] = new Department("Production", Production_funds);
        this.array[3] = new Department("HR", HR_funds);
        this.array[4] = new Department("IT", it_funds);
    }

    /**
     * This method is used to reset each department balance
     */
    public void reset_Dep_funds() {
        this.Marketing_funds_percentage = 20;
        this.Sales_funds_percentage = 20;
        this.Production_funds_percentage = 20;
        this.HR_funds_percentage = 20;
        this.it_funds_percentage = 20;
        this.HR_funds = (this.HR_funds_percentage/100) * this.total_funds;
        this.Marketing_funds = (this.Marketing_funds_percentage/100) * this.total_funds;
        this.Sales_funds = (this.Sales_funds_percentage/100) * this.total_funds;
        this.Production_funds = (this.Production_funds_percentage/100) * total_funds;
        this.it_funds = (this.it_funds_percentage/100) * total_funds;
        double marketing_funds = array[0].getBalance();
        double sales_funds = array[1].getBalance();
        double production_funds = array[2].getBalance();
        double HR_funds = array[3].getBalance();
        double IT_funds = array[4].getBalance();
    }

    /**
     * This method is used to deposit funds into a chosen department
     * @param name: The name of the department
     * @param amount: The amount being deposited
     * @return Returns the new balance of department
     */
    public double deposit(String name, double amount) {
        int x = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getDeptName().equals(name)) {
                double new_amount = this.array[i].getBalance() + amount;
                x = i;
            }
        }
        return this.array[x].getBalance();
    }

    /**
     * This method is used to withdraw funds from a chosen department
     * @param name: The name of the department
     * @param amount: The amount being withdrawn
     * @return Returns the new balance of department
     */
    public double withdraw(String name, double amount) {
        int x = 0;
        for (int i = 0; i < this.array.length; i++) {
            if (this.array[i].getDeptName().equals(name)) {
                x = i;
                double new_amount = this.array[i].getBalance() - amount;
            }
        }
        return this.array[x].getBalance();
    }

    /**
     * This method is used to update the pie chart data
     */
    public void adjustPieChart(){
        this.Marketing_funds_percentage = 100/(total_funds/this.Marketing_funds);
        this.Sales_funds_percentage = 100/(total_funds/this.Sales_funds);
        this.Production_funds_percentage = 100/(total_funds/this.Production_funds);
        this.HR_funds_percentage = 100/(total_funds/this.HR_funds);
        this.it_funds_percentage = 100/(total_funds/this.it_funds);
    }

    /**
     * This method is used to change the total funds of the company balance
     */
    public void adjustTotal(){
        this.total_funds=(0.0);
        for (int i = 0; i < 5; i++){
            this.total_funds = this.array[i].getBalance() + this.total_funds;
        }
    }
}
