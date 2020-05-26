package domain;

public class Transactie {
    private Klant klant;
    private Winkel winkel;
    private Winkelwagen winkelwagen;

    public double getTotaalPrijs(){
        int total = 0;
        for (AssortimentProduct product:winkelwagen.getProducten()
             ) { total+=product.getNieuwprijs(); }
        return total;
    }

    public void handelaf(){klant.minusBudget(getTotaalPrijs());
    if (klant.getBudget()>getTotaalPrijs()){
    winkel.plusBudget(getTotaalPrijs());}
    else System.out.println(klant.getNaam()+"heeft niet genoeg geld");}


}
