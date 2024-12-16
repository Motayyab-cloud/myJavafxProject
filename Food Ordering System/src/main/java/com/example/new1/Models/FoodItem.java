package com.example.new1.Models;

import javafx.beans.property.*;

public class FoodItem {
    private IntegerProperty id;
    private StringProperty name;
    private DoubleProperty price;
    private StringProperty category;


    public FoodItem(int id, String name, double price, String category) {
        this.id = new SimpleIntegerProperty(id);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.category = new SimpleStringProperty(category);
    }

    public IntegerProperty idProperty() { return id; }
    public StringProperty nameProperty() { return name; }
    public DoubleProperty priceProperty() { return price; }
    public StringProperty categoryProperty() { return category; }


    public int getId() { return id.get(); }
    public String getName() { return name.get(); }
    public double getPrice() { return price.get(); }
    public String getCategory() { return category.get(); }
}
