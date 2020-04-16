package domain;

public class Klant extends Account{
    private double budget;
    private String naam;

    public void minusBudget(double prijs){
        if (prijs>=0){
        budget-=prijs;}
        else System.out.println(" geen negatieve nummers!");
    }

    public double getBudget() {
        return budget;
    }

    public String getNaam() {
        return naam;
    }
}
