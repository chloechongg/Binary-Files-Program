package com.example.demo7;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class RestoreLoans extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        List<Loan> loanList = new ArrayList<>();

        //reads Loan objects from LoanDetails.dat file
        try (ObjectInputStream input = new ObjectInputStream(new FileInputStream("LoanDetails.dat"))) {
            while (true) {
                try {
                    Loan loan = (Loan) input.readObject();
                    loanList.add(loan);
                } catch (EOFException e) {
                    break;
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        double totalLoanAmount = 0.0;
        for (Loan loan : loanList) {
            totalLoanAmount += loan.getLoanAmount(); //calculate total loan amount
        }

        //display total loan amount
        System.out.println("Total loan amount: " + totalLoanAmount);
    }
}
