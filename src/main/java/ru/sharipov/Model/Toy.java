package ru.sharipov.Model;

import java.util.Random;

public class Toy {
    private int id;
    private String name;
    private int amount;
    private double chance;

    public Toy(String name, int amount, double chance){
        id = new Random().nextInt(0, 1_000_000);
        this.name = name;
        this.amount = amount;
        this.chance = chance;
    }

    @Override
    public String toString(){
        return "ID: " + id + " | " + "Name: " + name + " | " + "Amount: " + amount + " | " + "Chance %: " + chance;
    }
    public void removeToy(int amount){
        if (this.amount >= amount){
            this.amount -= amount;
        }
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setChance(double chance) {
        this.chance = chance;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAmount() {
        return amount;
    }

    public double getChance() {
        return chance;
    }
}
