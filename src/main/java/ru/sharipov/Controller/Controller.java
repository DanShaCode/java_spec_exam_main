package ru.sharipov.Controller;

import ru.sharipov.Model.MyToyShop;
import ru.sharipov.Model.Organizer;
import ru.sharipov.Model.Participant;
import ru.sharipov.Model.Toy;
import ru.sharipov.View.Menu;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Controller {
    public Controller(){
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);

        List<Toy> showcase = new ArrayList<>();
        showcase.add(new Toy("Bear",5,51.34));
        showcase.add(new Toy("Doll", 5, 12.65));
        showcase.add(new Toy("Spider-man", 5, 5));

        List<Participant> participantList = new LinkedList<>();
        List<Toy> danisBackpack = new ArrayList<>();
        List<Toy> annaBackpack = new ArrayList<>();
        List<Toy> artemBackpack = new ArrayList<>();
        participantList.add(new Participant("Danis", danisBackpack));
        participantList.add(new Participant("Anna", annaBackpack));
        participantList.add(new Participant("Artem", artemBackpack));

        Organizer organizer = new Organizer();

        MyToyShop myToyShop = new MyToyShop(showcase, participantList, organizer);
        menu.mainMenu(myToyShop, scanner);
    }
}
