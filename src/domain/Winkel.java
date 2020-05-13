package domain;

import java.util.ArrayList;

public class Winkel extends Account {
    private ArrayList<AssortimentProduct>producten;
    private String winkelcode;
    private double budget;
    private String stad;

    public Winkel(String winkelcode,double budget,String stad) {
        this.winkelcode = winkelcode;
        this.budget=budget;
        this.stad=stad;
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
