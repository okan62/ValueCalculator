package Assign04;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import javax.swing.*;

public class Controller extends Application {
    private final TextField UserNameFX = new TextField();
    private final TextField UserAddressFX = new TextField();
    private final TextField AnnualInterestRateFX = new TextField();
    private final TextField NumberOfYearsFX = new TextField();
    private final TextField InvestmentAmountFX = new TextField();
    private final TextField FutureValueFX = new TextField();
    private final Button CalculateFX = new Button("Calculate");
    private final Button ResetFX = new Button("Resets");
    @Override
    public void start(Stage primaryStage){

        GridPane gridPane = new GridPane();
        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.add(new Label("Your name"),0,0);
        gridPane.add(UserNameFX, 1, 0);
        gridPane.add(new Label("Your address"),0,1);
        gridPane.add(UserAddressFX, 1, 1);
        gridPane.add(new Label("Annual Interest Rate"),0,2);
        gridPane.add(AnnualInterestRateFX, 1, 2);
        gridPane.add(new Label("Number of years"), 0, 3);
        gridPane.add(NumberOfYearsFX, 1, 3);
        gridPane.add(new Label("Investment amount"), 0, 4);
        gridPane.add(InvestmentAmountFX, 1, 4);
        gridPane.add(new Label("Future value"), 0, 5);
        gridPane.add(FutureValueFX, 1, 5);
        gridPane.add(CalculateFX, 1, 6);
        gridPane.add(ResetFX, 0, 6);

        gridPane.setAlignment(Pos.CENTER);
        UserNameFX.setAlignment(Pos.BOTTOM_RIGHT);
        UserAddressFX.setAlignment(Pos.BOTTOM_RIGHT);
        AnnualInterestRateFX.setAlignment(Pos.BOTTOM_RIGHT);
        NumberOfYearsFX.setAlignment(Pos.BOTTOM_RIGHT);
        InvestmentAmountFX.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValueFX.setAlignment(Pos.BOTTOM_RIGHT);
        FutureValueFX.setEditable(false);
        GridPane.setHalignment(CalculateFX, HPos.RIGHT);
        GridPane.setHalignment(ResetFX, HPos.RIGHT);

        CalculateFX.setOnAction(e -> {
            calculateFutureValue();
        });

        ResetFX.setOnAction(e -> {
            resetAllFields();
        });

        Scene scene = new Scene(gridPane,400,400);
        primaryStage.setTitle("FUTURE value calculator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void calculateFutureValue() {
        double interest = Double.parseDouble(AnnualInterestRateFX.getText());
        int year = Integer.parseInt(NumberOfYearsFX.getText());
        double investAmount = Double.parseDouble(InvestmentAmountFX.getText());

        Value value = new Value(interest,year,investAmount);

        FutureValueFX.setText(String.format("$%.2f", value.getFutureValue()));
        JOptionPane.showMessageDialog(null, "Name: " + UserNameFX.getText() +
                "\nAddress: " + UserAddressFX.getText() + "\nFuture Value of Your Investment: " +
                FutureValueFX.getText());
    }

    private void resetAllFields() {
        UserNameFX.setText(null);
        UserAddressFX.setText(null);
        AnnualInterestRateFX.setText(null);
        NumberOfYearsFX.setText(null);
        InvestmentAmountFX.setText(null);
        FutureValueFX.setText(null);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Application.launch(args);
    }

}

