package com.example.new1.Models;
public class Person {
   public static String id ;
    public static String name;
   public static String contactNumber;
public Person() {}
    public Person(String id, String name, String contactNumber) {
        this.id = id;
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String displayDetails() {
        System.out.println("ID: " + id + ", Name: " + name + ", Contact: " + contactNumber);
        return null;
    }
}
