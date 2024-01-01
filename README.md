# Binary-Files-Program
This project encompasses three storing objects and arrays in a file, store LOAN objects, and restoring objects from a file

Task 1: Store Objects and Arrays in a File
I write a JavaFX program, called ‘BinaryObjects’ that stores an array of the five int values 1, 2, 3, 4 and 5, a Date
object for the current time, and the double value 5.5 into a binary file called BinaryOutput.dat. In the same
program, write the code to read and display the data.

Task 2: Store Loan Objects
The Load class below does not implement Serializable. I rewrite the Loan class to implement Serializable, then write a
JavaFX program, called ‘StoreLoans’ that creates five Loan objects and stores them in a file called LoanDetails.dat.
public class Loan
{
private double annualInterestRate;
private int numberOfYears;
private double loanAmount;
private java.util.Date loanDate;
public Loan()
{
this( 2.5, 1, 1000 );
}
public Loan(double annualInterestRate, int numberOfYears, double loanAmount)
{
this.annualInterestRate = annualInterestRate;
this.numberOfYears = numberOfYears;
this.loanAmount = loanAmount;
loanDate = new java.util.Date();
}
public double getAnnualInterestRate()
{
return annualInterestRate;
}
public void setAnnualInterestRate(double annualInterestRate)
{
this.annualInterestRate = annualInterestRate;
}
public int getNumberOfYears()
{
return numberOfYears;
}
public void setNumberOfYears(int numberOfYears)
{
CSC-356: Intermediate Object-Oriented Programming
Professor Thomas Volkman
Module 12 Lab: Binary Input and Output 2 | P a g e
Lab Assignment, Module #5
this.numberOfYears = numberOfYears;
}
public double getLoanAmount()
{
return loanAmount;
}
public void setLoanAmount(double loanAmount)
{
this.loanAmount = loanAmount;
}
public double getMonthlyPayment()
{
double monthlyInterestRate = annualInterestRate / 1200;
double monthlyPayment = loanAmount * monthlyInterestRate / (1 –
(1 / Math.pow(1 + monthlyInterestRate, numberOfYears * 12)));
return monthlyPayment;
}
public double getTotalPayment()
{
double totalPayment = getMonthlyPayment() * numberOfYears * 12;
return totalPayment;
}
public java.util.Date getLoanDate()
{
return loanDate;
}
}

Task 3: Restore Objects from a File
Then, I write a JavaFX program, called ‘RestoreLoans’ that reads the Loan objects from the LoanDetails.dat file that I
created in Task 2, and displays the total loan amount. Then, I write the program as if I don’t know how many Loan
objects are in the file, and use EOFException to end the loop.
