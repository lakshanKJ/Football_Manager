package com.company;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicInteger;

public class GUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }
    public void mainCaller(){ main(null);}

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Foot Ball");
        Pane pane = new Pane();
        TableListDesc tableListDesc = new TableListDesc();

        Button button1 = new Button("Display teams in descending order");
        button1.setLayoutX(50);
        button1.setLayoutY(50);

        // to pass a integer to check it in the TableListDesc class
        AtomicInteger choice = new AtomicInteger();
        button1.setOnAction((ActionEvent e) -> {
            try {
                choice.set(1);
                tableListDesc.tList(choice);

            } catch (IOException ioException) {
                System.out.println("Something went wrong");
            }
        });

        Button button2 = new Button("Random match");
        button2.setLayoutX(50);
        button2.setLayoutY(100);
        button2.setOnAction((ActionEvent e) ->{
            RandomCase randomCase = new RandomCase();
            try {
                randomCase.randomMatch();
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        Button button3 = new Button("View played matches");
        button3.setLayoutX(50);
        button3.setLayoutY(150);
        button3.setOnAction((ActionEvent e) ->{
            PlayedMatchesCase playedMatchesCase = new PlayedMatchesCase();
            try {
                playedMatchesCase.playedMatches();
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        Button button4 = new Button("Search played matches");
        button4.setLayoutX(50);
        button4.setLayoutY(200);
        button4.setOnAction((ActionEvent e) ->{
            SearchMatchesCase searchMatchesCase = new SearchMatchesCase();
            searchMatchesCase.searchMatches();
        });

        pane.getChildren().addAll(button1,button2,button3,button4);
        primaryStage.setScene(new Scene(pane, 650,800));
        primaryStage.show();
    }
}