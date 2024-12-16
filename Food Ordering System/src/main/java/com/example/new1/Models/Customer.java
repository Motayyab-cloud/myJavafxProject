package com.example.new1.Models;

public class Customer extends Person {
    public static String address;

    public Customer() {}
    public Customer(String id, String name, String contactNumber, String address) {
        super(id, name, contactNumber);
        this.address = address;
    }

    @Override
    public String displayDetails() {
        String parentDetails = super.displayDetails(); // Assuming the parent method returns a string
        String details = parentDetails + "\nAddress: " + address;
        System.out.println(details); // If you still want to print it
        return details;
    }

    // Correct the getDetails method to return a properly concatenated string
//    public String getDetails() {
//        return contactNumber.toString(id+name+address);
//    }

    public String getContactNumber() {
        return contactNumber;
    }
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getAddress() {
        return address;
    }
}
