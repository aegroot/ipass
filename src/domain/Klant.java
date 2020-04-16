package domain;

public class Klant extends Account{
    private double budget;
    private String naam;

    public void minusBudget(double prijs){
        if ((prijs<=budget)&&(prijs>=0)){
        budget-=prijs;}
        else if (prijs<=0) {System.out.println(" geen negatieve nummers!");}

    }

    public Klant(double budget,String naam) {
        this.budget = budget;
        this.naam=naam;
    }

    public double getBudget() {
        return budget;
    }

    public String getNaam() {
        return naam;
    }
}
