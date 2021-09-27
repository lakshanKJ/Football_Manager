package com.company;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomCase {

    Random r = new Random();
    PremierLeagueManager pLM = new PremierLeagueManager();
    String secondClub = "";

    public void randomMatch() throws IOException {
        Stage thirdStage = new Stage();
        thirdStage.setTitle("Random Match");
        Pane root = new Pane();
        Label label = new Label(getRandomMatch());

        root.getChildren().addAll(label);
        thirdStage.setWidth(700);
        thirdStage.setHeight(600);
        thirdStage.setScene(new Scene(root));
        thirdStage.show();
    }

    public String getRandomMatch() throws IOException {
        File file = new File("PremierLeagueManager.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader2 = new BufferedReader(new FileReader(file));
        FileWriter f2W = new FileWriter("PlayedMatches.txt",true);

        String currentLineInText;
        List<String> list = new ArrayList<>();

        while ((currentLineInText = reader.readLine()) != null) {
            //          taking club name
            String f[] = currentLineInText.split(",");
            String c[] = f[0].split(": ");
            String club = c[1];

            list.add(club);
        }

        String firstClub = list.get(r.nextInt(list.size()));
        getSecondRandom(firstClub, list);

        int[] yearList = {2020,2019,2018};
        int[] monthList = {1,2,3,4,5,6,7,8,9,10,11,12};

        int year = yearList[r.nextInt(yearList.length)];
        int month = monthList[r.nextInt(monthList.length)];
        int day = r.nextInt(29);

        Date date = new Date(day,month,year);

        int[] scoreList = {1,2,3,4,5,6,7,8};
        int firstScore = scoreList[r.nextInt(scoreList.length)];
        int secondScore = scoreList[r.nextInt(scoreList.length)];

        String show = "Match played date: "+date+" Club name: "+firstClub+" Score: "+firstScore+" Club name: "+secondClub+" Score: "+secondScore;

        //writing data to the text file PlayedMatches.txt
        f2W.write("Match played date: " + date);
        f2W.write(",FC 1 name: " + firstClub);
        f2W.write(",FC 1 goals scored: " + firstScore);
        f2W.write(",FC 2 name: " + secondClub);
        f2W.write(",FC 2 goals scored: " + secondScore + "\n");
        f2W.close();

        //        Statistics calculation of clubs
        //        getting the clubs' results
        int matchResult = firstScore - secondScore;
        int club1WinStatus;
        int club1DefeatStatus;
        int club1DrawStatus;
        int club2WinStatus;
        int club2DefeatStatus;
        int club2DrawStatus;
        int club1Points;
        int club2Points;
        if (matchResult < 0) {
            club1WinStatus = 0;
            club1DefeatStatus = 1;
            club1DrawStatus = 0;
            club2WinStatus = 1;
            club2DefeatStatus = 0;
            club2DrawStatus = 0;
            club1Points = 0;
            club2Points = 2;
        } else if (matchResult == 0) {
            club1WinStatus = 0;
            club1DefeatStatus = 0;
            club1DrawStatus = 1;
            club2WinStatus = 0;
            club2DefeatStatus = 0;
            club2DrawStatus = 1;
            club1Points = 0;
            club2Points = 0;
        } else {
            club1WinStatus = 1;
            club1DefeatStatus = 0;
            club1DrawStatus = 0;
            club2WinStatus = 0;
            club2DefeatStatus = 1;
            club2DrawStatus = 0;
            club1Points = 2;
            club2Points = 0;
        }

        //        getting the goals received in the match
        int club1GoalsRec = secondScore;
        int club2GoalsRec = firstScore;

        String currentLine;

        while ((currentLine = reader2.readLine()) != null) {
            //taking club name and statistics from the text file to update
            String lineSplit[] = currentLine.split(",");
            String fCNameEntity = lineSplit[0];
            String a[] = fCNameEntity.split(": ");
            String fCName = a[1];

            String winsEntity = lineSplit[1];
            String b[] = winsEntity.split(": ");
            int winsNumber = Integer.parseInt(b[1]);

            String drawsEntity = lineSplit[2];
            String c[] = drawsEntity.split(": ");
            int drawsNumber = Integer.parseInt(c[1]);

            String defeatsEntity = lineSplit[3];
            String d[] = defeatsEntity.split(": ");
            int defeatsNumber = Integer.parseInt(d[1]);

            String goalsReceEntity = lineSplit[4];
            String e[] = goalsReceEntity.split(": ");
            int goalsRecNumber = Integer.parseInt(e[1]);

            String goalsScEntity = lineSplit[5];
            String f[] = goalsScEntity.split(": ");
            int goalsScNumber = Integer.parseInt(f[1]);

            String pointEntity = lineSplit[6];
            String g[] = pointEntity.split(": ");
            int pointNumber = Integer.parseInt(g[1]);

            String matchesPlayedEntity = lineSplit[7];
            String h[] = matchesPlayedEntity.split(": ");
            int matchesPlayedNumber = Integer.parseInt(h[1]);

            //            club 1 statistics update
            if (fCName.equals(firstClub)) {

                //New updated details(calculations)
                int newWins = (winsNumber + club1WinStatus);
                int newDraws = (drawsNumber + club1DrawStatus);
                int newDefeats = (defeatsNumber + club1DefeatStatus);
                int newGoalsRec = (goalsRecNumber + club1GoalsRec);
                int newGoalsSc = (goalsScNumber + firstScore);
                int newPoints = (pointNumber + club1Points);
                int newMatchesPlayed = (matchesPlayedNumber + 1);

                pLM.updateTextFile(currentLine, firstClub, newWins, newDraws, newDefeats, newGoalsRec, newGoalsSc, newPoints, newMatchesPlayed);
            }

            //            club 2 statistics update
            if (fCName.equals(secondClub)) {

                //New updated details(calculations)
                int newWins = (winsNumber + club2WinStatus);
                int newDraws = (drawsNumber + club2DrawStatus);
                int newDefeats = (defeatsNumber + club2DefeatStatus);
                int newGoalsRec = (goalsRecNumber + club2GoalsRec);
                int newGoalsSc = (goalsScNumber + secondScore);
                int newPoints = (pointNumber + club2Points);
                int newMatchesPlayed = (matchesPlayedNumber + 1);

                pLM.updateTextFile(currentLine, secondClub, newWins, newDraws, newDefeats, newGoalsRec, newGoalsSc, newPoints, newMatchesPlayed);
            }

        }
        reader2.close();
        reader.close();

        return show;
    }

    private void getSecondRandom(String firstClub, List<String> list) {
        String generatedValue = list.get(r.nextInt(list.size()));

        if (generatedValue.equals(firstClub)){
            getSecondRandom(firstClub, list);
        } else {
            secondClub = generatedValue;
        }
    }
}
