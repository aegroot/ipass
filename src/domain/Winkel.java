package domain;

import java.util.ArrayList;

public class Winkel extends Account {
    private ArrayList<AssortimentProduct>producten;
    private String winkecode;
    private double budget;

    public void plusBudget(double prijs){
        if (prijs>=0){
            budget+=prijs;}
        else System.out.println(" geen negatieve nummers!");

    }
}
