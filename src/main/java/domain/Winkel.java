package domain;

import java.util.ArrayList;

public class Winkel extends Account {
    private ArrayList<AssortimentProduct>producten;
    private String winkelcode;
    private double budget;
    private String stad;
    private static ArrayList<Winkel>winkels;
    private static Winkel winkelonline;

    public static ArrayList<Winkel> getWinkels() {
        return winkels;
    }

    public static void setWinkelonline(Winkel winkelonline) {
        Winkel.winkelonline = winkelonline;
    }

    public void setWinkelcode(String winkelcode) {
        this.winkelcode = winkelcode;
    }

    public String getWinkelcode() {
        return winkelcode;
    }

    public static Winkel getwinkelbycode(String code){
        for (Winkel winkel:winkels) {
            if (winkel.getWinkelcode()==code){
                return winkel;

            }
        }

        return null;
    }

    public static Winkel getWinkelonline() {
        return winkelonline;
    }




    public Winkel(String username,String password,String winkelcode,double budget,String stad) {
        super(username, password);
        this.winkelcode = winkelcode;
        this.budget=budget;
        this.stad=stad;
        winkels.add(this);
    }

    public void plusBudget(double prijs){
        if (prijs>=0){
            budget+=prijs;}
        else System.out.println(" geen negatieve nummers!");

    }

    public Double getBudget() {
        return this.budget;
    }

    public ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }
}

