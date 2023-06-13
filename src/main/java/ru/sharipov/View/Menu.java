package ru.sharipov.View;

import ru.sharipov.Model.MyToyShop;
import java.util.Scanner;

public class Menu implements ShopMenu {
    @Override
    public void mainMenu(MyToyShop myToyShop, Scanner scanner) {
        System.out.println("");
        System.out.println("-= My Toy Shop =-");
        System.out.println("");
        System.out.println("1. Look at Showcase ");
        System.out.println("");
        System.out.println("2. Look at Participants ");
        System.out.println("");
        System.out.println("3. Make a Draw! ");
        System.out.println("");
        System.out.println("9. Exit ");
        System.out.println();
        System.out.print("Enter a number from menu: ");
        String userInput = scanner.next();
        scanner.nextLine();
        if (userInput.equals("1")) showcaseMenu(myToyShop, scanner);
        else if (userInput.equals("2")) lookAtParticipantsMenu(myToyShop, scanner);
        else if (userInput.equals("3")) drawMenu(myToyShop, scanner);
        else if (userInput.equals("9")) {
            System.out.println();
            System.out.println("Good Bye! ");
            System.out.println();
            scanner.close();
        }
        else {
            System.out.println();
            System.out.println("INPUT ERROR: Enter a correct number from menu!");
            mainMenu(myToyShop,scanner);
        }

    }

    public void drawMenu(MyToyShop myToyShop, Scanner scanner) {
        System.out.println("");
        System.out.println("-= LET'S START A DRAW! =- ");
        System.out.println("");
        myToyShop.getOrganizer().startDraw(myToyShop);
        System.out.println("Draw is done! ");
        System.out.println();
        System.out.print("Enter a q to Exit in Main menu: ");
        String userInput = scanner.next();
        scanner.nextLine();
        if (userInput.equals("q") || userInput.equals("Q")) mainMenu(myToyShop,scanner);
        else {
            mainMenu(myToyShop,scanner);
        }
    }

    public void lookAtParticipantsMenu(MyToyShop myToyShop, Scanner scanner) {
        System.out.println("");
        System.out.println("-= MyToyShop Participants =- ");
        System.out.println("");
        System.out.println("1. Main menu ");
        System.out.println("");
        myToyShop.lookAtParticipants();
        System.out.println();
        System.out.print("Enter a number from menu: ");
        String userInput = scanner.next();
        scanner.nextLine();
        if (userInput.equals("1")) mainMenu(myToyShop,scanner);
        else {
            System.out.println();
            System.out.println("INPUT ERROR: Enter a correct number from menu!");
            lookAtParticipantsMenu(myToyShop,scanner);
        }
    }

    public void showcaseMenu(MyToyShop myToyShop, Scanner scanner){
        System.out.println("");
        System.out.println("-= MyToyShop Showcase =- ");
        System.out.println("");
        System.out.println("1. Main menu ");
        System.out.println("");
        myToyShop.lookAtShowcase();
        System.out.println();
        System.out.print("Enter a number from menu: ");
        String userInput = scanner.next();
        scanner.nextLine();
        if (userInput.equals("1")) mainMenu(myToyShop,scanner);
        else {
            System.out.println();
            System.out.println("INPUT ERROR: Enter a correct number from menu!");
            showcaseMenu(myToyShop,scanner);
        }
    }

}
