package ru.sharipov.Model;

import java.util.Iterator;
import java.util.List;

public class MyToyShop implements ToyShop {

    private List<Toy> showcase;
    private List<Participant> participantsList;
    private Organizer organizer;

    public MyToyShop(List showcase, List participantsList, Organizer organizer) {
        this.showcase = showcase;
        this.participantsList = participantsList;
        this.organizer = organizer;
    }

    @Override
    public void lookAtShowcase() {
        for (Toy toy : showcase)
            System.out.println(toy.toString());
    }

    public void correctShowcase(){
        Iterator<Toy> iterator = showcase.iterator();
        while (iterator.hasNext()){
            Toy toy = iterator.next();
            if (toy.getAmount() == 0){
                iterator.remove();
            }
        }
    }

    public void lookAtParticipants() {
        for (Participant participant : participantsList)
            System.out.println(participant.toString());
    }


    public Organizer getOrganizer() {
        return organizer;
    }

    public List<Participant> getParticipantsList() {
        return participantsList;
    }

    public List<Toy> getShowcase() {
        return showcase;
    }
}
