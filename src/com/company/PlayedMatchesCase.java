package com.company;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class PlayedMatchesCase {

    public void playedMatches() throws IOException {
        Stage fourthStage = new Stage();
        fourthStage.setTitle("Played matches");
        Pane root = new Pane();

        Label label = new Label(getPlayedMatches());

        root.getChildren().addAll(label);
        fourthStage.setWidth(800);
        fourthStage.setHeight(600);
        fourthStage.setScene(new Scene(root));
        fourthStage.show();
    }

    public String getPlayedMatches() throws IOException {
        File file = new File("PlayedMatches.txt");
        BufferedReader bFR = new BufferedReader(new FileReader(file));
        BufferedReader bFR2 = new BufferedReader(new FileReader(file));

        //        getting the total number of lines in the text file
        int lines = 0;
        while (bFR2.readLine() != null) {
            lines++;
        }
        bFR2.close();
        String currentLine;

        //        using list
        ArrayList<String> arrayList = new ArrayList();


        while ((currentLine = bFR.readLine()) != null) {
        //          taking 1st club name
            String f[] = currentLine.split(",");
            String c[] = f[1].split(": ");
            String club1 = c[1];

        //            taking 1st club goal score
            String d[] = f[2].split(": ");
            int club1Score = Integer.parseInt(d[1]);

        //            taking 2nd club name
            String e[] = f[3].split(": ");
            String club2 = e[1];

        //            taking 2nd club goals score
            String g[] = f[4].split(": ");
            int club2Score = Integer.parseInt(g[1]);

        //            taking year
            String h[] = f[0].split("/year=");
            int year = Integer.parseInt(h[1]);

        //            taking month
            String i[] = f[0].split("/year=");
            String j[] = i[0].split("/month=");
            int month = Integer.parseInt(j[1]);

        //            taking day
            String k[] = f[0].split("/month=");
            String l[] = k[0].split(": day=");
            int day = Integer.parseInt(l[1]);

            //            adding club name, points and goal difference to a array list
            arrayList.add("Match played date: day= "+day+" /month= "+month+" /year= "+year+" Club 1: "+club1+" C1 Goals Scored: "+club1Score+" Club 2: "+club2+" C2 Goals Scored: "+club2Score);

        }
        bFR.close();
        //Getting date in ascending order
        for (int h = 0; h < ( lines - 1 ); h++) {
            for (int j = 0; j < lines - h - 1; j++) {
                if (getYear(arrayList.get(j)) > getYear(arrayList.get(j + 1))) {
                    String temp = "Match played date: day= "+getDay(arrayList.get(j))+" /month= "+getMonth(arrayList.get(j))+" /year= "+getYear(arrayList.get(j))+" Club 1: "+getClub1(arrayList.get(j))+" C1 Goals Scored: "+getClub1Score(arrayList.get(j))+" Club 2: "+getClub2(arrayList.get(j))+" C2 Goals Scored: "+getClub2Score(arrayList.get(j));
                    String temp2 = "Match played date: day= "+getDay(arrayList.get(j+1))+" /month= "+getMonth(arrayList.get(j+1))+" /year= "+getYear(arrayList.get(j+1))+" Club 1: "+getClub1(arrayList.get(j+1))+" C1 Goals Scored: "+getClub1Score(arrayList.get(j+1))+" Club 2: "+getClub2(arrayList.get(j+1))+" C2 Goals Scored: "+getClub2Score(arrayList.get(j+1));
                    arrayList.set(j, temp2);
                    arrayList.set((j + 1), temp);
                }else if (getYear(arrayList.get(j)) == getYear(arrayList.get(j + 1))){
                    if (getMonth(arrayList.get(j)) > getMonth(arrayList.get(j+1))) {
                        String temp = "Match played date: day= " + getDay(arrayList.get(j)) + " /month= " + getMonth(arrayList.get(j)) + " /year= " + getYear(arrayList.get(j)) + " Club 1: " + getClub1(arrayList.get(j)) + " C1 Goals Scored: " + getClub1Score(arrayList.get(j)) + " Club 2: " + getClub2(arrayList.get(j)) + " C2 Goals Scored: " + getClub2Score(arrayList.get(j));
                        String temp2 = "Match played date: day= " + getDay(arrayList.get(j + 1)) + " /month= " + getMonth(arrayList.get(j + 1)) + " /year= " + getYear(arrayList.get(j + 1)) + " Club 1: " + getClub1(arrayList.get(j + 1)) + " C1 Goals Scored: " + getClub1Score(arrayList.get(j + 1)) + " Club 2: " + getClub2(arrayList.get(j + 1)) + " C2 Goals Scored: " + getClub2Score(arrayList.get(j + 1));
                        arrayList.set(j, temp2);
                        arrayList.set((j + 1), temp);
                    }
                } else if (getMonth(arrayList.get(j)) == getMonth(arrayList.get(j+1))){
                    if (getDay(arrayList.get(j)) > getDay(arrayList.get(j+1))) {
                        String temp = "Match played date: day= " + getDay(arrayList.get(j)) + " /month= " + getMonth(arrayList.get(j)) + " /year= " + getYear(arrayList.get(j)) + " Club 1: " + getClub1(arrayList.get(j)) + " C1 Goals Scored: " + getClub1Score(arrayList.get(j)) + " Club 2: " + getClub2(arrayList.get(j)) + " C2 Goals Scored: " + getClub2Score(arrayList.get(j));
                        String temp2 = "Match played date: day= " + getDay(arrayList.get(j + 1)) + " /month= " + getMonth(arrayList.get(j + 1)) + " /year= " + getYear(arrayList.get(j + 1)) + " Club 1: " + getClub1(arrayList.get(j + 1)) + " C1 Goals Scored: " + getClub1Score(arrayList.get(j + 1)) + " Club 2: " + getClub2(arrayList.get(j + 1)) + " C2 Goals Scored: " + getClub2Score(arrayList.get(j + 1));
                        arrayList.set(j, temp2);
                        arrayList.set((j + 1), temp);
                    }
                }
            }
        }

        String text = "";
        for (int x = 0; x < lines; x++) {
            text = text + arrayList.get(x)+"\n";
        }

        return text;
    }

    public int getYear(String s) {

        String a[] = s.split(" Club 1:");
        String b[] =a[0].split(" /year= ");
        int year = Integer.parseInt(b[1]);

        return year;
    }

    public int getMonth(String s) {

        String a[] = s.split(" /year= ");
        String b[] =a[0].split(" /month= ");
        int month = Integer.parseInt(b[1]);

        return month;
    }

    public int getDay(String s) {

        String a[] = s.split(" /month= ");
        String b[] =a[0].split(": day= ");
        int day = Integer.parseInt(b[1]);

        return day;
    }

    public String getClub1(String s) {

        String a[] = s.split(" C1 Goals Scored:");
        String b[] =a[0].split("Club 1: ");
        String club1 = b[1];

        return club1;
    }

    public String getClub1Score(String s) {

        String a[] = s.split(" Club 2:");
        String b[] =a[0].split("C1 Goals Scored: ");
        String club1Score = b[1];

        return club1Score;
    }

    public String getClub2(String s) {

        String a[] = s.split(" C2 Goals Scored:");
        String b[] =a[0].split("Club 2: ");
        String club2 = b[1];

        return club2;
    }

    public String getClub2Score(String s) {

        String a[] = s.split("C2 Goals Scored: ");
        String club2Score = a[1];

        return club2Score;
    }
}
