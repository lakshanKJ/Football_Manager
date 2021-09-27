package com.company;

import java.io.*;
import java.util.*;

public class PremierLeagueManager implements LeagueManager {

    UniversityFootballClub uFC = new UniversityFootballClub();
    SchoolFootballClub sFC = new SchoolFootballClub();

    @Override
    public void createFC() throws IOException {

        FileWriter f1W = new FileWriter("PremierLeagueManager.txt",true);
        Scanner input = new Scanner(System.in);

        System.out.println("---Fill the following about the football club---\n");

        System.out.println("What is your football club type?(Press 1 if it is a University football club," +
                " press 2 if it is a School football club): ");
        try {

            int choice = input.nextInt();
            if (choice==1) {
                System.out.print("University name: ");
                String name = input.next();
                uFC.setUniName(name.toUpperCase());

                System.out.print("Total wins of the football club: ");
                int wins = input.nextInt();
                uFC.setuFCWins(wins);

                System.out.print("Total draws of the football club: ");
                int draws = input.nextInt();
                uFC.setuFCDraws(draws);

                System.out.print("Total defeats of the football club: ");
                int defeats = input.nextInt();
                uFC.setuFCDefeats(defeats);

                System.out.print("Total goals received: ");
                int goalsReceived = input.nextInt();
                uFC.setuFCGoalsReceived(goalsReceived);

                System.out.print("Total goals scored: ");
                int goalsScored = input.nextInt();
                uFC.setuFCGoalsScored(goalsScored);

                System.out.print("Total points of the football club: ");
                int points = input.nextInt();
                uFC.setuFCPoints(points);

                System.out.print("Total matches played by the football club: ");
                int matchesPlayed = input.nextInt();
                uFC.setuFCMatchesPlayed(matchesPlayed);
                //writing in the text file
                f1W.write("University name: " + uFC.getUniName());
                f1W.write(",Wins: " + uFC.getuFCWins());
                f1W.write(",Draws: " + uFC.getuFCDraws());
                f1W.write(",Defeats: " + uFC.getuFCDefeats());
                f1W.write(",Goals received: " + uFC.getuFCGoalsReceived());
                f1W.write(",Goals scored: " + uFC.getuFCGoalsScored());
                f1W.write(",Points: " + uFC.getuFCPoints());
                f1W.write(",Matches played: " + uFC.getuFCMatchesPlayed()+"\n");
                f1W.close();
                System.out.println("Club successfully added");

            }else {
                System.out.print("School name: ");
                String name = input.next();
                sFC.setSchoolName(name.toUpperCase());

                System.out.print("Total wins of the football club: ");
                int wins = input.nextInt();
                sFC.setsFCWins(wins);

                System.out.print("Total draws of the football club: ");
                int draws = input.nextInt();
                sFC.setsFCDraws(draws);

                System.out.print("Total defeats of the football club: ");
                int defeats = input.nextInt();
                sFC.setsFCDefeats(defeats);

                System.out.print("Total goals received: ");
                int goalsReceived = input.nextInt();
                sFC.setsFCGoalsReceived(goalsReceived);

                System.out.print("Total goals scored: ");
                int goalsScored = input.nextInt();
                sFC.setsFCGoalsScored(goalsScored);

                System.out.print("Total points of the football club: ");
                int points = input.nextInt();
                sFC.setsFCPoints(points);

                System.out.print("Total matches played by the football club: ");
                int matchesPlayed = input.nextInt();
                sFC.setsFCMatchesPlayed(matchesPlayed);
                //writing in the text file
                f1W.write("School name: "+sFC.getSchoolName());
                f1W.write(",Wins: " + sFC.getsFCWins());
                f1W.write(",Draws: " + sFC.getsFCDraws());
                f1W.write(",Defeats: " + sFC.getsFCDefeats());
                f1W.write(",Goals received: " + sFC.getsFCGoalsReceived());
                f1W.write(",Goals scored: " + sFC.getsFCGoalsScored());
                f1W.write(",Points: " + sFC.getsFCPoints());
                f1W.write(",Matches played: " + sFC.getsFCMatchesPlayed()+"\n");
                f1W.close();
                System.out.println("Club successfully added");
            }
        } catch (Exception e) {
            System.out.println("Please enter valid details\n");
        }
    }

