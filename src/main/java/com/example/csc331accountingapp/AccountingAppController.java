package com.example.csc331accountingapp;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountingAppController {

    @FXML
    private TextField HRDepartmentTextField;

    @FXML
    private MenuItem HRMenuItem;

    @FXML
    private TextField ITDepartmentTextField;

    @FXML
    private MenuItem ITMenuItem;

    @FXML
    private Tab addBudgetTab;

    @FXML
    private TextField companyBudgetTextField;

    @FXML
    private TextField companyNameField;

    @FXML
    private TextField companyTotalBudget;

    @FXML
    private Tab currentBudgetTab;

    @FXML
    private TextField departmentTotalBudget;

    @FXML
    private Button depositButton;

    @FXML
    private MenuButton deptTotalMenuButton;

    @FXML
    private Tab homeTab;

    @FXML
    private Button loginButton;

    @FXML
    private Tab loginTab;

    @FXML
    private TextField marketingDepartmentTextField;

    @FXML
    private MenuItem marketingMenuItem;

    @FXML
    private PasswordField passwordDisplay;

    @FXML
    private PasswordField passwordLoginField;

    @FXML
    private PieChart pieChartDisplay1;

    @FXML
    private PieChart pieChartDisplay2;

    @FXML
    private TextField productionDepartmentTextField;

    @FXML
    private MenuItem productionMenuItem;

    @FXML
    private Tab reportsTab;

    @FXML
    private TextField salesDepartmentTextField;

    @FXML
    private MenuItem salesMenuItem;

    @FXML
    private Button settingsButton;

    @FXML
    private TextField totalBudgetField;

    @FXML
    private Tab userAccountTab;

    @FXML
    private TextField usernameDisplay;

    @FXML
    private TextField usernameLoginField;

    @FXML
    private Button withdrawButton;

    public void initialize() {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Sales", 20),
                        new PieChart.Data("Marketing", 20),
                        new PieChart.Data("Production", 20),
                        new PieChart.Data("IT", 20),
                        new PieChart.Data("HR", 20));

        pieChartData.forEach(data ->
                data.nameProperty().bind(
                        Bindings.concat(
                                data.getName(), " amount: ", data.pieValueProperty()
                        )
                )
        );

        pieChartDisplay1.setData(pieChartData);
        pieChartDisplay2.setData(pieChartData);
    }

    @FXML
    public void loginButtonClicked() {
        // Get username and password from login fields
        String username = usernameLoginField.getText();
        String password = passwordLoginField.getText();

        // Set username and password to display fields in user account tab
        usernameDisplay.setText(username);
        passwordDisplay.setText(password);

        // Switch to user account tab (optional)
        userAccountTab.getTabPane().getSelectionModel().select(userAccountTab);
    }

}
