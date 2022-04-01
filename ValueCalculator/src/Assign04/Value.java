package Assign04;

public class Value {
    private double annualInterestRate;
    private int numberOfYears;
    private double investmentAmount;
    private final java.util.Date valueDate;

    public Value(){
        this(2.5,1,1000);
    }

    public Value(double annualInterestRate, int numberOfYears, double investmentAmount){
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;
        this.investmentAmount = investmentAmount;
        valueDate = new java.util.Date();
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }


    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public int getNumberOfYears(){
        return numberOfYears;
    }

    public void setNumberOfYears(int numberOfYears){
        this.numberOfYears = numberOfYears;
    }

    public double getInvestmentAmount(){
        return investmentAmount;
    }


    public void setInvestmentAmount(double investmentAmount){
        this.investmentAmount = investmentAmount;
    }

    public double getFutureValue() {
        return investmentAmount * Math.pow((1 + annualInterestRate/100), numberOfYears);
    }

    public java.util.Date getLoanDate(){
        return valueDate;
    }
}

