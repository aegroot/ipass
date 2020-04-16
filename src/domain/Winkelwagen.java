package domain;

import java.util.ArrayList;

public class Winkelwagen {
    private Klant klant;
    private ArrayList<AssortimentProduct> producten;
    private String id;

    public ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

   public void remproduct(AssortimentProduct product){
        if (producten.contains(product)){
        product=null;}
   }
}