    @Override
    public void deleteFC() throws IOException{
        Scanner input = new Scanner(System.in);
        File file = new File("PremierLeagueManager.txt");
        File tempFile = new File("TempFile.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

        System.out.println("Enter the club name You want to delete: ");
        String clubToRemove = input.next().toUpperCase();

        boolean check = checkForClub(clubToRemove);
        if (check==true) {
            String currentLine;

            while ((currentLine = reader.readLine()) != null) {

                String f[] = currentLine.split(",");

                String fCNameEntity = f[0];
                String g[] = fCNameEntity.split(": ");
                String fCName = g[1];

                if (fCName.equals(clubToRemove.toUpperCase())) continue;
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            System.out.println("Club successfully deleted");
            writer.close();
            reader.close();
            tempFile.renameTo(file);
        }else System.out.println("There is no such club registered in the premier league\n");
    }

    @Override
    public void viewStatistics() throws IOException{
        Scanner input = new Scanner(System.in);
        File file = new File("PremierLeagueManager.txt");
        BufferedReader reader = new BufferedReader(new FileReader(file));

        System.out.println("Enter the club name that You want to view statistics: ");
        String clubToSearch = input.next();
        String currentLine;

        while ((currentLine = reader.readLine()) != null){

            String f[] = currentLine.split(",");
            String fCNameEntity = f[0];
            String g[] = fCNameEntity.split(": ");
            String fCName = g[1];

            if (fCName.equals(clubToSearch.toUpperCase())){
                System.out.println(currentLine);
            }
        }
        reader.close();
    }

    public int getPoint(String s) {

        String a[] = s.split(" #");
        String b[] =a[0].split("= ");
        int number = Integer.parseInt(b[1]);

        return number;
    }

    public String getClubName(String s) {

        String parts[] = s.split(": ");
        String cName = parts[0];

        return cName;
    }

    public int getGoalDif(String s) {

        String a[] = s.split(" #");
        String b[] =a[1].split("= ");
        int gDifference = Integer.parseInt(b[1]);
        return gDifference;
    }

    @Override
    public void  viewPLTableNew() throws IOException{
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




//        using list
        ArrayList<String> arrayList = new ArrayList();


        while ((currentLine = reader.readLine()) != null) {
//          taking club name
            String f[] = currentLine.split(",");
            String c[] = f[0].split(": ");
            String club = c[1];

//            taking points
            String pointEntity = f[6];
            String g[] = pointEntity.split(": ");
            String pointNumber = g[1];

//            taking goals received
            String gR[] = f[4].split(": ");
            int goalsReceived = Integer.parseInt(gR[1]);

//            taking goals scored
            String gS[] = f[5].split(": ");
            int goalsScored = Integer.parseInt(gS[1]);

            int goalDifference = goalsReceived - goalsScored;

            //            adding club name, points and goal difference to a array list
            arrayList.add(club+": *Points= "+pointNumber+" #Goal difference= "+goalDifference);

        }

        for (int h = 0; h < ( lines - 1 ); h++) {
            for (int j = 0; j < lines - h - 1; j++) {
                if (getPoint(arrayList.get(j)) < getPoint(arrayList.get(j + 1))) {
                    String temp = getClubName(arrayList.get(j))+": *Points= "+getPoint(arrayList.get(j))+" #Goal difference= "+getGoalDif(arrayList.get(j));
                    String temp2 = getClubName(arrayList.get(j+1))+": *Points= "+getPoint(arrayList.get(j + 1))+" #Goal difference= "+getGoalDif(arrayList.get(j + 1));
                    arrayList.set(j,temp2);
                    arrayList.set((j + 1),temp);
                } else if (getPoint(arrayList.get(j)) == getPoint(arrayList.get(j + 1))) {
                    if (getGoalDif(arrayList.get(j)) < getGoalDif(arrayList.get(j + 1))) {
                        String temp = getClubName(arrayList.get(j))+": *Points= "+getPoint(arrayList.get(j))+" #Goal difference= "+getGoalDif(arrayList.get(j));
                        String temp2 = getClubName(arrayList.get(j+1))+": *Points= "+getPoint(arrayList.get(j + 1))+" #Goal difference= "+getGoalDif(arrayList.get(j + 1));
                        arrayList.set(j,temp2);
                        arrayList.set((j + 1),temp);
                    }
                }
            }
        }

        for (int x = 0; x < lines; x++)
            System.out.println(arrayList.get(x));

        reader.close();

    }

    public boolean checkForClub(String clubName) throws IOException{

        BufferedReader bf1 = new BufferedReader(new FileReader("PremierLeagueManager.txt"));
        String currentLine;
        boolean checker = false;
        outerLoop:
        while ((currentLine = bf1.readLine()) != null){

            String lineSplit[] = currentLine.split(",");
            String fCNameEntity = lineSplit[0];
            String a[] = fCNameEntity.split(": ");
            String fCName = a[1];
            if (fCName.equals(clubName)){
                checker = true;
                break outerLoop;
            }
        }
        return checker;
    }

    @Override
    public void addPlayedMatch() throws IOException{

        FileWriter f2W = new FileWriter("PlayedMatches.txt",true);
        Scanner input = new Scanner(System.in);
        BufferedReader bf1 = new BufferedReader(new FileReader("PremierLeagueManager.txt"));
        try {

            System.out.println("Fill the following information\n");

            System.out.println("Name of the 1st football club");
            String club1 = input.nextLine().toUpperCase();

            //        check if there is such a club registered in the database
            boolean check1 = checkForClub(club1);
            if (check1==true) {

                System.out.println("Number of goals scored");
                int club1GoalsSc = input.nextInt();
                System.out.println("Name of the 2nd football club");
                String club2 = input.next().toUpperCase();

                //        check if there is such a club registered in the database
                boolean check2 = checkForClub(club2);
                if (check2==true) {

                    System.out.println("Number of goals scored");
                    int club2GoalsSc = input.nextInt();

                    System.out.println("Match played day(in numbers)");
                    int day = input.nextInt();
                    System.out.println("Match played month(in numbers)");
                    int month = input.nextInt();
                    System.out.println("Match played year");
                    int year = input.nextInt();

                    Date date = new Date(day, month, year);

                    f2W.write("Match played date: " + date);
                    f2W.write(",FC 1 name: " + club1);
                    f2W.write(",FC 1 goals scored: " + club1GoalsSc);
                    f2W.write(",FC 2 name: " + club2);
                    f2W.write(",FC 2 goals scored: " + club2GoalsSc + "\n");
                    f2W.close();

                    System.out.println("Match successfully added\n");

    //        Statistics calculation of clubs
    //        getting the clubs' results
                    int matchResult = club1GoalsSc - club2GoalsSc;
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
                    int club1GoalsRec = club2GoalsSc;
                    int club2GoalsRec = club1GoalsSc;

                    String currentLine;

                    while ((currentLine = bf1.readLine()) != null) {

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
                        if (fCName.equals(club1)) {

                            //New updated details(calculations)
                            int newWins = (winsNumber + club1WinStatus);
                            int newDraws = (drawsNumber + club1DrawStatus);
                            int newDefeats = (defeatsNumber + club1DefeatStatus);
                            int newGoalsRec = (goalsRecNumber + club1GoalsRec);
                            int newGoalsSc = (goalsScNumber + club1GoalsSc);
                            int newPoints = (pointNumber + club1Points);
                            int newMatchesPlayed = (matchesPlayedNumber + 1);

                            updateTextFile(currentLine, club1, newWins, newDraws, newDefeats, newGoalsRec, newGoalsSc, newPoints, newMatchesPlayed);
                        }

                        //            club 2 statistics update
                        if (fCName.equals(club2)) {

                            //New updated details(calculations)
                            int newWins = (winsNumber + club2WinStatus);
                            int newDraws = (drawsNumber + club2DrawStatus);
                            int newDefeats = (defeatsNumber + club2DefeatStatus);
                            int newGoalsRec = (goalsRecNumber + club2GoalsRec);
                            int newGoalsSc = (goalsScNumber + club2GoalsSc);
                            int newPoints = (pointNumber + club2Points);
                            int newMatchesPlayed = (matchesPlayedNumber + 1);

                            updateTextFile(currentLine, club2, newWins, newDraws, newDefeats, newGoalsRec, newGoalsSc, newPoints, newMatchesPlayed);
                        }

                    }
                    System.out.println("club statistics updated");
                    bf1.close();
                }else System.out.println("There is no such FC club registered in premier league");
            }else System.out.println("There is no such FC club registered in premier league");

        } catch (Exception e) {
            System.out.println("Please enter valid details\n");
        }
    }

    public void updateTextFile(String currentLine,String clubName,int wins,int draws,int defeats,int gRec,int gScored,int points,int matchesPlayed) throws IOException{
        //file class
        File file = new File("PremierLeagueManager.txt");
        //Instantiating  the Scanner  class to read the file
        Scanner sc = new Scanner(file);

        //StringBuffer class
        StringBuffer buffer = new StringBuffer();

        //Reading lines of the PremierLeague text file, then appending them to StringBuffer

        while (sc.hasNextLine()) {
            buffer.append(sc.nextLine()+System.lineSeparator());
        }

        //        Contents of the PremierLeague text file
        String fileContents = buffer.toString();
        //closing  Scanner
        sc.close();
        String oldLine = currentLine;
        String newLine = "University name: "+clubName+",Wins: "+wins+",Draws: "+draws+",Defeats: "+defeats+",Goals received: "+gRec+",Goals scored: "+gScored+",Points: "+points+",Matches played: "+matchesPlayed;

        //Changing the old line to a new line
        fileContents = fileContents.replaceAll(oldLine, newLine);
        //calling the FileWriter class
        FileWriter writer = new FileWriter(file);
        writer.append(fileContents);
        writer.flush();
        writer.close();
    }

    @Override
    public void saveFile() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Save your file as: ");
        String saveFileName = sc.next()+".txt";
        //initiating file classes
        File sourceFile = new File("PremierLeagueManager.txt");
        File saveAsFile = new File(saveFileName);
        //initiating FileInputStream and FileOutputStream classes
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        inputStream = new FileInputStream(sourceFile);
        outputStream = new FileOutputStream(saveAsFile);

        //        creating one byte array with length 1024
        byte[] buffer = new byte[1024];
        int length;

        //   Till the  end of inputStream, read the 1024  bytes  of data  into  buffer  array
        //   and write  the same data  into  outputStream.
        while ((length = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, length);
        }
        outputStream.flush();
        inputStream.close();
        outputStream.close();

        System.out.println("Saving successful, Find your file at the end of the programme, Thank you.\n");
    }
}