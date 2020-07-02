package domain;

import java.util.ArrayList;

public class Winkelwagen {
    private  ArrayList<AssortimentProduct> producten=new ArrayList<>();
    public  ArrayList<AssortimentProduct> getProducten() {
        return producten;
    }

    public void remproduct(AssortimentProduct product){
        if (producten.contains(product)){
        product=null;}
   }
   public AssortimentProduct getByid(int id){
       for (AssortimentProduct product:producten) {
           if (product.getId() == id){
               return product;
           }
       }
       return null;
   }
   public  void addproduct(AssortimentProduct product){producten.add(product);}
}
