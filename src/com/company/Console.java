package com.company;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Console {
    static LeagueManager sys = new PremierLeagueManager();

    public static boolean menu() throws IOException {

        Scanner input = new Scanner(System.in);
        boolean exit = false;

        File f1 = new File("PremierLeagueManager.txt");
        f1.createNewFile();
        File f2 = new File("PlayedMatches.txt");
        f2.createNewFile();

        System.out.println("Press the number according to your requirement");

        System.out.println("1 - Create a new Football Club");
        System.out.println("2 - Delete an existing club");
        System.out.println("3 - View statistics");
        System.out.println("4 - View premier league table");
        System.out.println("5 - Add a played football match");
        System.out.println("6 - Save all data in a file");
        System.out.println("7 - Open GUI");
        System.out.println("8 - Exit");
    try {
    int option = input.nextInt();

    switch (option) {
        case 1:
            sys.createFC();
            break;
        case 2:
            sys.deleteFC();
            break;
        case 3:
            sys.viewStatistics();
            break;
        case 4:
            sys.viewPLTableNew();
            break;
        case 5:
            sys.addPlayedMatch();
            break;
        case 6:
            sys.saveFile();
            break;
        case 7:
            GUI gui = new GUI();
            gui.mainCaller();
            break;
        case 8:
            System.out.println("Thank you. Have a nice day");
            exit = true;
            break;
        default:
            System.out.println("Please enter a valid number(1-7)");

    }
    }catch(Exception e){
        System.out.println("Please enter a valid option(1-7)\n");
    }
        return exit;

    }

    public static void main(String[] args) throws IOException {

        boolean exit = false;
        while (!exit){
            exit = menu();
        }

    }

}
