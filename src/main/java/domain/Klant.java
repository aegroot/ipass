package domain;

import java.util.ArrayList;

public class Klant extends Account{
    private double budget;
    private String naam;
    ArrayList<Product> products;
    private static Klant online;
    private Winkelwagen winkelwagen;
    private static ArrayList<Klant>klants;


    public void minusBudget(double prijs){
        if ((prijs<=budget)&&(prijs>=0)){
        budget-=prijs;}
        else if (prijs<=0) {System.out.println(" geen negatieve nummers!");}

    }

    public Klant(String naam,String username,String password) {
        super(username,password);
        this.naam=naam;

    }




    public static Klant getbyaccount(String username,String password){
        for (Klant winkel:klants) {
            if((winkel.getUsername()==username)&&(winkel.password==password)){
                return winkel;
            }
        }
        return null;
    }
    public void addProduct(Product product){products.add(product);}

    public ArrayList<Product> getProducts() {
        return products;
    }
    public double getBudget() {
        return budget;
    }

    public String getNaam() {
        return naam;
    }
    public Winkelwagen getWinkelwagen() {
        return winkelwagen;
    }

    public void setWinkelwagen(Winkelwagen winkelwagen) {
        this.winkelwagen = winkelwagen;
    }

    public static Klant getOnline() {
        return online;
    }

    public static void setOnline(Klant online) {
        Klant.online = online;
    }
}
