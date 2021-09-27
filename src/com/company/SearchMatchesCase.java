package com.company;

import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchMatchesCase {

    public void searchMatches() {
        Stage fourthStage = new Stage();
        fourthStage.setTitle("Search matches");
        Pane root = new Pane();

        Label label1 = new Label("Fill the date to search matches(in numbers): ");

        TextField dayTF = new TextField();
        dayTF.setPromptText("D");
        dayTF.setLayoutX(50);
        dayTF.setLayoutY(50);
        dayTF.setMinWidth(100);

        TextField monthTF = new TextField();
        monthTF.setPromptText("M");
        monthTF.setLayoutX(250);
        monthTF.setLayoutY(50);
        monthTF.setMinWidth(100);

        TextField yearTF = new TextField();
        yearTF.setPromptText("Y");
        yearTF.setLayoutX(450);
        yearTF.setLayoutY(50);
        yearTF.setMinWidth(100);

        Label label2 = new Label();
        label2.setLayoutX(50);
        label2.setLayoutY(200);

        Label label3 = new Label();
        label3.setLayoutX(30);
        label3.setLayoutY(450);

        Button searchButton = new Button("Search");
        searchButton.setLayoutX(650);
        searchButton.setLayoutY(50);
        searchButton.setMinWidth(100);

        searchButton.setOnAction((ActionEvent e) ->{
            int check1;
            int check2;
            int check3;
            label3.setText("");
            try {
                //validating empty text fields
                if (dayTF.getText().isEmpty() || monthTF.getText().isEmpty() || yearTF.getText().isEmpty()){
                    label3.setText("Please fill all the text boxes");
                }else {
                    //validating the integer text fields
                    try {
                        check1 = Integer.parseInt(dayTF.getText());
                        check2 = Integer.parseInt(monthTF.getText());
                        check3 = Integer.parseInt(yearTF.getText());

                        String showMatches = getSearchedMatches(dayTF.getText(), monthTF.getText(), yearTF.getText());
                        //validating no matches found
                        if (showMatches.isEmpty()) {
                            label3.setText("No matches played on this date");
                        } else {
                            label2.setText(showMatches);
                        }
                    }catch (NumberFormatException e1) {
                        label3.setText("Please enter only integers");
                    }
                }
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        root.getChildren().addAll(label1,dayTF,monthTF,yearTF,searchButton,label2,label3);
        fourthStage.setWidth(800);
        fourthStage.setHeight(600);
        fourthStage.setScene(new Scene(root));
        fourthStage.show();
    }

    public String getSearchedMatches(String day, String month, String year) throws IOException{
        File file = new File("PlayedMatches.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        //Date that need to search
        String searchDate = "Match played date: day="+day+"/month="+month+"/year="+year;

        String currentLine;
        //object arraylist
        List list = new ArrayList();

        //reading the text file and adding matched dates matches to the list
        while ((currentLine = reader.readLine()) != null){

            String f[] = currentLine.split(",");
            String dateInText = f[0];

            if (dateInText.equals(searchDate)){
                list.add(currentLine);
            }
        }
        reader.close();

        //arranging the matches in the list as line by line
        String text = "";
        for (int x = 0; x < list.size(); x++) {
            text = text + list.get(x)+"\n";
        }

            return text;

    }
}
