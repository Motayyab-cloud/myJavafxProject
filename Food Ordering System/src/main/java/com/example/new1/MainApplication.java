package com.example.new1;

import com.example.new1.Models.*;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;

public class MainApplication extends Application {

    public static Stage primaryStage;
    public static Scene scene1, scene2, scene3;
    public static Restaurant restaurant;



    @Override
    public void start(Stage stage) {
        try {

            Parent root1 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/new1/scene1.fxml")));
            Parent root2 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/new1/scene2.fxml")));
            Parent root3 = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/com/example/new1/scene3.fxml")));

            scene1 = new Scene(root1);
            scene2 = new Scene(root2);
            scene3 = new Scene(root3);


            primaryStage = stage;
            primaryStage.setTitle("Food Ordering System");
            primaryStage.setScene(scene1);
            primaryStage.initStyle(StageStyle.UNDECORATED);
            primaryStage.show();

        } catch (Exception e) {
            System.out.println("Error loading FXML file: " + e.getMessage());
            e.printStackTrace();
        }
    }


    private static ObservableList<FoodItem> selectedFoodItems = FXCollections.observableArrayList();

    public static void setSelectedFoodItems(ObservableList<FoodItem> items) {
        selectedFoodItems.setAll(items);
    }

    public static ObservableList<FoodItem> getSelectedFoodItems() {
        return selectedFoodItems;
    }


    public static void switchToScene1() {
        primaryStage.setScene(scene1);
    }

    public static void switchToScene2() {
        primaryStage.setScene(scene2);
    }

    public static void switchToScene3() {
        primaryStage.setScene(scene3);
    }
static Customer customer = new Customer(scene1Controller.id,scene1Controller.name,scene1Controller.contactNumber,scene1Controller.address);

    static {
        restaurant = new Restaurant("Dine And Divine");
        restaurant.addFoodItem(new FoodItem(1, "Signature Burger", 499, "Fast Food"));
        restaurant.addFoodItem(new FoodItem(2, "Double Margarhita Pizza", 999, "Italian"));
        restaurant.addFoodItem(new FoodItem(3, "Beef Biryani", 450, "Desi"));
        restaurant.addFoodItem(new FoodItem(4, "Fruit Trifle", 250, "Dessert"));
        restaurant.addFoodItem(new FoodItem(5, "Chowmein", 2499, "Chinese"));
        restaurant.addFoodItem(new FoodItem(6, "Chai", 150, "Desi"));
        restaurant.addFoodItem(new FoodItem(7, "Beef Steak", 1500, "Western Cuisine"));
        restaurant.addFoodItem(new FoodItem(8, "Mayo French Fries", 250, "French"));
        restaurant.addFoodItem(new FoodItem(9, "Lemonade", 299, "American"));
        restaurant.addFoodItem(new FoodItem(10, "White Karahi", 1399, "Desi"));
    }

    public static Restaurant getRestaurant() {
        return restaurant;
    }
    public static Customer currentCustomer;

    public static Customer getCustomer() {
        return currentCustomer;
    }

    public static void setCustomer(Customer customer) {

        currentCustomer = customer;

    }
   public static Order currentOrder;
    public static Order getCurrentOrder() {
        if (currentOrder == null) {
            System.out.println("Error: Current order is null!");
        }

        return currentOrder;

    }

    public static void setCurrentOrder(Order order) {
        currentOrder = order;
    }

    public static void main(String[] args) {
        launch(args);
    }
}

