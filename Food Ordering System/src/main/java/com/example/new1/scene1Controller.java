package com.example.new1;

import com.example.new1.Models.Customer;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Text;

import static com.example.new1.MainApplication.*;

public class scene1Controller {

    public AnchorPane abc333;

    @FXML private Text myheading;
    @FXML private Text mheading2;

    @FXML
    private Text text1;
    @FXML
    private Text text2;
    @FXML
    private Text text3;
    @FXML
    private Text text4;
    @FXML
    public TextField myTextFeild1;
    @FXML
    public TextField myTextFeild2;
    @FXML
    public TextField myTextFeild3;
    @FXML
    public TextField myTextFeild4;

    @FXML
    private Button myButton;

    static String id,name, contactNumber, address;
//   Customer customer;
    @FXML
    public void submit(javafx.event.ActionEvent actionEvent) {
       id = myTextFeild1.getText();
        name = myTextFeild2.getText();
        contactNumber = myTextFeild3.getText();
        address = myTextFeild4.getText();

        System.out.println("Id : " + id + " Name : " + name + " Contact Number : " + contactNumber + " Address : " + address);
    currentCustomer = new Customer(id,name,contactNumber,address);
 setCustomer(currentCustomer);
 restaurant.getName();

        if  (!myTextFeild1.getText().isEmpty() &&
               !myTextFeild2.getText().isEmpty() &&
                !myTextFeild3.getText().isEmpty() &&
               !myTextFeild4.getText().isEmpty()) {

            switchToScene2();

        } else {
            System.out.println("All fields must be filled!");
        }
    }

    @FXML
    private Button goToScene2;

    // Method to switch to Scene 2
    @FXML
    public void switchToScene2() {
        MainApplication.switchToScene2(); // Switch to Scene 2
    }

    // Method to switch to Scene 3 (not used here)
    @FXML
    public void switchToScene3() {
        MainApplication.switchToScene3(); // Switch to Scene 3
    }
}
