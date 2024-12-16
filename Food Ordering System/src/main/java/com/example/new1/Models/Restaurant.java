package com.example.new1.Models;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {

    private String name;
    private List<FoodItem> menu;

    public Restaurant(String name) {
        this.name = name;
        this.menu = new ArrayList<>();
    }

    public void addFoodItem(FoodItem item) {
        menu.add(item);
    }

    public void displayMenu() {
        for (int i = 0; i < menu.size(); i++) {
            FoodItem item = menu.get(i);

            System.out.println("Item: " + item.getName() + ", Price: Rs" + item.getPrice());
        }
    }

    public FoodItem getFoodItemById(int id) {
        for (FoodItem item : menu) {
            if (item.getId() == id) {
                return item;
            }
        }

        return null;
    }


    public String getName() {
        return name;
    }
    public List<FoodItem> getFoodItems() {
        return menu;
    }
}
