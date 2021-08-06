package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.scene.layout.*;
import javafx.geometry.Insets;
import javafx.event.*;

import java.io.FileInputStream;

public class Main extends Application {
    
    //creating all label, button and TextField variables so I can access them in the handle() method
    
    Button CalculateButton = new Button("Calculate");

    Label SeedBalance;
    Label Years;
    Label Rate;
    Label FinalValue;

    TextField SeedBalanceBox;
    TextField YearsBox;
    TextField RateBox;
    TextField FinalValueBox;

    @Override
    public void start(Stage primaryStage) throws Exception{
        
//basic setup for the stage and scene
        
        primaryStage.setTitle("Compound Interest Calculator");
        FlowPane rootNode= new FlowPane();
        Scene scene = new Scene(rootNode, 300, 200);
        
//filling in Labels, including spacing to align it in the GUI
        
        SeedBalance = new Label (" Investment Amount:          ");
        Years = new Label       (" Number of Years:               ");
        Rate = new Label       ( " Annual Interest Rate(%):    ");
        FinalValue = new Label  (" Future Value:                      ");
        
//Making TextFields
        
        SeedBalanceBox = new TextField();
        YearsBox = new TextField();
        RateBox = new TextField();
        FinalValueBox = new TextField();
        
//spacing to align the "Calculate" button
        
        Label Spacing = new Label("                                                                      ");
        
//making sure the output box cannot be edited
        
        FinalValueBox.setEditable(false);
        
//connecting button to buttonhandler
        
        CalculateButton.setOnAction(new ButtonHandler());
        
//adding everything to the flowpane
        
        rootNode.getChildren().addAll(SeedBalance, SeedBalanceBox, Years, YearsBox, Rate, RateBox, FinalValue, FinalValueBox, Spacing, CalculateButton);
        
//opens actual GUI
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
//ButtonHandler class
    
    class ButtonHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){

            //takes values in textboxes and converts them to double variables for calculations
            
            double P = Double.parseDouble(SeedBalanceBox.getText().trim());
            double i = Double.parseDouble(RateBox.getText().trim());
            double n = Double.parseDouble(YearsBox.getText().trim());

            //Calculations are next
            //I know that I could have shortened the next two lines into one line, but this is more organized, if not compact
           
            double FinalCalcs = P * Math.pow((1 + (i/100)/12),12 * n);

            //rounding the output to the nearest two decimal places
            
            FinalCalcs = Math.round(FinalCalcs*100.0)/100.0;


            //Putting output into TextField
            
            FinalValueBox.setText(String.valueOf(FinalCalcs));

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
