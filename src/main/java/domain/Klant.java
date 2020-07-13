package domain;

import java.sql.SQLException;
import java.util.ArrayList;


public class Klant extends Account{
    private double budget;
    private String naam;
    ArrayList<Product> products;
    private static Klant online=null;
    private Winkelwagen winkelwagen;
    private static ArrayList<Klant>klants;

    public static Klant getbyUsername(String username){
        for (Klant klant:klants) {
            if (klant.getUsername()==username)
                return klant;
        }

            return null;

    }

    public void minusBudget(double prijs){
        if ((prijs<=budget)&&(prijs>=0)){
        budget-=prijs;}
        else if (prijs<=0) {System.out.println(" geen negatieve nummers!");}

    }
    public void rekenAf(){
        for (AssortimentProduct product:winkelwagen.getProducten())
        {
            minusBudget(product.berekenprijs());
        }}

    public Klant(String naam,String username,String password) throws SQLException {
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
    public static void logOut(){online=null;}


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
