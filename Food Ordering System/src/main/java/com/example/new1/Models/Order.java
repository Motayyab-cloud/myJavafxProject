package com.example.new1.Models;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.*;
import java.util.List;

import static com.example.new1.MainApplication.currentCustomer;


public class Order {
    private int orderId;
    private Customer customer;
    private ObservableList<FoodItem> foodItems;
    public  double totalAmount =0;
    private String orderStatus;
   // public static DoubleProperty Total;

    public Order(int orderId, Customer customer , List<FoodItem> foodItems) {
        this.orderId = orderId;
        this.customer = customer;
        this.foodItems = FXCollections.observableArrayList(foodItems); // Initialize as ObservableList
        this.orderStatus = "Pending";
       // calculateTotal();  // Calculate total amount at initialization
    }


    public ObservableList<FoodItem> getFoodItems() {
        return foodItems;
    }


    public Customer getCustomer() {
        return customer;
    }


    public void calculateTotal(List<FoodItem> foodItems) {
// this.foodItems = FXCollections.observableArrayList(foodItems);
//        totalAmount = 0;
        for (FoodItem item : foodItems) {
            totalAmount += item.getPrice();
        }

    }

    public double getTotalAmount() {
        return totalAmount;
    }


    public void setOrderStatus(String status) {
        this.orderStatus = status;
    }


    public void displayOrderDetails() {
        System.out.println("Order ID: " + orderId);
        customer.displayDetails();
        System.out.println("Ordered Items:");
        for (FoodItem item : foodItems) {
            System.out.println(item.getName() + " - Rs" + item.getPrice());
        }
        System.out.println("Total Amount: Rs" + totalAmount);
        System.out.println("Order Status: " + orderStatus);
    }
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getOrderDetails() {
        StringBuilder details = new StringBuilder();
        details.append("Order ID: ").append(orderId)
                .append("\nOrder Status: ").append(orderStatus)
                .append("\nCustomer ID: ")
                .append(customer.getId())
                .append("\nCustomer Name :")
                .append(customer.getName()).append("\nCustomer Contactno :") .append(customer.getContactNumber()).append("\nCustomer Address :") .append(customer.getAddress())
                .append("\nItems Ordered:\n");

        for (FoodItem item : foodItems) {
            details.append(item.getName()).append(" - Rs").append(item.getPrice()).append("\n");
        }

        details.append("Total Amount: Rs ").append(totalAmount).append("\n");
        return details.toString();
    }

}
