package com.example.new1;

import com.example.new1.Models.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.text.Text;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.example.new1.MainApplication.*;

public class scene2Controller {
    @FXML private Text myrestuarant;
    @FXML private Label mylabel;


    @FXML private TableView<FoodItem> foodTableView;
    @FXML private TableColumn<FoodItem, Integer> myId;
    @FXML private TableColumn<FoodItem, String> myName;
    @FXML private TableColumn<FoodItem, Double> myPrice;

    @FXML private TableColumn<FoodItem, String> myCategory;
    @FXML private Text myT3;
    @FXML private Button myconfirm, goToScene1;
    @FXML private Button addButton;

    private ObservableList<FoodItem> foodItemsList = FXCollections.observableArrayList();
    private Order   currentOrder = new Order(1, currentCustomer ,new ArrayList<>()); ;

    public void initialize() {
        // Bind columns to FoodItem properties
        myId.setCellValueFactory(cellData -> cellData.getValue().idProperty().asObject());
        myName.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        myPrice.setCellValueFactory(cellData -> cellData.getValue().priceProperty().asObject());
        myCategory.setCellValueFactory(cellData -> cellData.getValue().categoryProperty());

        // Load sample data
        foodItemsList.addAll(MainApplication.getRestaurant().getFoodItems());
        foodTableView.setItems(foodItemsList);

       // currentOrder = new Order(1, currentCustomer ,new ArrayList<>());
        // Initialize an empty order with the current customer

        // Set selection mode to MULTIPLE
        foodTableView.getSelectionModel().setSelectionMode(javafx.scene.control.SelectionMode.MULTIPLE);
        mylabel.setText(restaurant.getName());
    }

    @FXML
    public void Add(javafx.event.ActionEvent actionEvent) {

        // Get all selected items from the TableView
        ObservableList<FoodItem> selectedItems = foodTableView.getSelectionModel().getSelectedItems();
        currentOrder.calculateTotal( selectedItems);
        if (selectedItems.isEmpty()) {
            System.out.println("No items selected.");
        } else {
            // Add selected items to the current order
            currentOrder.getFoodItems().addAll(selectedItems);
            System.out.println("Selected Items added to the order:");
            for (FoodItem item : selectedItems) {
                System.out.println("Name: " + item.getName() + ", Price: " + item.getPrice());
            }
            MainApplication.setCurrentOrder(currentOrder);
        }
    }
           scene3Controller setorder = new scene3Controller();
 //    setorder.setorderdetails();
    @FXML
    public void Confirm(javafx.event.ActionEvent actionEvent) {

        try {
            currentOrder.setCustomer(currentCustomer);

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/new1/scene3.fxml"));

            // Load the FXML file and get the root element (Parent)
            Parent root3 = loader.load();  // This loads the FXML

            // Get the controller from the loader
            scene3Controller controller = loader.getController();

            // Set the current order to the scene3Controller
            controller.setorderdetails();

            // Create the scene with the loaded root
            Scene scene = new Scene(root3);

            // Switch to Scene 3
            primaryStage.setScene(scene);
            controller.setorderdetails();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //       scene3Controller setorder = new scene3Controller();

        // Switch to Scene 3 to display order details
       // MainApplication.switchToScene3();
    }

    @FXML
    public void switchToScene1() {
        MainApplication.switchToScene1();
    }
}
