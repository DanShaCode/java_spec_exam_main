package ru.sharipov.Model;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

public class Organizer {

    public static boolean rollTheCube(Toy toy) {
        return toy.getChance() <= new Random().nextInt(1, 101);
    }

    public void startDraw(MyToyShop myToyShop) {

        Queue<Participant> participantsQueue = new LinkedList<>(myToyShop.getParticipantsList());

        while (!participantsQueue.isEmpty()) {
            Participant participant = participantsQueue.poll();
            System.out.println("Draw is starting for: " + participant.getName() + "!");
            for (Toy toy : myToyShop.getShowcase()) {
                if (toy.getAmount() > 0) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (rollTheCube(toy)) {
                        toy.removeToy(1);
                        Toy participantToy = new Toy(toy.getName(), 1, toy.getChance());
                        participantToy.setId(toy.getId());
                        participant.getBackpack().add(participantToy);
                        System.out.println("Congratulation " + participant.getName()
                                + " you win " + toy.getName() + "!");
                        System.out.println();
                    } else {
                        System.out.println("Sorry " + participant.getName() + " but luck not on your way today! ");
                        System.out.println();
                    }
                    break;
                }
            }

            myToyShop.correctShowcase();

        }
    }
}
