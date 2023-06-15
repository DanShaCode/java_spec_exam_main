package ru.sharipov.Model;

import java.util.List;

public class Participant {
    private String name;
    private List<Toy> backpack;

    public Participant(String name, List backpack){
        this.name = name;
        this.backpack = backpack;
    }

    @Override
    public String toString(){
        return "Name: " + name + " | " + "Backpack: " + getBackpack();
    }

    public String getName() {
        return name;
    }

    public List<Toy> getBackpack() {
        return backpack;
    }
}
