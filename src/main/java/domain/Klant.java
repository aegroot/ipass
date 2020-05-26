package domain;

import java.util.ArrayList;

public class Klant extends Account{
    private double budget;
    private String naam;
    ArrayList<Product> products;
    private static Klant online;

    public static Klant getOnline() {
        return online;
    }

    public static void setOnline(Klant online) {
        Klant.online = online;
    }

    public void minusBudget(double prijs){
        if ((prijs<=budget)&&(prijs>=0)){
        budget-=prijs;}
        else if (prijs<=0) {System.out.println(" geen negatieve nummers!");}

    }

    public Klant(double budget,String naam,String username,String password) {
        super(username,password);
        this.budget = budget;
        this.naam=naam;

    }

    public double getBudget() {
        return budget;
    }

    public String getNaam() {
        return naam;
    }
    public void addProduct(Product product){products.add(product);}

    public ArrayList<Product> getProducts() {
        return products;
    }
}
