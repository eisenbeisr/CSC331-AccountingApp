package com.example.csc331accountingapp;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Slider;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import javafx.scene.input.InputMethodEvent;

public class AccountingAppController {

    @FXML
    private TextField HRDeptBudgetDisplay;

    @FXML
    private TextField ITDeptBudgetDisplay;

    @FXML
    private Button accountSettingsButton;

    @FXML
    private Button addBudgetButton;

    @FXML
    private Tab addBudgetTab;

    @FXML
    private Button changeBudgetButton;

    @FXML
    private Tab changeBudgetTab;

    @FXML
    private TextField companyBudgetDisplay;

    @FXML
    private Label companyNameHomeTab;

    @FXML
    private TextField companyNameTextField;

    @FXML
    private TextField companyTotalBudget;

    @FXML
    private Button currentBudgetButton;

    @FXML
    private Tab currentBudgetTab;

    @FXML
    private Button depositButton;

    @FXML
    private TextField deptBudgetPercentDisplay;

    @FXML
    private Slider deptBudgetPercentSlider;

    @FXML
    private Tab homeTab;

    @FXML
    private Button loginButton;

    @FXML
    private Tab loginTab;

    @FXML
    private TextField marketingDeptBudgetDisplay;

    @FXML
    private PasswordField passwordDisplay;

    @FXML
    private PasswordField passwordLoginField;

    @FXML
    private PieChart pieChartDisplay;

    @FXML
    private TextField productionDeptBudgetDisplay;

    @FXML
    private TextField salesDeptBudgetDisplay;

    @FXML
    private MenuItem selectCompanyDept;

    @FXML
    private TextField selectDeptDisplayField;

    @FXML
    private MenuButton selectDeptMenuButton;

    @FXML
    private MenuItem selectHRDept;

    @FXML
    private MenuItem selectITDept;

    @FXML
    private MenuItem selectMarketingDept;

    @FXML
    private MenuItem selectProductionDept;

    @FXML
    private MenuItem selectSalesDept;

    @FXML
    private Button settingsButton;

    @FXML
    private Button submitCompanyBudget;

    @FXML
    private TextField transactionAmountField;

    @FXML
    private Tab userAccountTab;

    @FXML
    private TextField usernameDisplay;

    @FXML
    private Label usernameHomeTab;

    @FXML
    private TextField usernameLoginField;

    @FXML
    private Button withdrawButton;


    // Added some methods for basic functionality (login portal & clicking buttons to change tabs)

    /**
     * This method is used to initialize the pie chart and split it up into 5 sections (1 for each department).
     * This is just a template, we can edit this to get updated according to user input in the GUI.
     */
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

        pieChartDisplay.setData(pieChartData);
    }

    /**
     * This method is used to get the text from the username and password fields in the Login tab,
     * and set the username and password fields in the User Account tab when the login button is clicked.
     */
    @FXML
    public void loginButtonClicked() {

        // Get username and password from login fields in Login tab
        String username = usernameLoginField.getText();
        String password = passwordLoginField.getText();

        // Set username and password to display fields in User Account tab
        usernameDisplay.setText(username);
        passwordDisplay.setText(password);

        // Switch to User Account tab when login button is clicked
        userAccountTab.getTabPane().getSelectionModel().select(userAccountTab);

    }

    @FXML
    public void addBudgetButtonClicked() {

        // Switch to Add Budget tab when add budget button is clicked
        addBudgetTab.getTabPane().getSelectionModel().select(addBudgetTab);

    }

    @FXML
    public void changeBudgetButtonClicked() {

        // Switch to Change Budget tab when change budget button is clicked
        changeBudgetTab.getTabPane().getSelectionModel().select(changeBudgetTab);

    }

    @FXML
    public void currentBudgetButtonClicked() {

        // Switch to Current Budget tab when current budget button is clicked
        currentBudgetTab.getTabPane().getSelectionModel().select(currentBudgetTab);

    }

    @FXML
    public void accountSettingsButtonClicked() {

        // Switch to User Account tab when account settings button is clicked
        userAccountTab.getTabPane().getSelectionModel().select(userAccountTab);

    }

}
