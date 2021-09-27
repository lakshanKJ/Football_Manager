package com.company;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TableListDesc {

    public void tList(AtomicInteger option) throws IOException {
        Stage secondStage = new Stage();
        secondStage.setTitle("Table List");

        final TableView<FCClubs> table = new TableView<>();
        table.setMinHeight(598);
        table.setOpacity(0.7);

        List<FCClubs> list = getList(option);
        final ObservableList<FCClubs> data =
                FXCollections.observableArrayList(list);
        final HBox hb = new HBox();

        Button goalsScBtn = new Button("Sort according to goals scored");
        Button winsBtn = new Button("Sort according to wins");

        //adding table columns
        TableColumn clubCol = new TableColumn("Club Name");
        clubCol.setMinWidth(100);
        clubCol.setCellValueFactory(
                new PropertyValueFactory<>("club"));

        TableColumn winsCol = new TableColumn("Wins");
        winsCol.setMinWidth(100);
        winsCol.setCellValueFactory(
                new PropertyValueFactory<>("wins"));

        TableColumn drawsCol = new TableColumn("Draws");
        drawsCol.setMinWidth(100);
        drawsCol.setCellValueFactory(
                new PropertyValueFactory<>("draws"));

        TableColumn defeatsCol = new TableColumn("Defeats");
        defeatsCol.setMinWidth(100);
        defeatsCol.setCellValueFactory(
                new PropertyValueFactory<>("defeats"));

        TableColumn goalsRecCol = new TableColumn("Goals Received");
        goalsRecCol.setMinWidth(100);
        goalsRecCol.setCellValueFactory(
                new PropertyValueFactory<>("goalsReceived"));

        TableColumn goalsScCol = new TableColumn("Goals Scored");
        goalsScCol.setMinWidth(100);
        goalsScCol.setCellValueFactory(
                new PropertyValueFactory<>("goalsScored"));

        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setMinWidth(100);
        pointsCol.setCellValueFactory(
                new PropertyValueFactory<>("points"));

        TableColumn matchesPlCol = new TableColumn("Matches Played");
        matchesPlCol.setMinWidth(100);
        matchesPlCol.setCellValueFactory(
                new PropertyValueFactory<>("matchesPlayed"));

        table.setItems(data);
        table.getColumns().addAll(clubCol,winsCol,drawsCol,defeatsCol,goalsRecCol,goalsScCol,pointsCol,matchesPlCol);

        goalsScBtn.setOnAction((ActionEvent e) ->{
            try {
                option.set(2);
                List<FCClubs> goalList = getList(option);
                final ObservableList<FCClubs> goalData =
                        FXCollections.observableArrayList(goalList);
                table.setItems(goalData);
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        winsBtn.setOnAction((ActionEvent e) ->{
            try {
                option.set(3);
                List<FCClubs> winList = getList(option);
                final ObservableList<FCClubs> winData =
                        FXCollections.observableArrayList(winList);
                table.setItems(winData);
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        Button pointBtn = new Button("Sort according to points");
        pointBtn.setOnAction((ActionEvent e) ->{
            try {
                option.set(1);
                List<FCClubs> pointList = getList(option);
                final ObservableList<FCClubs> pointData =
                        FXCollections.observableArrayList(pointList);
                table.setItems(pointData);
            } catch (IOException ioException) {
                System.out.println("something went wrong");
            }
        });

        hb.getChildren().addAll(goalsScBtn, winsBtn,pointBtn);//adding children (buttons)
        hb.setSpacing(3);

        final VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(hb,table);

        Scene scene = new Scene(new Group());
        secondStage.setWidth(828);
        secondStage.setHeight(700);
        ((Group) scene.getRoot()).getChildren().addAll(vbox);
        secondStage.setScene(scene);
        secondStage.setResizable(false);
        secondStage.show();
    }

    public static class FCClubs{
        private final SimpleStringProperty club;
        private final SimpleStringProperty wins;
        private final SimpleStringProperty draws;
        private final SimpleStringProperty defeats;
        private final SimpleStringProperty goalsReceived;
        private final SimpleStringProperty goalsScored;
        private final SimpleStringProperty points;
        private final SimpleStringProperty matchesPlayed;


        public FCClubs(String club, String wins, String draws, String defeats, String goalsReceived, String goalsScored, String points, String matchesPlayed) {
            this.club = new SimpleStringProperty(club);
            this.wins = new SimpleStringProperty(wins);
            this.draws = new SimpleStringProperty(draws);
            this.defeats = new SimpleStringProperty(defeats);
            this.goalsReceived = new SimpleStringProperty(goalsReceived);
            this.goalsScored = new SimpleStringProperty(goalsScored);
            this.points = new SimpleStringProperty(points);
            this.matchesPlayed = new SimpleStringProperty(matchesPlayed);
        }

        public String getClub() {
            return club.get();
        }

        public void setClub(String club) {
            this.club.set(club);
        }

        public String getWins() {
            return wins.get();
        }

        public void setWins(String wins) {
            this.wins.set(wins);
        }

        public String getDraws() {
            return draws.get();
        }

        public void setDraws(String draws) {
            this.draws.set(draws);
        }

        public String getDefeats() {
            return defeats.get();
        }

        public void setDefeats(String defeats) {
            this.defeats.set(defeats);
        }

        public String getGoalsReceived() {
            return goalsReceived.get();
        }

        public void setGoalsReceived(String goalsReceived) {
            this.goalsReceived.set(goalsReceived);
        }

        public String getGoalsScored() {
            return goalsScored.get();
        }

        public void setGoalsScored(String goalsScored) {
            this.goalsScored.set(goalsScored);
        }

        public String getPoints() {
            return points.get();
        }

        public void setPoints(String points) {
            this.points.set(points);
        }

        public String getMatchesPlayed() {
            return matchesPlayed.get();
        }

        public void setMatchesPlayed(String matchesPlayed) {
            this.matchesPlayed.set(matchesPlayed);
        }
    }

    public List<FCClubs> getList(AtomicInteger choice) throws IOException{
        File file = new File("PremierLeagueManager.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedReader reader2 = new BufferedReader(new FileReader(file));

        String currentLine;
        //        getting the total number of lines in the text file
        int lines = 0;
        while (reader2.readLine() != null) {
            lines++;
        }
        reader2.close();

        //        using array list object
        ArrayList<String> arrayList = new ArrayList();


        while ((currentLine = reader.readLine()) != null) {
            //          taking club name
            String f[] = currentLine.split(",");
            String c[] = f[0].split(": ");
            String club = c[1];

            //           taking wins
            String winsEntity[] = f[1].split(": ");
            String wins = winsEntity[1];

            //           taking draws
            String drawsEntity[] = f[2].split(": ");
            String draws = drawsEntity[1];

            //           taking defeats
            String defeatsEntity[] = f[3].split(": ");
            String defeats = defeatsEntity[1];

            //            taking goals received
            String gR[] = f[4].split(": ");
            int goalsReceived = Integer.parseInt(gR[1]);

            //            taking goals scored
            String gS[] = f[5].split(": ");
            int goalsScored = Integer.parseInt(gS[1]);

            //            taking points
            String pointEntity = f[6];
            String g[] = pointEntity.split(": ");
            String pointNumber = g[1];

            //           taking defeats
            String matchesPlayedEntity[] = f[7].split(": ");
            String matchesPlayed = matchesPlayedEntity[1];


            //            adding statistics to a array list
            arrayList.add(club+"/"+wins+"/"+draws+"/"+defeats+"/"+goalsReceived+"/"+goalsScored+"/"+pointNumber+"/"+matchesPlayed);

        }

        if (choice.intValue() ==1) {
            for (int h = 0; h < (lines - 1); h++) {
                for (int j = 0; j < lines - h - 1; j++) {
                    if (getPoint(arrayList.get(j)) < getPoint(arrayList.get(j + 1))) {
                        String temp = getClubName(arrayList.get(j)) + "/" + getWins(arrayList.get(j)) + "/" + getDraws(arrayList.get(j)) + "/" + getDefeats(arrayList.get(j)) + "/" + getGoalsReceived(arrayList.get(j)) + "/" + getGoalsSc(arrayList.get(j)) + "/" + getPoint(arrayList.get(j)) + "/" + getMatchesPl(arrayList.get(j));
                        String temp2 = getClubName(arrayList.get(j + 1)) + "/" + getWins(arrayList.get(j + 1)) + "/" + getDraws(arrayList.get(j + 1)) + "/" + getDefeats(arrayList.get(j + 1)) + "/" + getGoalsReceived(arrayList.get(j + 1)) + "/" + getGoalsSc(arrayList.get(j + 1)) + "/" + getPoint(arrayList.get(j + 1)) + "/" + getMatchesPl(arrayList.get(j + 1));
                        arrayList.set(j, temp2);
                        arrayList.set((j + 1), temp);
                    }
                }
            }
        }else if (choice.intValue() == 2) {

            for (int h = 0; h < (lines - 1); h++) {
                for (int j = 0; j < lines - h - 1; j++) {
                    if (getGoalsSc(arrayList.get(j)) < getGoalsSc(arrayList.get(j + 1))) {
                        String temp = getClubName(arrayList.get(j)) + "/" + getWins(arrayList.get(j)) + "/" + getDraws(arrayList.get(j)) + "/" + getDefeats(arrayList.get(j)) + "/" + getGoalsReceived(arrayList.get(j)) + "/" + getGoalsSc(arrayList.get(j)) + "/" + getPoint(arrayList.get(j)) + "/" + getMatchesPl(arrayList.get(j));
                        String temp2 = getClubName(arrayList.get(j + 1)) + "/" + getWins(arrayList.get(j + 1)) + "/" + getDraws(arrayList.get(j + 1)) + "/" + getDefeats(arrayList.get(j + 1)) + "/" + getGoalsReceived(arrayList.get(j + 1)) + "/" + getGoalsSc(arrayList.get(j + 1)) + "/" + getPoint(arrayList.get(j + 1)) + "/" + getMatchesPl(arrayList.get(j + 1));
                        arrayList.set(j, temp2);
                        arrayList.set((j + 1), temp);
                    }
                }
            }
        }else if (choice.intValue() == 3) {

            for (int h = 0; h < (lines - 1); h++) {
                for (int j = 0; j < lines - h - 1; j++) {
                    if (getWins(arrayList.get(j)) < getWins(arrayList.get(j + 1))) {
                        String temp = getClubName(arrayList.get(j)) + "/" + getWins(arrayList.get(j)) + "/" + getDraws(arrayList.get(j)) + "/" + getDefeats(arrayList.get(j)) + "/" + getGoalsReceived(arrayList.get(j)) + "/" + getGoalsSc(arrayList.get(j)) + "/" + getPoint(arrayList.get(j)) + "/" + getMatchesPl(arrayList.get(j));
                        String temp2 = getClubName(arrayList.get(j + 1)) + "/" + getWins(arrayList.get(j + 1)) + "/" + getDraws(arrayList.get(j + 1)) + "/" + getDefeats(arrayList.get(j + 1)) + "/" + getGoalsReceived(arrayList.get(j + 1)) + "/" + getGoalsSc(arrayList.get(j + 1)) + "/" + getPoint(arrayList.get(j + 1)) + "/" + getMatchesPl(arrayList.get(j + 1));
                        arrayList.set(j, temp2);
                        arrayList.set((j + 1), temp);
                    }
                }
            }
        }

            reader.close();
            //making a list to send values to the table
            List<FCClubs> list = new ArrayList<>();

            for (int x = 0; x < lines; x++) {
                String club = getClubName(arrayList.get(x));
                String wins = String.valueOf(getWins(arrayList.get(x)));
                String draws = getDraws(arrayList.get(x));
                String defeats = getDefeats(arrayList.get(x));
                String goalsRec = getGoalsReceived(arrayList.get(x));
                String goalsSc = String.valueOf(getGoalsSc(arrayList.get(x)));
                String points = String.valueOf(getPoint(arrayList.get(x)));
                String matchesPl = getMatchesPl(arrayList.get(x));

                list.add(new FCClubs(club, wins, draws, defeats, goalsRec, goalsSc, points, matchesPl));
            }
            return list;

    }

    public String getClubName(String s) {

        String parts[] = s.split("/");
        String clubAr = parts[0];
        return clubAr;
    }

    public int getWins(String s) {

        String parts[] = s.split("/");
        int winsAr = Integer.parseInt(parts[1]);
        return winsAr;
    }

    public String getDraws(String s) {

        String parts[] = s.split("/");
        String drawsAr = parts[2];
        return drawsAr;
    }

    public String getDefeats(String s) {

        String parts[] = s.split("/");
        String defeatsAr = parts[3];
        return defeatsAr;
    }

    public String getGoalsReceived(String s) {

        String parts[] = s.split("/");
        String goalsRecAr = parts[4];
        return goalsRecAr;
    }

    public int getGoalsSc(String s) {

        String parts[] = s.split("/");
        int goalsScAr = Integer.parseInt(parts[5]);
        return goalsScAr;
    }

    public int getPoint(String s) {

        String parts[] = s.split("/");
        int pointAr = Integer.parseInt(parts[6]);
        return pointAr;
    }

    public String getMatchesPl(String s) {

        String parts[] = s.split("/");
        String matchesPlAr = parts[7];
        return matchesPlAr;
    }
}
