package com.example.csc331accountingapp;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class AccountingAppController implements Initializer {

    @FXML
    private TextField HRDepartmentTextField;

    @FXML
    private TextField ITDepartmentTextField;

    @FXML
    private Tab companyBudgetTab;

    @FXML
    private TextField companyBudgetTextField;

    @FXML
    private MenuButton departmentMenuButton;

    @FXML
    private Button depositButton;

    @FXML
    private TextField marketingDepartmentTextField;

    @FXML
    private PieChart pieChartDisplay;

    @FXML
    private TextField productionDepartmentTextField;

    @FXML
    private Tab reportsTab;

    @FXML
    private TextField salesDepartmentTextField;

    @FXML
    private TextField transactionAmountTextField;

    @FXML
    private Button withdrawButton;

    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
                        new PieChart.Data("Sales", 20),
                        new PieChart.Data("Marketing", 20),
                        new PieChart.Data("Production", 20),
                        new PieChart.Data("IT", 20),
                        new PieChart.Data("HR", 20));

//        pieChartData.forEach(data ->
//                data.nameProperty().bind(
//                        Bindings.concat(
//                                data.getName(), " amount: ", data.pieValueProperty()
//                        )
//                )
//        );

        pieChartDisplay.setData(pieChartData);
    }
}
