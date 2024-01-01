package com.example.demo7;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StoreLoans extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<Loan> loanList = new ArrayList<>();
        //creates five Loan objects and stores them into file LoanDetails.dat
        loanList.add(new Loan(2.5, 5, 1000));
        loanList.add(new Loan(3.0, 10, 5000));
        loanList.add(new Loan(4.2, 3, 2000));
        loanList.add(new Loan(2.0, 7, 3000));
        loanList.add(new Loan(3.5, 2, 1500));

        try (ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("LoanDetails.dat"))) {
            for (Loan loan : loanList) {
                output.writeObject(loan);
            }
            System.out.println("Loan objects have been stored in LoanDetails.dat file");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
