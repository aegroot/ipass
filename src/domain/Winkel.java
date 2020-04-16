package domain;

import java.util.ArrayList;

public class Winkel extends Account {
    private ArrayList<AssortimentProduct>producten;
    private String winkelcode;
    private double budget;

    public Winkel(String winkelcode,double budget) {
        this.winkelcode = winkelcode;
        this.budget=budget;
    }

    public void plusBudget(double prijs){
        if (prijs>=0){
            budget+=prijs;}
        else System.out.println(" geen negatieve nummers!");

    }

    public Double getBudget() {
        return this.budget;
    }
}
