package com.example.demo7;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.*;
import java.util.Date;

public class BinaryObjects extends Application {
    private final int[] array = {1, 2, 3, 4, 5}; //array of five integer values
    private final Date currentDate = new Date(); //Date object for current time
    private final double value = 5.5;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        //store data into binary file called BinaryOutput.dat
        try (DataOutputStream output = new DataOutputStream(new FileOutputStream("BinaryOutput.dat"))) {
            for (int i = 0; i < array.length; i++) {
                output.writeInt(array[i]);
            }
            output.writeLong(currentDate.getTime());
            output.writeDouble(value);
            System.out.println("Data has been written to BinaryOutput.dat file");
        } catch (IOException e) {
            e.printStackTrace();
        }

        //read and display data from the binary file
        try (DataInputStream input = new DataInputStream(new FileInputStream("BinaryOutput.dat"))) {
            for (int i = 0; i < array.length; i++) {
                int num = input.readInt();
                System.out.println(num);
            }
            long dateInMillis = input.readLong();
            Date date = new Date(dateInMillis);
            System.out.println(date);
            double num = input.readDouble();
            System.out.println(num);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
