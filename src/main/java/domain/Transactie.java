package domain;

import java.util.ArrayList;

public class Transactie {
    private Winkel winkel;
    private  Klant klant;
    private ArrayList<AssortimentProduct>assortimentProducts;

    public Transactie(Winkel winkel,Klant klant) {
        this.winkel=winkel;
        this.klant = klant;
    }
    public void addToList(AssortimentProduct product){
        assortimentProducts.add(product);
    }

}