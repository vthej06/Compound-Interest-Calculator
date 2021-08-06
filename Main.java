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

        primaryStage.setTitle("Compound Interest Calculator");
        FlowPane rootNode= new FlowPane();
        Scene scene = new Scene(rootNode, 300, 200);

        SeedBalance = new Label (" Investment Amount:          ");
        Years = new Label       (" Number of Years:               ");
        Rate = new Label       ( " Annual Interest Rate(%):    ");
        FinalValue = new Label  (" Future Value:                      ");

        SeedBalanceBox = new TextField();
        YearsBox = new TextField();
        RateBox = new TextField();
        FinalValueBox = new TextField();

        Label Spacing = new Label("                                                                      ");

        FinalValueBox.setEditable(false);

        CalculateButton.setOnAction(new ButtonHandler());

        rootNode.getChildren().addAll(SeedBalance, SeedBalanceBox, Years, YearsBox, Rate, RateBox, FinalValue, FinalValueBox, Spacing, CalculateButton);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    class ButtonHandler implements EventHandler<ActionEvent>{
        public void handle(ActionEvent e){
            double P = Double.parseDouble(SeedBalanceBox.getText().trim());
            double i = Double.parseDouble(RateBox.getText().trim());
            double n = Double.parseDouble(YearsBox.getText().trim());

            //I know that I could have shortened the next two lines into one line, but this is more organized, if not compact
            double FinalCalcs = P * Math.pow((1 + (i/100)/12),12 * n);
            FinalCalcs = Math.round(FinalCalcs*100.0)/100.0;


            FinalValueBox.setText(String.valueOf(FinalCalcs));

        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
