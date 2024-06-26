/**
 * Section: CSC331-001
 * Group: 7
 * Team: Ryan Eisenbeis, Jake Rouse, Oliver Rice, Sidney Tsui, Jackson Snyder
 * Project Title: Accounting/Budgeting App
 * Date: April 21, 2024.
 * Purpose: Accounting App Driver
 */

package com.example.csc331accountingapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AccountingApp extends Application{
    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("Accounting_App.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Company Budgeting App");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
