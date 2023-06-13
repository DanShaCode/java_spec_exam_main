package ru.sharipov.View;

import ru.sharipov.Model.MyToyShop;

import java.util.Scanner;

public interface ShopMenu {
    void mainMenu(MyToyShop myToyShop, Scanner scanner);
    void lookAtParticipantsMenu(MyToyShop myToyShop, Scanner scanner);
    void showcaseMenu(MyToyShop myToyShop, Scanner scanner);
    void drawMenu(MyToyShop myToyShop, Scanner scanner);
}
