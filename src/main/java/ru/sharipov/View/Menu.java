package ru.sharipov.View;

import ru.sharipov.Model.MyToyShop;
import ru.sharipov.Model.Toy;

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
        System.out.println("4. Add Toy ");
        System.out.println("");
        System.out.println("5. Change Toy chance ");
        System.out.println("");
        System.out.println("9. Exit ");
        System.out.println();
        System.out.print("Enter a number from menu: ");
        String userInput = scanner.next();
        scanner.nextLine();
        if (userInput.equals("1")) showcaseMenu(myToyShop, scanner);
        else if (userInput.equals("2")) lookAtParticipantsMenu(myToyShop, scanner);
        else if (userInput.equals("3")) drawMenu(myToyShop, scanner);
        else if (userInput.equals("4")) addToyMenu(myToyShop, scanner);
        else if (userInput.equals("5")) setToyChanceMenu(myToyShop, scanner);
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

    public void setToyChanceMenu(MyToyShop myToyShop, Scanner scanner) {
        System.out.println("");
        System.out.println("-= Set Toy Chance Menu =- ");
        System.out.println("");
        System.out.print("Enter an ID of Toy: ");
        String toyId = scanner.next();
        scanner.nextLine();
        System.out.println();
        System.out.print("Enter a new chance: ");
        String toyChance = scanner.next();
        scanner.nextLine();
        System.out.println();
        if (!(toyId.isEmpty()) && !(toyChance.isEmpty())){
            try {
                int id = Integer.parseInt(toyId);
                double chance = Double.parseDouble(toyChance);
                if (chance > 0 && chance < 101){
                    for (Toy toy: myToyShop.getShowcase()){
                        if (toy.getId() == id){
                            toy.setChance(chance);
                        }
                    }
                    System.out.println("Chance changed! ");
                    mainMenu(myToyShop,scanner);
                } else {
                    System.out.println("Chance can not be less than 0 and more than 100!");
                    mainMenu(myToyShop,scanner);
                }
            } catch (NumberFormatException exception){
                System.out.println("Enter a correct data! ");
                mainMenu(myToyShop,scanner);
            }
        }
    }

    public void addToyMenu(MyToyShop myToyShop, Scanner scanner) {
        System.out.println("");
        System.out.println("-= Add Toy Menu =-");
        System.out.println("");
        System.out.print("Enter a Toy name: ");
        String toyName = scanner.next();
        scanner.nextLine();
        System.out.println();
        System.out.print("Enter a Toy amount: ");
        String toyAmount = scanner.next();
        scanner.nextLine();
        System.out.println();
        System.out.print("Enter a Toy chance: ");
        String toyChance = scanner.next();
        scanner.nextLine();
        System.out.println();
        if(!(toyName.isEmpty()) && !(toyAmount.isEmpty()) && !(toyChance.isEmpty())){
            try {
                String name = toyName;
                int amount = Integer.parseInt(toyAmount);
                double chance = Double.parseDouble(toyChance);
                if (chance > 0 && chance < 101){
                    myToyShop.getShowcase().add(new Toy(name,amount,chance));
                    System.out.println("Toy added! ");
                    mainMenu(myToyShop,scanner);
                } else {
                    System.out.println("Chance can not be less than 0 and more than 100!");
                    mainMenu(myToyShop,scanner);
                }
            } catch (NumberFormatException exception){
                System.out.println("Enter a correct data!");
                mainMenu(myToyShop,scanner);
            }
        } else {
            System.out.println("Field can not be Empty! ");
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
