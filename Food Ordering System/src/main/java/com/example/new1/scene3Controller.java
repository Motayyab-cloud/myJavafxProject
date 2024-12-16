package com.example.new1;

import com.example.new1.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;

import static com.example.new1.MainApplication.currentCustomer;
import static com.example.new1.MainApplication.currentOrder;

public class scene3Controller {

    @FXML private Label myid, myname, mycontactno, myaddress, mytotal;
    @FXML private TableView<FoodItem> tableView;
    @FXML private TableColumn<FoodItem, String> myitem, myprice;
    @FXML private Text myText;


    @FXML
    public void setorderdetails() {

            currentOrder = MainApplication.getCurrentOrder();

            if (currentOrder != null) {
                System.out.println("Order found: " + currentOrder.getOrderDetails());

                // Set customer details
                myid.setText(currentCustomer.getId());
                myname.setText(currentCustomer.getName());
                mycontactno.setText(currentCustomer.getContactNumber());
                myaddress.setText(currentCustomer.getAddress());

                // Populate the TableView with ordered items
                ObservableList<FoodItem> orderedItems = FXCollections.observableArrayList(currentOrder.getFoodItems());
                tableView.setItems(orderedItems);

                // Set the columns for the TableView
               myitem.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
                myprice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject().asString());

                // Set total amount
                mytotal.setText(String.valueOf(currentOrder.getTotalAmount()));
            } else {
                System.out.println("Order is null!");
            }
    }

    // Method to switch back to Scene 2
    @FXML
    private void switchToScene2() {
        MainApplication.switchToScene2();
    }

    // Method to close the application
    @FXML
    private void close() {
        System.exit(0);
    }
}
