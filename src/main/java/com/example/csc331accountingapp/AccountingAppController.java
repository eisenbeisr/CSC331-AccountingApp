/**
* Section: CSC331-001
* Group: 7
* Team: Ryan Eisenbeis, Jake Rouse, Oliver Rice, Sidney Tsui, Jackson Snyder
* Project Title: Accounting/Budgeting App
* Date: April 21, 2024.
*/

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
import java.nio.file.Paths;
import java.io.IOException;

public class AccountingAppController {

// Convert number to currency
private static final NumberFormat currency = NumberFormat.getCurrencyInstance();
// Convert number to a percentage
private static final NumberFormat percent = NumberFormat.getPercentInstance();

// Initialize department percentage to 25%
private BigDecimal deptPercentage = new BigDecimal(0.25);

// Initialize JavaFX fxids
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
private TextField IncorrectPasswordInput;

/**
 * This method is used to initialize the Pie Chart and add a listener for the dept distribution percentage.
 */
@FXML
public void initialize() {

    // Add new Pie Chart data
    ObservableList<PieChart.Data> pieChartData =
            FXCollections.observableArrayList(
                    new PieChart.Data("Company", 100));

    pieChartData.forEach(data ->
            data.nameProperty().bind(Bindings.concat(data.getName(), " ", data.pieValueProperty(), "%")));

    // Set Pie Chart data
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

        // Read lines in Users.txt file while the next line has data and is not found
        while (FileScanner.hasNext() && !Found) {

            // Set username, password, and filename variables to associated data in User.txt file
            String userName = FileScanner.next();
            String Password = FileScanner.next();
            String fileName = FileScanner.next();

            // If valid username and password is found, proceed with this block of code
            if (userName.equals(username) && Password.equals(password)) {

                // Update boolean to True to break out of while loop
                Found = true;

                // Find absolute path of user's file in Users.txt and read data in that user's file
                try (Scanner DataScanner = new Scanner(Paths.get(fileName))) {

                    // Set Text Fields in Current Budget Tab, convert each string to a double, and format as a currency for each department
                    companyBudgetDisplay.setText(DataScanner.next());
                    double company = Double.valueOf(String.valueOf(companyBudgetDisplay.getText()));
                    companyBudgetDisplay.setText(currency.format(company));

                    salesDeptBudgetDisplay.setText(DataScanner.next());
                    double sales = Double.valueOf(String.valueOf(salesDeptBudgetDisplay.getText()));
                    salesDeptBudgetDisplay.setText(currency.format(sales));

                    marketingDeptBudgetDisplay.setText(DataScanner.next());
                    double marketing = Double.valueOf(String.valueOf(marketingDeptBudgetDisplay.getText()));
                    marketingDeptBudgetDisplay.setText(currency.format(marketing));

                    productionDeptBudgetDisplay.setText(DataScanner.next());
                    double production = Double.valueOf(String.valueOf(productionDeptBudgetDisplay.getText()));
                    productionDeptBudgetDisplay.setText(currency.format(production));

                    ITDeptBudgetDisplay.setText(DataScanner.next());
                    double IT = Double.valueOf(String.valueOf(ITDeptBudgetDisplay.getText()));
                    ITDeptBudgetDisplay.setText(currency.format(IT));

                    HRDeptBudgetDisplay.setText(DataScanner.next());
                    double HR = Double.valueOf(String.valueOf(HRDeptBudgetDisplay.getText()));
                    HRDeptBudgetDisplay.setText(currency.format(HR));

                    // Set Text Fields for Username and Password Display in Account Settings Tab
                    usernameDisplay.setText(username);
                    passwordDisplay.setText(password);
                    // Set text for username in Home Tab to username entered in the login portal
                    usernameHomeTab.setText(username);

                    // Switch to Home Tab when valid username and password is entered
                    homeTab.getTabPane().getSelectionModel().select(homeTab);

                    IncorrectPasswordInput.setText("");

                    // Update Pie Chart data
                    updatePieChartData();

                }

                    catch(IOException e){
                        e.printStackTrace();
                    }

            

            

            
                }
            }

            if (!Found){

                IncorrectPasswordInput.setText("Incorrect UserName or Password");
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

/**
 * This method switches to the Change Budget Tab when the Change Budget Button is clicked.
 */
@FXML
public void changeBudgetButtonClicked() {

    // Switch to Change Budget tab when change budget button is clicked
    changeBudgetTab.getTabPane().getSelectionModel().select(changeBudgetTab);

}

/**
 * This method switches to the Current Budget Tab when the Current Budget Button is clicked.
 */
@FXML
public void currentBudgetButtonClicked() {

    // Switch to Current Budget tab when current budget button is clicked
    currentBudgetTab.getTabPane().getSelectionModel().select(currentBudgetTab);

}

/**
 * This method switches to the User Account Tab when the Account Settings Button is clicked.
 */
@FXML
public void accountSettingsButtonClicked() {

    // Switch to User Account tab when account settings button is clicked
    userAccountTab.getTabPane().getSelectionModel().select(userAccountTab);

}

/**
 * This method gets the user input from the Total Budget Text Field and multiplies that by the Dept Budget Percentage
 * Slider to get the distribution amount for each individual department, then sets those values in currency format
 * and updates the Pie Chart data.
 */
@FXML
public void AddCompanyBudgetSubmitClicked() {

    // Get text from Company Name Text Field (unused)
    String company_name = companyNameTextField.getText();

    // Get text from Total Budget Text Field & multiply by Distribution Percentage Slider value
    BigDecimal total_budget = new BigDecimal(companyTotalBudget.getText());
    double distribution_percentage = deptBudgetPercentSlider.getValue() / 100;
    BigDecimal distribution_amount = total_budget.multiply(BigDecimal.valueOf(distribution_percentage));

    // Set Company Total Budget Text Field to display in currency format
    companyTotalBudget.setText(currency.format(total_budget));

    // Display how much $ is to be distributed into each department
    deptDistributionDisplay.setText(currency.format(distribution_amount));

    // Display Company Total Budget and Dept Budgets in Current Budget Tabs in currency format
    companyBudgetDisplay.setText(currency.format(total_budget));
    salesDeptBudgetDisplay.setText(currency.format(distribution_amount));
    marketingDeptBudgetDisplay.setText(currency.format(distribution_amount));
    productionDeptBudgetDisplay.setText(currency.format(distribution_amount));
    ITDeptBudgetDisplay.setText(currency.format(distribution_amount));
    HRDeptBudgetDisplay.setText(currency.format(distribution_amount));

    // Update Pie Chart data
    updatePieChartData();
}

/**
 * This method displays the department selected in the Select Department Text Field when a department is selected
 * from the drop-down menu in the Change Budget Tab
 * @param event: When a Menu Item is selected from the Selected Dept Menu Button
 */
@FXML
public void setSelectDeptDisplayField(ActionEvent event) {

    // Get Menu Item selected
    MenuItem source = (MenuItem) event.getSource();
    // Display Menu Item selected in the Select Dept Text Field
    selectDeptDisplayField.setText(source.getText());
}

/**
 * This method increases the amount of the department selected and the total budget, updates the values in the
 * Current Budget Tab, and updates the Pie Chart.
 */
@FXML
public void depositFunds() {

    // Get amount entered from the Transaction Amount Text Field and remove any special characters
    BigDecimal amount = new BigDecimal(transactionAmountField.getText().replace(",", "").replace("$", ""));
    // Get selected dept from the Select Dept Text Field
    String selected_dept = selectDeptDisplayField.getText();

    // Switch statement to determine which department is selected from Menu Button
    switch (selected_dept) {
            case "Sales":
                // Get text from Sales Dept Budget Text Field in Current Budget Tab and remove any special chars
                BigDecimal current_sales_budget = new BigDecimal(salesDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
                // Add amount entered to Sales Dept Budget
                BigDecimal new_sales_budget = current_sales_budget.add(amount);
                // Set text in Sales Dept Budget Text Field to update amount and convert to currency format
                salesDeptBudgetDisplay.setText(currency.format(new_sales_budget));
                break;
                // Other cases do the same thing, just updates the associated department selected
            case "Marketing":
                BigDecimal current_marketing_budget = new BigDecimal(marketingDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
                BigDecimal new_marketing_budget = current_marketing_budget.add(amount);
                marketingDeptBudgetDisplay.setText(currency.format(new_marketing_budget));
                break;
            case "Production":
                BigDecimal current_production_budget = new BigDecimal(productionDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
                BigDecimal new_production_budget = current_production_budget.add(amount);
                productionDeptBudgetDisplay.setText(currency.format(new_production_budget));
                break;
            case "IT":
                BigDecimal current_it_budget = new BigDecimal(ITDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
                BigDecimal new_it_budget = current_it_budget.add(amount);
                ITDeptBudgetDisplay.setText(currency.format(new_it_budget));
                break;
            case "HR":
                BigDecimal current_hr_budget = new BigDecimal(HRDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
                BigDecimal new_hr_budget = current_hr_budget.add(amount);
                HRDeptBudgetDisplay.setText(currency.format(new_hr_budget));
                break;
    }

    // Get text from Total Budget Text Field in Current Budget Tab and remove any special chars
    BigDecimal current_total =  new BigDecimal(companyBudgetDisplay.getText().replace(",", "").replace("$", ""));
    // Add amount entered to Total Budget
    BigDecimal new_total = current_total.add(amount);
    // Set text in Total Budget Text Field to update Total Budget and convert to currency format
    companyBudgetDisplay.setText(currency.format(new_total));

    // Update Pie Chart data
    updatePieChartData();

}

/**
 * This method decreases the amount of the department selected and the total budget, updates the values in the
 * Current Budget Tab, and updates the Pie Chart.
 */
@FXML
public void withdrawFunds() {

    // Same process as depositFunds method, except subtracts from Total Budget and Department Selected
    BigDecimal amount = new BigDecimal(transactionAmountField.getText().replace(",", "").replace("$", ""));
    String selected_dept = selectDeptDisplayField.getText();

    switch (selected_dept) {
        case "Sales":
            BigDecimal current_sales_budget = new BigDecimal(salesDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
            BigDecimal new_sales_budget = current_sales_budget.subtract(amount);
            salesDeptBudgetDisplay.setText(currency.format(new_sales_budget));
            break;
        case "Marketing":
            BigDecimal current_marketing_budget = new BigDecimal(marketingDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
            BigDecimal new_marketing_budget = current_marketing_budget.subtract(amount);
            marketingDeptBudgetDisplay.setText(currency.format(new_marketing_budget));
            break;
        case "Production":
            BigDecimal current_production_budget = new BigDecimal(productionDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
            BigDecimal new_production_budget = current_production_budget.subtract(amount);
            productionDeptBudgetDisplay.setText(currency.format(new_production_budget));
            break;
        case "IT":
            BigDecimal current_it_budget = new BigDecimal(ITDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
            BigDecimal new_it_budget = current_it_budget.subtract(amount);
            ITDeptBudgetDisplay.setText(currency.format(new_it_budget));
            break;
        case "HR":
            BigDecimal current_hr_budget = new BigDecimal(HRDeptBudgetDisplay.getText().replace(",", "").replace("$", ""));
            BigDecimal new_hr_budget = current_hr_budget.subtract(amount);
            HRDeptBudgetDisplay.setText(currency.format(new_hr_budget));
            break;
    }

    BigDecimal current_total =  new BigDecimal(companyBudgetDisplay.getText().replace(",", "").replace("$", ""));
    BigDecimal new_total = current_total.subtract(amount);
    companyBudgetDisplay.setText(currency.format(new_total));

    // Update Pie Chart Data
    updatePieChartData();

    }

}
