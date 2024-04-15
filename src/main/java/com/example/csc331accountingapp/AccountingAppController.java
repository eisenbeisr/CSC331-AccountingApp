//JakeDaShark
// Test (Ryan)
package com.example.csc331accountingapp;

import javafx.beans.binding.Bindings;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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


import java.math.BigDecimal;
import java.text.NumberFormat;

import java.util.Scanner;
import java.util.Formatter;
import java.nio.file.Paths;
import java.io.IOException;

public class AccountingAppController {
    private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
    private static final NumberFormat percent = NumberFormat.getPercentInstance();

    private BigDecimal deptPercentage = new BigDecimal(0.25);

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
    private TextField deptDistributionDisplay;

    @FXML
    private Slider deptBudgetPercentSlider;

    @FXML
    private Label distributionPercentageLabel;

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

    @FXML
    private TextField IncorrectPasswordFileScanner;

    @FXML
    private TextField IncorrectPasswordInput;


    // Added some methods for basic functionality (login portal & clicking buttons to change tabs)

    /**
     * This method is used to initialize the pie chart and split it up into 5 sections (1 for each department).
     * This is just a template, we can edit this to get updated according to user FileScanner in the GUI.
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

        deptBudgetPercentSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> ov, Number oldValue, Number newValue) {
                deptPercentage = BigDecimal.valueOf(newValue.intValue() / 100.0);
                distributionPercentageLabel.setText(percent.format(deptPercentage));
            }

        }
        );
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

        try(Scanner FileScanner = new Scanner(Paths.get("Users.txt"));){

            boolean Found = false;

            while (FileScanner.hasNext() && !Found){

                String userName = FileScanner.next();
                String Password = FileScanner.next();
                String fileName = FileScanner.next();

                System.out.println("Iterate");

                if (userName.equals(username) && Password.equals(password)){



                    Found = true;

                    try(Scanner DataScanner = new Scanner(Paths.get(fileName));){

                        
                        companyBudgetDisplay.setText(DataScanner.next());
                        salesDeptBudgetDisplay.setText(DataScanner.next());
                        marketingDeptBudgetDisplay.setText(DataScanner.next());
                        productionDeptBudgetDisplay.setText(DataScanner.next());
                        ITDeptBudgetDisplay.setText(DataScanner.next());
                        HRDeptBudgetDisplay.setText(DataScanner.next());

                    }

                    catch(IOException e){
                        e.printStackTrace();
                    }

                    System.out.println("Pass");

            System.out.println("Past");

            if (!Found){

                IncorrectPasswordInput.setText("Incorrect UserName or Password");
            }
                }
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }


        

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

    @FXML
    public void AddCompanyBudgetSubmitClicked(ActionEvent event) {

        // Get text from total budget field & multiply by deptPercentage
        BigDecimal total_budget = new BigDecimal(companyTotalBudget.getText());
        BigDecimal dept_distribution = total_budget.multiply(deptPercentage);

        // Set company total budget text field to display as a currency
        companyTotalBudget.setText(currency.format(total_budget));

        // Display how much $ is to be distributed into each department
        deptDistributionDisplay.setText(currency.format(dept_distribution));

    }

}
