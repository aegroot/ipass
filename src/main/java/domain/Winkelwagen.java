package domain;

import java.util.ArrayList;

public class Winkelwagen {
    private Klant klant;
    private ArrayList<AssortimentProduct> producten=new ArrayList<>();
    private int id;

    public ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }

    public Winkelwagen(int id) {
        this.id = id;
    }

    public void setKlant(Klant klant) {
        this.klant = klant;
    }

   public void remproduct(AssortimentProduct product){
        if (producten.contains(product)){
        product=null;}
   }


   public void addproduct(AssortimentProduct product){producten.add(product);}
}
